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
