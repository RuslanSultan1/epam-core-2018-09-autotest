package com.epam.se06.streams;

import lombok.Value;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.sameInstance;

class StreamTest {

    private Collection<Employee> employees;

    @BeforeEach
    void createEmployees() {
        employees = getEmployees();
    }

    @Test
    void name() {
        long countIvans = employees.stream()
                                   .map(Employee::getPerson)
                                   .filter(person -> person.getFirstName().equals("Иван"))
                                   .peek(System.out::println)
                                   .count();

        System.out.println(countIvans);


//        int countIvans = 0;
//        for (Employee employee : employees) {
//            Person person = employee.getPerson();
//            if (person.getFirstName().equals("Иван")) {
//                System.out.println(person.getFullName());
//                ++countIvans;
//            }
//        }
//        System.out.println(countIvans);
    }

    @Test
    void name1() {
        Stream<Employee> stream1 = employees.stream();
        Stream<Employee> stream2 = stream1.filter(employee -> !employee.getJobHistory().isEmpty());
        Stream<Employee> stream3 = stream2.filter(employee -> employee.getJobHistory()
                                                                      .get(0)
                                                                      .getEmployer()
                                                                      .equals("EPAM"));
        assertThat(stream1, is(not(sameInstance(stream2))));
        assertThat(stream2, is(not(sameInstance(stream3))));
        stream3.forEach(System.out::println);
        stream3.forEach(System.out::println);
    }

    @Test
    void name3() {
        Function<String, Integer> extractLenthFromString = String::length;
        Integer length1 = extractLenthFromString.apply("123");
        Integer length2 = extractLenthFromString.apply("123456");

        ToIntFunction<String> extractLenthFromString2 = String::length;
        IntFunction<String> convertIntToString = String::valueOf;

        IntFunction<Person[]> generator = Person[]::new;

        Person[] arr1 = generator.apply(10);
        assertThat(arr1, arrayWithSize(10));

        Person[] arr2 = generator.apply(10);
        assertThat(arr2, arrayWithSize(10));
        assertThat(arr1, is(not(sameInstance(arr2))));

        Person[] arr3 = generator.apply(20);
        assertThat(arr3, arrayWithSize(20));

        Person[] result = employees.stream()
                                   .peek(employee -> {
                                   })
                                   .map(Employee::getPerson)
                                   .peek(person -> {
                                   })
                                   .filter(person -> person.getAge() > 25)
                                   .peek(person -> {
                                   })
                                   .toArray(Person[]::new);

        assertThat(result, arrayWithSize(5));
    }

    @Test
    void name4() {
        Set<String> result = Stream.of(10, 2, 3000, 4, 4, 5)
                                   .sorted()
                                   .map(String::valueOf)
                                   .filter(str -> str.length() < 4)
                                   .collect(Collectors.toSet());

        assertThat(result, containsInAnyOrder("10", "2", "4", "5"));
    }

    @Test
    void name5() {
        String[] strings = {"1", "2", "3"};
        assertThat(Stream.of(strings).count(), is(3L));
    }

    @Test
    void name6() {
        Random random = new Random();
        boolean result = Stream.generate(() -> random.nextInt(100))
                               .peek(System.out::println)
                               .filter(value -> value > 49)
                               .allMatch(value -> value < 90);

        assertThat(result, is(false));
    }

    @Test
    void name7() {
        Stream.iterate(1, value -> value + 2)
              .skip(5)
              .limit(5)
              .forEach(System.out::println);

        DoubleStream doubleStream;
        LongStream longStream;
        IntStream intStream = IntStream.range(4, 400);
        IntSummaryStatistics statistics = intStream.summaryStatistics();
        assertThat(statistics.getMin(), is(4));
        assertThat(statistics.getMax(), is(399));
        assertThat(statistics.getCount(), is(396L));
    }

    @Test
    void name8() {
        Optional<Person> empty = employees.stream()
                                        .map(Employee::getPerson)
                                        .filter(person -> person.getAge() < 0)
                                        .max(Comparator.comparingInt(Person::getAge));

        assertThat(empty.isPresent(), is(false));

        Optional<Person> max = employees.stream()
                                        .map(Employee::getPerson)
                                        .max(Comparator.comparingInt(Person::getAge));

        if (max.isPresent()) {
            Person person = max.get();
            String fullName = person.getFullName();
            if (fullName.length() < 12) {
                System.out.println(fullName);
            }
        }

        max.map(Person::getFullName)
           .filter(name -> name.length() < 12)
           .ifPresent(System.out::println);
    }

    @Test
    void name9() {
        System.out.println(employees.stream()
                                    //                 .map(employee -> employee.getPerson().getFullName())
                                    .map(Employee::getPerson)
                                    .map(Person::getFullName)
                                    .map(name -> "'" + name + "'")
                                    .collect(joining(", ", "{", "}")));
    }

    @Test
    void name10() {
        Map<Person, List<JobHistoryEntry>> collect = employees.stream()
                                                              .collect(toMap(Employee::getPerson, Employee::getJobHistory));

        Map<String, Set<Person>> collect1 =
                employees.stream()
                         .collect(toMap(employee -> employee.getJobHistory().get(0).getEmployer(),
                                        employee -> new HashSet<>(Collections.singleton(employee.getPerson())),
                                        (set1, set2) -> {
                                            set1.addAll(set2);
                                            return set1;
                                        }));

        System.out.println(collect1);

        Map<String, Set<Person>> collect2 =
                employees.stream()
                         .collect(groupingBy(employee -> employee.getJobHistory().get(0).getEmployer(),
                                             mapping(Employee::getPerson, toSet())));

    }

    private static List<Employee> getEmployees() {
        return Arrays.asList(
                new Employee(
                        new Person("Иван", "Мельников", 30),
                        Arrays.asList(
                                new JobHistoryEntry(2, "dev", "EPAM"),
                                new JobHistoryEntry(1, "dev", "google")
                        )),
                new Employee(
                        new Person("Александр", "Дементьев", 28),
                        Arrays.asList(
                                new JobHistoryEntry(1, "tester", "EPAM"),
                                new JobHistoryEntry(1, "dev", "EPAM"),
                                new JobHistoryEntry(1, "dev", "google")
                        )),
                new Employee(
                        new Person("Дмитрий", "Осинов", 40),
                        Arrays.asList(
                                new JobHistoryEntry(3, "QA", "yandex"),
                                new JobHistoryEntry(1, "QA", "mail.ru"),
                                new JobHistoryEntry(1, "dev", "mail.ru")
                        )),
                new Employee(
                        new Person("Анна", "Светличная", 21),
                        Collections.singletonList(
                                new JobHistoryEntry(1, "tester", "T-Systems")
                        )),
                new Employee(
                        new Person("Игорь", "Толмачёв", 50),
                        Arrays.asList(
                                new JobHistoryEntry(5, "tester", "EPAM"),
                                new JobHistoryEntry(6, "QA", "EPAM")
                        )),
                new Employee(
                        new Person("Иван", "Александров", 33),
                        Arrays.asList(
                                new JobHistoryEntry(2, "QA", "T-Systems"),
                                new JobHistoryEntry(3, "QA", "EPAM"),
                                new JobHistoryEntry(1, "dev", "EPAM")
                        ))
        );
    }
}

@Value
class Person {

    String firstName;
    String lastName;
    int age;

    public String getFullName() {
        return firstName + " " + lastName;
    }
}

@Value
class JobHistoryEntry {

    int duration;
    String position;
    String employer;
}

@Value
class Employee {

    private final Person person;
    private final List<JobHistoryEntry> jobHistory;
}