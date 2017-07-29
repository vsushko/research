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
