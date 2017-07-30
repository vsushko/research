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
