// simulating default parameter values in ECMAScript 5
function makeRequest(url, timeout, callback) {
    timeout = timeout || 2000;
    callback = calback || function() {};

    // the rest of the function
}

// a safer alternative with checking the type of the argument using typeof
function makeRequest(url, timeout, callback) {
    timeout = (typeof timeout !== "undefined") ? timeout : 2000;
    callback = (typeof callback !== "undefined") ? callback : function() {};

    // the rest of the function
}

// default parameter values in ECMAScript 6
function makeRequest(url, timeout = 2000, callback = function() {}) {
    // the rest of the function
}

// uses default timeout and callback
makeRequest("/foo");
// uses default callback
makeRequest("/foo", 500);
// doesn't use defaults
makeRequest("/foo", 500, function(body) {
    doSomething(body);
});

// specifying default falues for any arguments
function makeRequest(url, timeout == 2000, callback) {
    // the rest of the function
}

// uses default timeout
makeRequest("/foo", undefined, function(body) {
    doSomething(body);
});

// uses default timeout
makeRequest("/foo");

// doesn't use default timeout
makeRequest("/foo", null, function(body) {
    doSomething(body);
});

// how default parameter values affect the arguments object
function mixArgs(first, second) {
    console.log(first === arguments[0]); // true
    console.log(second === arguments[1]); // true
    first = "c";
    second = "d";
    console.log(first === arguments[0]); // true
    console.log(second === arguments[1]); // true
}
mixArgs("a", "b");

function mixArgs(first, second) {
    "use strict";
    console.log(first === arguments[0]); // true
    console.log(second === arguments[1]); // true
    first = "c";
    second = "d"
    console.log(first === arguments[0]); // false
    console.log(second === arguments[1]); // false
}
mixArgs("a", "b");

// ECMAScript 6
// not in strict mode
function mixArgs(first, second = "b") {
    console.log(arguments.length); // 1
    console.log(first === arguments[0]); // true
    console.log(second === arguments[1]); // false
    first = "c";
    second = "d"
    console.log(first === arguments[0]); // false
    console.log(second === arguments[1]); // false
}
mixArgs("a");

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

// takes a single argument and simply returns it
let reflect = value => value;

// effectively equivalent to
let reflect = function (value) {
  return value;
};

// more than one argument
let sum = (num1, num2) => num1 + num2;

// effectively equivalent to
let sum = function (num1, num2) {
  return num1 + num2;
}

// if there are no arguments to the function, we must include an
// empty set of parentheses in the declaraion
let getName = () => "Nicholas";

// effectively equivalent to
let getName = function () {
  return "Nicholas";
}

// wrap the function in curly braces when you need more than one expression
let sum = (num1, num2) => {
  return num1 + num2;
}

// effectively equivalent to
let sum = function (num1, num2) {
  return num1 + num2;
}

// creating a function that does nothing
let doNothing = () => { };

// effectively equivalent to
let doNothing = function () { };

// when we want to retrun an object literal outside a function
// body must wrap the literal in parentheses
let getTempItem = id => ({ id: id, name: "Temp" });

// effectively equivalent to
// wrapping the object literal in parentheses signals that the
// curly braces are an obejct literal instead of the function body
let getTempItem = function (id) {
  return {
    id: id,
    name: "Temp"
  }
}

// creating immediately invoked function expression
// IIFEs  allow you to define an anonymous function and call 
// it immediately without savin a reference.
// This pattern comes in handy when you want to create a scope 
// that is shielded from the rest of a program

let person = function (name) {
  return {
    getName: function () {
      return name;
    }
  };
}("Nicholas");

console.log(person.getName()); // "Nicholas"

// using arrow function
let person = ((name) => {
  return {
    getName: function () {
      return name;
    }
  };
})("Nicholas");

console.log(person.getName()); // "Nicholas"

// no this binding
let PageHandler = {
  id: "123456",
  init: function () {
    document.addEventListener("click", function (event) {
      this.doSomething(event.type);  // error
    }, false);
  },
  doSomething: function (type) {
    console.log("Handling " + type + " for " + this.id);
  }
};

// with binging which solving the problem
let PageHandler = {
  id: "123456",
  init: function () {
    document.addEventListener("click", (function (event) {
      this.doSomething(event.type); // no error
    }).bind(this), false);
  },
  doSomething: function (type) {
    console.log("Handling " + type + " for " + this.id);
  }
}

// with arrow function
let PageHandler = {
  id: "123456",
  init: function () {
    document.addEventListener("click", event =>
      this.doSomething(event.type), false);
  },
  doSomething: function (type) {
    console.log("Handling " + type + " for " + this.id);
  }
}
