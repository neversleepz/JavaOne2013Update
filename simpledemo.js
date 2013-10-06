#!/Library/Java/JavaVirtualMachines/jdk1.8.0.jdk/Contents/Home/bin/jjs
/*
Replace the above with the location to your Java_home/bin/jjs
or enter these directly in a terminal
*/
var hello="Hi MelbJVM!"
print(hello)

var jsObject = { foo: function() { print("running foo"); }, bar: 'woo' }
jsObject

print(jsObject)
jsObject.foo
jsObject.foo()

jsObject.bar


var System=Java.type("java.lang.System")
System.getProperties()