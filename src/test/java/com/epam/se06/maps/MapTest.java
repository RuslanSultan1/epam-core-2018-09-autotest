package com.epam.se06.maps;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.function.Function;

import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.hamcrest.MatcherAssert.assertThat;

class MapTest {

    @Test
    void putNullValue() {
        Map<Integer, String> map = new HashMap<>(0, 1000000f);
        assertNull(map.put(1, "1"));
        assertEquals("1", map.put(1, "11"));

        assertNull(map.put(2, "2"));
        assertEquals("2", map.put(2, "22"));

        assertNull(map.put(3, null));
        assertTrue(map.containsKey(3));
        assertNull(map.put(3, "22"));
        assertTrue(map.containsValue("22"));

        assertNull(map.put(null, "null"));
        assertTrue(map.containsKey(null));

        System.out.println(map);

        Set<Integer> integers = map.keySet();
        integers.remove(3);

        System.out.println(map);

        Set<Map.Entry<Integer, String>> entries = map.entrySet();
    }

    /**
     * O(1) ~ O(log(n))    put(K, V)
     * O(1) ~ O(log(n))    get(Object)
     * O(1) ~ O(log(n))    remove(Object)
     */
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();

        map.put(5, "abc1");
        map.put(5, "abc2");
        map.put(5, "abc3");

    }

    @Test
    void linkedHashMap() {
        Map<String, String> hashMap = new LinkedHashMap<>();
        hashMap.put("123", "123");
        hashMap.put("abc", "abc");
        hashMap.put("qw45", "qw45");
        System.out.println(hashMap);

        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    @Test
    void treeMap() {
        TreeMap<A, Integer> map = new TreeMap<>(Comparator.comparing(A::getStr));
        map.put(new A(3, "c"), 3);
        map.put(new A(4, "b"), 4);
        map.put(new A(1, "a"), 1);
        map.put(new A(2, "d"), 2);
        System.out.println(map);
    }

    @Test
    void identity() {
        Map<A, String> map = new IdentityHashMap<>();

        A a1 = new A(1, "a");
        A a2 = new A(1, "a");
        assertNotSame(a1, a2);
        assertEquals(a1, a2);

        map.put(a1, "value");
        assertNotNull(map.get(a1));
        assertNull(map.get(a2));
    }

    @Test
    void containsEntryWithCondition() {
        Map<String, Integer> source = new HashMap<>();

//        source.put("World1", 80);
        source.put("Hello1", 42);
        source.put("Hello2", 73);

        assertThat(source, hasEntry(startsWith("World"), greaterThan(50)));
    }

    @Test
    void putIf() {
        Map<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        map.put("2", 2);

        // "1" -> 11
        if (!map.containsKey("1")) {
            map.put("1", 11);
        }
        assertThat(map, hasEntry("1", 1));

        map.putIfAbsent("1", 11);
        assertThat(map, hasEntry("1", 1));

        map.computeIfAbsent("3", Integer::valueOf);
        assertThat(map, hasEntry("3", 3));

        map.computeIfAbsent("3", string -> Integer.valueOf(string + string));
        assertThat(map, hasEntry("3", 3));

        map.computeIfPresent("3", (key, prev) -> prev + 1);
        assertThat(map, hasEntry("3", 4));

        map.compute("4", (key, prev) -> prev == null ? 42 : 0);
        assertThat(map, hasEntry("4", 42));

        map.compute("4", (key, prev) -> prev == null ? 42 : 0);
        assertThat(map, hasEntry("4", 0));

        map.replaceAll((key, value) -> -value);
        assertThat(map, both(hasEntry("1", -1)).and(hasEntry("3", -4)));

        map.forEach((key, value) -> System.out.println(key + " " + value));

        Integer val = map.getOrDefault("195", 195);
        assertThat(val, is(195));
    }

    @Test
    void mergeMaps() {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("1", 1);
        map1.put("2", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("1", 1);
        map2.put("3", 3);
        map2.put("4", 4);

        Map<String, Integer> map3 = new HashMap<>(map2);
        map1.forEach((key, value) -> map3.merge(key, value, Integer::sum));
//        map1.forEach((key1, value) -> map3.compute(key1, (key, prev) -> value + (prev == null ? 0 : prev)));
    }
}

@ToString
@Getter
@AllArgsConstructor
@EqualsAndHashCode
class A implements Comparable<A> {
    int field;
    String str;

    @Override
    public int compareTo(A other) {
        return Integer.compare(field, other.field);
    }
}