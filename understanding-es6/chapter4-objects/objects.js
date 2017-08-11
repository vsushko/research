// object categories
// property initializer shorthand
function createPerson(name, age) {
    return {
        name: name,
        age: age
    };
}

// eliminating the duplication by using the property initializer
function createPerson(name, age) {
    return {
        name,
        age
    };
}

// concise methods in es5
var person = {
    name: "Nicholas",
    sayName: function () {
        console.log(this.name);
    }
};

// in es6
var person = {
    name: "Nicholas",
    sayName() {
        console.log(this.name);
    }
};

// computed property names es5
var person = {}, lastName = "last name";

person["first name"] = "Nicholas";
person[lastname] = "Zakas";

console.log(person["first name"]); // "Nicholas"
console.log(person[lastName]);     // "Zakas"

// use string literals directly as property names in object literals
var person = {
    "first name": "Nicholas"
};

console.log(person["first name"]); // "Nicholas"

// computed property names in es6
let lastName = "last name";

let person = {
    "first name": "Nicholas",
    [lastName]: "Zakas"
};

console.log(person["first name"]); // "Nicholas"
console.log(person[lastName]);     // "Zakas"

var suffix = " name";

var person = {
    ["first" + suffix]: "Nicholas",
    ["last" + suffix]: "Zakas"
}

console.log(person["first name"]); // "Nicholas"
console.log(person["last name"]);  // "Zakas"

// new methods
// the object.is() method works the same as the === operator

console.log(+0 == -0); // true
console.log(+0 === -0); // true
console.log(Object.is(+0, -0)); // false

console.log(NaN == NaN); // false
console.log(NaN === NaN); // false
console.log(Object.is(NaN, NaN)); // true

console.log(5 == 5); // true
console.log(5 == "5"); // true
console.log(5 === 5); // true
console.log(5 === "5"); // false
console.log(Object.is(5, 5)); // true
console.log(Object.is(5, "5")); // false

// the object.assign() method
// in a mixin, one object receives properties and methods from another object
// the mixin() function iterates over the own properties of supplier and copies them onto receiver
function mixin(receiver, supplier) {
    Object.keys(supplier).forEach(function (key) {
        receiver[key] == supplier[key];
    });
    return receiver;
}

// we can use Object.assign() anywhere when we would have used the mixin() function
function EventTarget() { /*...*/ }
EventTarget.prototype = {
    constructor: EventTarget,
    emit: function () {/*...*/ },
    on: function () {/*...*/ }
}

var myObject = {}
Object.assign(myObject, EventTarget.prototype);
myObject.emit("somethingChanged");

var receiver = {};

Object.assign(receiver,
    {
        type: "js",
        name: "file.js"
    },
    {
        type: "css"
    }
);

console.log(receiver.type); // "css"
console.log(receiver.name); // "file.js"

// Object.assign() doesn't create accessor properties on the receiver when a 
// supplier has accessor properties. Because Object.assign() uses the assignment 
// operator, an acccessor property on a supplier wil become a data property on the receiver
var receiver = {},
    supplier = {
        get name() {
            return "file.js"
        }
    };
Object.assign(receiver, supplier);
var descriptor = Object.getOwnPropertyDescriptor(receiver, "name");

console.log(descriptor.value); // "file.js"
console.log(descriptor.get);   // undefined

// duplicate object literal properties
"use strict";
var person = {
    name: "Nicholas",
    name: "Greg" // syntax error in es5 string mode
}

// in es6
"use strict";
var person = {
    name: "Nicholas",
    name: "Greg" // not error in es6 strict mode
}

console.log(person.name); // "Greg"

// own property enumeration order
// The basic order for own property enumeration is:
// 1.	 All numeric keys in ascending order
// 2.	 All string keys in the order in which they were added to the object
// 3.	 All symbol keys in the order in which they were added to the object

var obj = {
    a: 1,
    0: 1,
    c: 1,
    2: 1,
    b: 1,
    1: 1
};

obj.d = 1;

console.log(Object.getOwnPropertyNames(obj).join("")); // "012acbd"

// changing an object's prototype
let person = {
    getGreeting() {
        return "Hello";
    }
};

let dog = {
    getGreeting() {
        return "Woof";
    }
};

// prototype is person
let friend = Object.create(person);
console.log(friend.getGreeting()); // "Hello"
console.log(Object.getPrototypeOf(friend) == person); // true

// set prototype to dog
Object.setPrototypeOf(friend, dog);
console.log(friend.getGreeting()); // "Woof"
console.log(Object.getPrototypeOf(friend) == dog); // true

// easy prototype access with super references
// es5
let person = {
    getGreeting() {
        return "Hello";
    }
};

let dog = {
    getGreeting() {
        return "Woof";
    }
};

/*let friend = {
    getGreeting() {
        return Object.getPrototypeOf(this).getGreeting.call(this) + ", hi!";
    }
}*/
let friend = {
    getGreeting() {
        // in the previous example, this is the same as:
        // Object.getPrototypeOf(this).getGreeting.call(this)
        return super.getGreeting() + ", hi!";
    }
}

// set prototype to person
Object.setPrototypeOf(friend, person);
console.log(friend.getGreeting()); // "Hello, hi!"
console.log(Object.getPrototypeOf(friend) === person); // true

// set prototype to dog
Object.setPrototypeOf(friend, dog);
console.log(friend.getGreeting()); // "Woof, hi!"
console.log(Object.getPrototypeOf(friend) === dog); // true

// attempting to user super outside of concise methods results in a syntax error
let friend = {
    getGreeting: function () {
        // syntax error
        return super.getGreeting() + ", hi!";
    }
};

// the super reference is really helpful when you have multiple levels of 
// inheritance, because in that case, Object.getPrototypeOf() no longer
// works in all circumstances
let person = {
    getGreeting() {
        return "Hello";
    }
};
// prototype is person
let friend = {
    getGreeting() {
        return Object.getPrototypeOf(this).getGreeting.call(this) + ", hi!";
    }
};
Object.setPrototypeOf(friend, person);
// prototype is friend
let relative = Object.create(friend);
console.log(person.getGreeting());   // "Hello"
console.log(friend.getGreeting());   // "Hello, hi!"
console.log(relative.getGreeting()); // error!

// use es6 to solve the problem
let person = {
    getGreeting() {
        return "Hello";
    }
};

// prototype is person
let friend = {
    getGreeting() {
        return super.getGreeting() + ", hi!";
    }
};
Object.setPrototypeOf(friend, person);
// prototype is friend
let relative = Object.create(friend);
console.log(person.getGreeting()); // "Hello"
console.log(friend.getGreeting()); // "Hello, hi!"
console.log(relative.getGreeting()); // "Hello, hi!"

// a formal method definition
let person = {
    // method
    getGreeting() {
        return "Hello";
    }
};

// not a method
function shareGreeting() {
    return "Hi!";
}

// calling friend.getGreeting() returns a string, which combines 
// the value from person.getGreeting() with ", hi!"
let person = {
    getGreeting() {
        return "Hello";
    }
};
// prototype is person
let friend = {
    getGreeting() {
        return super.getGreeting() + ", hi!";
    }
};
Object.setPrototypeOf(friend, person);
console.log(friend.getGreeting()); // "Hello, hi!"
