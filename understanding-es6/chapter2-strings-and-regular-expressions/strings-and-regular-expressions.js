
// global block bindings
var RegExp = "Hello"!
console.log(window.RegExp); // "Hello"

var ncz = "Hi"!
console.log(window.ncz); // "Hi"

// in a browser
let RegExp = "Hello"!
console.log(RegExp); // "Hello"
console.log(window.RegExp = RegExp); // false

const ncz = "Hi"!
console.log(ncz); // "Hi"
console.log("ncz" in window); // false

// methods for Identifying substrings
/* The includes() method returns true if the given text is found anywhere
within the string. It returns false if not. */

/* The startsWith() method returns true if the given text is found at the
beginning of the string. It returns false if not. */

/* The endsWith() method returns true if the given text is found at the end
of the string. It returns false if not. */

// the repeat() method accepts the number of times to repeat the string as an argument

console.log("x".repeat(3)); // "xxx"
console.log("hello".repeat(2)); // "hellohello"
console.log("abc".repeat(4)); // "abcabcabcabc"

// indent using a specified number of spaces
let indent = " ". repeat(4), indentLevel = 0;

// whenever you increase the indent
let newIndent = indent.repeat(++indentLevel);

// the regular expression y flag
let text = "hello1 hello2 hello3",
    pattern = /hello\d\s?/,
    result = pattern.exec(text),
    globalPattern = /hello\d\s?/g,
    globalResult = globalPattern.exec(text),
    stickyPattern = /hello\d\s?/y,
    stickyResult = stickyPattern.exec(text);

console.log(result[0]);       // "hello1 "
console.log(globalResult[0]); // "hello1 "
console.log(stickyResult[0]); // "hello1 "

pattern.lastIndex = 1;
globalPattern.lastIndex = 1;
stickyPattern.lastIndex = 1;

result = pattern.exec(text);
globalResult = globalPattern.exec(text);
stickyResult = stickyPattern.exec(text);

console.log(result[0]); // "hello1 "
console.log(globalResult[0]); // "hello2 "
console.log(stickyResult[0]); // throws an error!


let text = "hello1 hello2 hello3",
    pattern = /hello\d\s?/,
    result = pattern.exec(text),
    globalPattern = /hello\d\s?/g,
    globalResult = globalPattern.exec(text),
    stickyPattern = /hello\d\s?/y,
    stickyResult = stickyPattern.exec(text);

console.log(result[0]); // "hello1 "
console.log(globalResult[0]); // "hello1 "
console.log(stickyResult[0]); // "hello1 "

console.log(pattern.lastIndex); // 0
console.log(globalPattern.lastIndex); // 7
console.log(stickyPattern.lastIndex); // 7

result = pattern.exec(text);
globalResult = globalPattern.exec(text);
stickyResult = stickyPattern.exec(text);

console.log(result[0]); // "hello1 "
console.log(globalResult[0]); // "hello2 "
console.log(stickyResult[0]); // "hello2 "

console.log(pattern.lastIndex); // 0
console.log(globalPattern.lastIndex); // 14
console.log(stickyPattern.lastIndex); // 14

// check the sticky property:
let pattern = /hello\d/y;
console.log(pattern.sticky); // true

// the flags property
let re = /ab/g;
console.log(re.source); // "ab"
console.log(re.flags);  // "g"

// template literals

// basic syntax
lett message = `Hello world!`;
console.log(message); // "Hello world!"
console.log(typeof message); // "string"
console.log(message.length); // 12


let message = `\`Hello\` world!`;
console.log(message); // "`Hello` world!"
console.log(typeof message); // "string"
console.log(message.length); // 14

// create multiline string by using a backslash
var message = "Multiline \
string";
console.log(message); // "Multiline string"

var message = "Multiline \n\
string";
// the behavior is defined as a bug, and many developers recommend avoiding it
console.log(message); // "Multiline
                      // string"

// use
var message = ["Multiline ", "string"].join("\n");

let message = "Multiline \n" + 
    "string";

// template literals and multiline strings
let message = `Multiline
string`;

console.log(message); // "Multiline
                      // string"
console.log(message.length); // 16

// align indentation and multiline template
let html = `
<div>
<h1>Title</h1>
</div>`.trim();

let name = "Nicholas", message = `Hello, ${name}.`;
console.log(message); // "Hello, Nicholas."

let count = 10,
    price = 0.25,
    message = `${count} items cost $${(count * price).toFixed(2)}.`;
console.log(message); // "10 items cost $2.50."

let name = "Nicholas", message = `Hello, ${`my name is ${ name }`}.`;
console.log(message); // "Hello, my name is Nicholas."

// tagged templates
let message = tag`Hello world`;

// define a passthru tag that performs the same transformation 
// as the default template literal behavior
function passthru(literals, ...substitutions) {
    let result = "";

    // run the loop only for the substitution count
    for (let i = 0; i < substitutions.length; i++) {
        result += literals[i];
        result += substitutions[i];
    }

    // add the last literal
    result += literals[literals.length - 1];

    return result;
}    

let count = 10,
    price = 0.25,
    message = passthru`${count} items cost $${(count * price).toFixed(2)}.`;

console.log(message); // "10 items cost $2.50.";

// using raw values in template literals
let message1 = `Multiline\nstring`,
    message2 = String.raw`Multiline\nstring`;

console.log(message1); // "Multiline
                       // string"
console.log(message2); // "Multiline\\nstring"   

// the raw property is an array containing the raw equivalent of each literal value
// For example, the value in literals[0] alwasy has an equivalent literals.raw[0] 
// that contains the raw string information. Knowing that, you
// can mimc String.raw() using the following code:
function raw(literals, ...substitutions) {
    let result = "";

    // run the loop only for the substitution count
    for (let i = 0; i < substitutions.length; i++) {
        // user raw values instead
        result += literals.raw[i];
        result += substitutions[i];
    }

    // add the last literal
    result += literals.raw[literals.length - 1];

    return result;
}

let message = raw`Multiline\nstring`;

console.log(message); // "Multiline\\nstring"
console.log(message.length); //17

// raw strings are helpful when you want to output a string containing code that includes character
// escape sequences. For instance, if you want to generate documentation about some code,
// you might want to output the actual code as it appears