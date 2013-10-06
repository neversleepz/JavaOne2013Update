package org.outrospective.javaone2013;

import java.util.Collection;
import java.util.Iterator;

interface Foo {
    public void implementMe();
}

interface NeedyFoo extends Foo {
    abstract void everySubclassImplementsMeWhetherTheyNeedMeToOrNot();
}

interface DefaultMethodFoo extends NeedyFoo {
    default void everySubclassImplementsMeWhetherTheyNeedMeToOrNot() {

        System.out.println("This implementation doesnt do anything with this method");
    }
}

public class DefaultMethodsMain {
    public static void main(String[] args) {
        System.out.println("Step 1");
        Foo f = step1();
//        System.out.println("\n\nStep 2");
//        step2(f);
//        System.out.println("\n\nStep 3");
//        step3();
//        System.out.println("\n\nStep 4");
//        step4();
    }

    private static Foo step1() {
        Foo f = new Foo() {
            @Override
            public void implementMe() {
                System.out.println("Old way to implement foo");
            }
        };
        f.implementMe();
        return f;
    }

    private static void step2(Foo f) {
        // f is implemented as a lambda - it implies it is implementing an interface with a single method that takes nothing ()
        // and it's body is the single instruction println
        f = () -> System.out.println("New way to implement foo");
        f.implementMe();
    }

    private static void step3() {
        NeedyFoo nf = new NeedyFoo() {
            @Override
            public void everySubclassImplementsMeWhetherTheyNeedMeToOrNot() {
                throw new UnsupportedOperationException("Gaaarrghh interface designer, why u make me implement this!");
            }

            @Override
            public void implementMe() {
                System.out.println("Needy foo implementation called");
            }
        };
        nf.implementMe();
        try {
            nf.everySubclassImplementsMeWhetherTheyNeedMeToOrNot();
        } catch(UnsupportedOperationException e) {
            System.out.println("Caught unsupported operation exception");
        }

        // cant use lambda rep here
//        nf = () -> System.out.println("This wont compile");
    }

    private static void step4() {
        DefaultMethodFoo dmf = () -> System.out.println("This will compile, the default method implementation will be called for the other method");
        dmf.implementMe();
        dmf.everySubclassImplementsMeWhetherTheyNeedMeToOrNot();

        // Look at
//        Iterator.remove();
//        Collection.stream();
    }
}