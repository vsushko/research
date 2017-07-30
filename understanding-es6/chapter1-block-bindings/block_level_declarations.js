// block scopes, also called lexical scopes, are created in the following places:
// inside a function
// inside a block (indicated by the { and } characters)
function getValue(condition) {
    if (condition) {
        let value = "blue";
        // other code
        return value;
    } else {
        // value doesn't exist here
        return null;
    }
    // value doesn't exist here
}

// no redeclaration with let
var count = 30;
if (condition) {
    // doesn't throw an error
    // this new variable shadows the global count
    // preventing access to it until execution exits the block
    let count = 40;
    // more code
}

// const declarations
// bindings declared using const are considered constants, meaning
// their values cannot be changed once set
// constants, like let declarations, are block-level

// valid constant
const maxItems = 30;

if (condition) {
    const MaxItems = 5;
    // more code
}

// maxItems isn't accessible here

var message = "Hello!";
let age = 25;

// each of these throws an error
const message = "GoodBye!";
const age = 30;

// difference between const and let
const maxItems = 5;
// throws an error
maxItems = 6;

// Object declarations with const
const person = {
    name: "Nicholas"
};

// works
person.name = "Greg";

// throws an error
person = {
    name: "Greg"
};

// the temporal dead zone
if (condition) {
    console.log(typeof value); // throws an error
    let value = "blue";
}

console.log(typeof value); // "undefined"
if (condition) {
    let value = "blue";
}

// block bindings in loops
for (var i=0; i<10; i++) {
    process(items[i]);
}
// i is still accessible here
console.log(i); // 10;

for (let i=0; i<10; i++) {
    process(items[i]);
}
// i is not accessible here - throws an error
console.log(i);

// functions in loops
var funcs = [];
for (var i=0; i<10; i++) {
    funcs.push(function() {
        console.log(i);
    });
}

funcs.forEach(function(func) {
    func(); // outputs the number "10" ten times    
});

// to fix this, use immediately invoked function expression (IIFEs)
var funcs = [];
for(var i=0; i<10; i++) {
    funcs.push((function(value) {
        return function() {
            console.log(value);
        }
    }(i)));
}

funcs.forEach(function(func) {
    func();
});

// let declarations in loops
var funcs = [];
for (let i=0; i<10; i++) {
    funcs.push(function() {
        console.log(i);
    });
}

funcs.forEach(function(func) {
    func(); // outputs 0, then 1, then 2, up to 9
});

var funcs = [],
    object = {
        a: true,
        b: true,
        c: true
    };

for (let key in object) {
    funcs.push(function() {
        console.log(key);
    });
}

funcs.forEach(function(func) {
    func(); // outputs "a", then "b", then "c"
});

var funcs = []; 

// throws an error after one iteration
for (const i=0; i<10; i++) {
    funcs.push(function() {
        console.log(i);
    });
}

// should not cause an error:
var funcs = [], object = { a: true, b: true, c: true };

// doesn't cause an error
for (const key in object) {
    funcs.push(function() {
        console.log(key);
    });
}

// the for-in and for-of loops work with const because the loop initializer 
// creates a new binding on each iteration through the loop rather than attempting 
// to modify the value of an existing binding
funcs.forEach(function(func) {
    func(); // outputs "a", then "b", then "c"
})

// default parameter expressions
function getValue() {
    return 5;    
}

function add(first, second = getValue()) {
    return first + second;
}

console.log(add(1,1,)); // 2
console.log(add(1));    // 6

// user a previous parameter as the default for a later parameter
function add(first, second = first) {
    return first + second;
}

console.log(add(1,1)); // 2
console.log(add(1));   // 2

// pass first into a function to get the value for second
function getValue(value) {
    return value + 5;
}

function add(first, second = getValue(first)) {
    return first + second;
}

console.log(add(1,1)); // 2
console.log(add(1));   // 7

// the ability to reference parameters from default parameter 
// assignments works only for previous arguments
function add(first = second, second) {
    return first + second;
}

console.log(add(1, 1)); // 2
console.log(add(undefined, 1)); // throws an error

// default parameter temporal dead zone
function getValue(value) {
    return value + 5;
}

function add(first = second, second) {
    return first + second;
}

console.log(add(1, 1)); // 2
console.log(add(undefined, 1)); // throws an error

// in preceding example code behind the scenes
// javascript representation of call to add(1, 1)
let first = 1;
let second = 1;

// javascript representation of call to add(undefined, 1)
let first = second;
let second = 1;

// working with unnamed parameters
// unnamed Parameters in es 5
// this code inspects the arguments object
function pick(object) {
    let result = Object.create(null);
    // start at the second parameter
    for (let i = 1, len = arguments.length; i < len; i++) {
        result[arguments[i]] = object[arguments[i]];
    }
    return result;
}

let book = {
    title: "Understanding ECMAScript 6",
    author: "Nicholas C. Zakas",
    year: 2016
};
let bookData = pick(book, "author", "year");

console.log(bookData.author); // "Nicholas C. Zakas"
console.log(bookData.year); // 2016

// with rest parameters (which indicated by three dots(...))
function pick(object, ...keys) {
    let result = Object.create(null);
    for (let i = 0, len = keys.length; i < len; i++) {
        result[keys[i]] = object[keys[i]];
    }
    return result;
}

// rest parameters restrictions
// 1. The first restriction is that there can be only one rest parameter
// and the rest parameter must be last
// Syntax error: Can't have a named parameter after rest parameters
function pick(object, ...keys, last) {
    let result = Object.create(null);
    for (let i = 0, len = keys.length; i < len; i++) {
        result[keys[i]] = object[keys[i]];
    }
    return result;
}
// 2. The rest parameters cannon be used in an object literal setter
let object = {
    // Syntax error: Can't use rest param in setter
    set name(...value) {
    // do something
    }
};

function checkArgs(...args) {
    console.log(args.length); // 2
    console.log(arguments.length); // 2
    console.log(args[0], arguments[0]); // a a
    console.log(args[1], arguments[1]); // b b
}
checkArgs("a", "b");


// increased capabilities of the function constructor
var add = new Function("first", "second", "return first + second");
console.log(add(1, 1)); // 2

// in es6 function constructor is allowed to use default parameters and rest parameters
var add = new Function("first", "second = first", "return first + second");
console.log(add(1, 1)); // 2
console.log(add(1));    // 2

// for the rest parameters
// creates a function that uses only a single rest parameter 
// and returns the first argument that was passed in
var pickFirst = new Function("...args", "return args[0]");
console.log(pickFirst(1, 2)); // 1

// spread operator
let value1 = 25, value2 = 50;
console.log(Math.max(value1, value2)); // 50

// earlier in es5
let values = [25, 50, 75, 100]
console.log(Math.max.apply(Math, values)); // 100

// in es6
let values = [25, 50, 75, 100]
// equivalent to
// console.log(Math.max(25, 50, 75, 100));
console.log(Math.max(...values)); // 100

let values = [-25, -50, -75, -100];
console.log(Math.max(...values, 0)); // 0

// the name property
function doSomething() {
    // empty
}

var doAnotherThing = function() {
    // empty
}

console.log(doSomething.name); // "doSomething"
console.log(doAnotherThing.name); // "doAnotherThing"

// special cases of the name property
var doSomething = function doSomethingElse() {
    // empty
}

var person = {
    get firstName() {
        return "Nicholas"
    },
    sayName: function() {
        console.log(this.name);
    }
}

console.log(doSomething.name); // "doSomethingElse"
console.log(person.saName.name); // sayName
console.log(person.firstName.name); // "get firstName"

// special case
var doSomething = function() {
    // empty
}

console.log(doSomething.bind().name); // "bound doSomething"
console.log((new Function()).name);   // "anonymous"

// clarifying the dual purpose of functions

// functions serve the dual purpose of being callable with or without new
function Person(name) {
    this.name = name;
}
var person = new Person("Nicholas");
var notAPerson = Person("Nicholas");

console.log(person); // "[Object object]"
console.log(notAPerson); // "undefined"


// determining how a function was called in es5
function Person(name) {
    if (this instanceof Person) {
        this.name = name; // using new
    } else {
        throw new Error("You must use new with Person.")
    }
}

var person = new Person("Nicholas");
var notAPerson = Person("Nicholas"); // throws an error
var notAnAnotherPerson = Person.call(person, "Michael"); // works!

// the new.target metaproperty
// was created to solve the problem of identifying function calls using new
// A metaproperty is a property of a nonobject that provides additional
// information related to its target (such as new)

// this new metaproperty allows you to safely detect if a function is called with
// new by checking whether new.target is defined
function Person(name) {
    if (typeof new.target !== "undefined") {
        this.name = name;
    } else {
        throw new Error("You must use new with Person.");
    }
}

var person = new Person("Nicholas");
var notAPerson = Person.call(person, "Michael"); // error!

// check that new.target was called with a specific constructor
function Person(name) {
    if (typeof new.target === Person) {
        this.name = name;
    } else {
        throw new Error("You must use new with Person.")
    }
}

function AnotherPerson(name) {
    Person.call(this, name);
}

var person = new Person("Nicholas");
var anotherPerson = new AnotherPerson("Nicholas"); // error!

// block-level functions
"use strict";
if (true) {
    // throws a syntax error in ES5, not so in ES6
    function doSomething() {
        // empty
    }
}

// in es6 the doSomething() function is considered a block-level 
// decalration and can be accessed and called within the same 
// block in which it was defined
"use strict";
if (true) {
    console.log(typeof doSomething);
    // "function"
    function doSomething() {
        // empty
    }
    doSomething();
}
// block-level functions are hoisted to the top of the block
console.log(typeof doSomething); // "undefined"

// function expressions that use let are not hoisted
"use strict";
if (true) {
    console.log(typeof doSomething);
    // throws an error
    let doSomething = function () {
        // empty
    }
    doSomething();
}
console.log(typeof doSomething);

// block-level functions in non-strict mode
// ECMAScript 6 behavior
if (true) {
    console.log(typeof doSomething); // "function"
    function doSomething() {
        // empty
    }
    doSomething();
}
console.log(typeof doSomething); // "function"

// arrow functions
// arrow functions are functions defined with an arrow (=>)
// behaviour difference:
// - no this, super, arguments, and new.target bindings
// - cannot be called with new (do not have a [[Construct]] method)
// - no prototype (because you can't use new on an arrow functions)
// - can't change this (the value of this inside the function can't be changed)
// - no arguments object (because arrow functions have no arguments binding)
// - no duplicate named parameters (arrow functions cannot have duplicate named 
//   parameters in strict or non-strict mode)

// arrow functions also have a name property that follows the same rule as other functions

// arrow functions syntax

