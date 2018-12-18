package com.epam.se06;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.array;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.blankString;
import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItemInArray;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.in;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.matchesPattern;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.oneOf;
import static org.hamcrest.Matchers.startsWith;

class MatchersExample {

    @Test
    void objectMatchers() {
        assertThat(10, hasToString("10"));
        assertThat(10, any(Number.class));
        assertThat(10, notNullValue());
        assertThat(null, nullValue());

        Integer[] values = {1, 2, 3, 6, 2, 1, 10};
        assertThat(6, in(values));
        assertThat(6, oneOf(1, 2, 3, 4, 5, 6));
    }

    @Test
    void stringMatchers() {
        assertThat("11111 22222", matchesPattern("1+\\s2+"));

        A object = new A(70, true);
        assertThat(object, hasProperty("value", both(greaterThan(40)).and(lessThan(60))));
        assertThat(object, hasProperty("flag", is(true)));
    }

    @Test
    void arrays() {
        String[] strings = {"aqweqweb", "123", "   ", null};

        assertThat(strings, array(startsWith("a"), matchesPattern("\\d+"), blankString(), nullValue()));
        assertThat(strings, arrayWithSize(4));
        assertThat(strings, hasItemInArray(allOf(startsWith("a"), endsWith("b"))));
    }
}

