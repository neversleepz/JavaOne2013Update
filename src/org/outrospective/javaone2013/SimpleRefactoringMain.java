package org.outrospective.javaone2013;

import java.util.Iterator;
import java.util.Properties;

public class SimpleRefactoringMain {

    public static void main(String[] args) {
        System.out.println("Step 1");
        step1();

//        System.out.println("\nStep 2");
//        step2();
//
//        System.out.println("\nStep 3");
//        step3();
    }

    // no java 8
    private static void step1() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                // properties is a Hashtable
                Properties properties = System.getProperties();
                for (Iterator<String> iterator = properties.stringPropertyNames().iterator(); iterator.hasNext(); ) {
                    String key = iterator.next();
                    String val = properties.getProperty(key);
                    System.out.println("key " + key + "\t\tval " + val);
                }
            }
        }).run();
    }

    // using forEach to iterate
    private static void step2() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                // forEach added in Java8 to HashTable
                System.getProperties().forEach(
                        (key, val) -> System.out.println("key " + key + "\t\tval " + val)
                );
            }
        }).run();
    }

    // replace an annonymous inner class with a lambda
    private static void step3() {
        // demo using IntelliJ refactoring tools - Netbeans and Eclipse also have support
        // if you press alt+enter whilst your cursor is on new Runnable() you will get
        // convert to lambda option
        Runnable target = new Runnable() {
            @Override
            public void run() {
                // forEach added in Java8 to HashTable
                System.getProperties().forEach(
                        (key, val) -> System.out.println("key " + key + "\t\tval " + val));
            }
        };
        new Thread(target).run();
        // and demo changing it back
    }

}
