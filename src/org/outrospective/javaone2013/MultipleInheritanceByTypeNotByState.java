package org.outrospective.javaone2013;

/**
 * During the demo of default methods at MelbJVM, the question would arise about how/if default methods would allow
 * multiple inheritance.
 * The answer is that there is multiple inheritance by type, but not by state.  Default method can call other
 * methods in the interface, not in the implementations
 */
public class MultipleInheritanceByTypeNotByState {
    interface Foo {
        default void foo() {
            System.out.println("Foo.foo() called");
        }
    }
    interface Bar {
        default void foo() {
            System.out.println("Bar.foo() called");
        }
    }

    // Creating a new interface with the same method will fail with the following error
    //
    // java: interface org.outrospective.javaone2013.MultipleInheritanceByTypeNotByState.FooBar inherits unrelated
    // defaults for foo() from types org.outrospective.javaone2013.MultipleInheritanceByTypeNotByState.Foo and
    // org.outrospective.javaone2013.MultipleInheritanceByTypeNotByState.Bar
/*    interface FooBar extends Foo, Bar {

    }*/

    class FooBar implements Foo, Bar {
        // we can implement this in the subclass
        @Override
        public void foo() {
            System.out.println("FooBar.foo() called");
        }
    }
}
