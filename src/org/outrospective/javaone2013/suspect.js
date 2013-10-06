#!/usr/bin/jjs
/* This script hunts down the change set associated with a
 source file and a line number.
 From https://blogs.oracle.com/nashorn/entry/csi_nashorn_shell_scripting_in

 ps. either chg line 1 to point to $JAVA_HOME/bin/jjs or put in a symlink
*/

// Report proper command usage.
function usage() {
    error(<<EOS);
    usage: suspect javaFileName lineNumber
    javaFileName - name of file in local mercurial repository
    lineNumber   - file line number

    EOS
    }

    // Report on stderr.
    function error(message) {
        java.lang.System.err.print(message);
        exit(1);
        }

    // Provide meaningful names for arguments.
    var fileName   = $ARG[0];
    var lineNumber = $ARG[1];

    // If arguments are missing, report proper usage.
    if (!fileName || !lineNumber) {
        usage();
        }

    // Add .java if not present.
    if (!fileName.endsWith(".java")) {
    fileName += ".java";
}

// Search for matching files and convert the result to an array of paths.
var where = `find . -name ${fileName}`.trim().split("\n");

// If not found
if (where == "") {
    error("File ${fileName} is not in the current repository.\n");
} else if (where.length != 1) {
    error("File ${fileName} found in multiple locations\n${where.join('\n')}\n");
}

// Get the source annotated with change set number.
var annotated = `hg annotate -c ${where}`.split("\n");

// Get the target source line.
var line = annotated[lineNumber];

// Make sure the line exists.
if (!line) {
    error("File ${fileName} does not contain line number ${lineNumber}\n");
}

// Extract the revision number.
var revision = line.substring(0, 12);

// Report the change set information from the revision number.
print(`hg log -r ${revision}`);