### JavaOne 2013 Update ###

Updates of Nashorn and Lambda features demonstrated at JavaOne SF 2013 and demo'd at MelbJVM October 2013

Get JDK 8 from http://jdk8.java.net

# Lambda Demo's
_SimpleRefactoringMain_: A demo to show how annon inner classes can be refactored to lambdas in J8 as well as demonstrating the forEach method added to Hashtable using the new Default methods in interfaces feature.

_DefaultMethodsMain_: Demoing default methods in Java 8.  Resulting in the need to not implement annoying methods in interfaces you didn't usually take seriously (eg Iterator.remove)

_Streams_: Although I didnt have time to talk through these, these are a sample of methods on the [Streams API documentation|http://download.java.net/jdk8/docs/api/java/util/stream/Collectors.html] to give you a feel for what the API could do.

_MultipleInheritanceByTypeNotByState_: Shows what happens when two interfaces implement the same default method.

# Nashorn Demos
_simpledemo.js_: A demo of jjs and javascript demos in bash

_fireworks.js_: Demo from jim laskey's blog.  A JavaFX written entirely in Javascript. Good to see how to interop with existing Java classes.  jjs -fx fireworks.js

_suspect.js_: Another demo from Jim Laskey's blog. A bash script written in js. Run with jjs -scripting suspect.js
