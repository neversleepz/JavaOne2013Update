package org.outrospective.javaone2013.streams;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Stream examples from <a href="http://download.java.net/jdk8/docs/api/java/util/stream/Collectors.html">package api</a>
 */
public class Streams {
    public static void main(String[] args) {

        // Accumulate names into a List
        Collection<Person> people = null;
        List<String> list = people.stream()
                .filter((t)->t.getName().length() < 3)
                .map((t) -> t.getName())
                .collect(Collectors.toList());

        // Accumulate names into a TreeSet
        Set<String> set = people.stream()
                .map(t -> t.getName())
                .collect(Collectors.toCollection(TreeSet::new));

        // Convert elements to strings and concatenate them, separated by commas
        Collection<String> things = Arrays.asList("Foo","bar");
        String joined = things.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));

        // Compute sum of salaries of employee
        Collection<Employee> employees = Collections.emptyList();
        int total;
        total = employees.stream()
                .collect(Collectors.summingInt((java.util.function.ToIntFunction<? super Employee>) (value) -> value.getSalary()));

        // Group employees by department
        Map<Department, List<Employee>> byDept
                = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        // Compute sum of salaries by department
        Map<Department, Integer> totalByDept
                = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.summingInt(Employee::getSalary)));

        // Partition students into passing and failing
        Collection<Student> students = Collections.emptyList();
        Map<Boolean, List<Student>> passingFailing =
                students.stream()
                        .collect(Collectors.partitioningBy(s -> s.getGrade() >= PASS_THRESHOLD));
    }

    private static final int PASS_THRESHOLD = 50;
}
