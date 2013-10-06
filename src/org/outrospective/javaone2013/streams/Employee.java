package org.outrospective.javaone2013.streams;

/**
 * User: kon
 * Date: 2/10/13
 * Time: 4:49 PM
 */
public class Employee {
    int getSalary() {
        return 100;
    }

    Department getDepartment() {
        return new Department("Information Technology");
    }
}
