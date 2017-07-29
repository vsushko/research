// this operator in the global context
/*console.log(this === window); // true
this.a = 37;
console.log(window.a); // 37
console.log(this.document === document === window.document); // true*/

// this operator in a function context
function f1() {
    return this;
}
// f1() === window; // true

console.log(this); // global (window)
function f2() {
    "use strict";
    return this; // undefined
}
console.log(f2()); // undefined
console.log(this); // window

var p = {
    age: 37,
    getAge: function () {
        return this.age; // this points to the class instance (p)
    }
};
console.log(p.getAge()); // 37

function Person2() { }
Person2.prototype.age = 37;
Person2.prototype.getAge = function () {
    return this.age;
}
var p1 = new Person2();
p.age; // 37
p.getAge(); // 37

function Person3() { // function used as a constructor
    this.age = 37;
}
var p2 = new Person3();
console.log(p.age); // logs 37

// the call, apply, and bind methods

class Person4 {
    public name: string;
    public surname: string;
    constructor(name: string, surname: string) {
        this.name = name;
        this.surname = surname;
    }
    public greet(city: string, country: string) {
        // we use the this operator to access name and surname
        var msg = `Hi, my name is ${this.name} ${this.surname}. `;
        msg += `I'm from ${city} (${country}).`;
        console.log(msg);
    }
}

var person = new Person4("remo", "jansen");
person.greet("Seville", "Spain");
person.greet.call(person, "seville", "spain");
person.greet.apply(person, ["seville", "spain"]);
person.greet.call(null, "seville", "spain");
person.greet.apply(null, ["seville", "spain"]);

// apply and call methods make sense only when we want the this operator 
// to take a different value when a function is invoked
var valueOfThis = { name : "anakin", surname : "skywalker" };
person.greet.call(valueOfThis, "mos espa", "tatooine");
person.greet.apply(valueOfThis, ["mos espa", "tatooine"]);
// Hi, my name is anakin skywalker. I'm from mos espa tatooine.

// When we invoke a function's bind method, it returns a new function with the 
// same body and scope as the original function, but the this operator 
// (within the body function) is permanently bound to the first argument of 
// bind, regardless of how the function is invoked
var person1 = new Person4("remo", "jansen");
// bind to set the greet function to be a new function with the same
// scope and body
var greet = person.greet.bind(person1);

greet.call(person1, "seville", "spain");
greet.apply(person1, ["seville", "spain"]);
// Hi, my name is remo jansen. I'm from seville spain.
greet.call(null, "seville", "spain");
greet.apply(null, ["seville", "spain"]);
// Hi, my name is remo jansen. I'm from seville spain.
var valueOfThis = { name: "anakin", surname: "skywalker" };
greet.call(valueOfThis, "mos espa", "tatooine");
greet.apply(valueOfThis, ["mos espa", "tatooine"]);
// Hi, my name is remo jansen. I'm from mos espa tatooine.

// Once we bind an object to a function with bind , we cannot override it:
var valueOfThis = { name: "anakin", surname: "skywalker" };
var greet = person1.greet.bind(valueOfThis);
greet.call(valueOfThis, "mos espa", "tatooine");
greet.apply(valueOfThis, ["mos espa", "tatooine"]);
// Hi, my name is remo jansen. I'm from mos espa tatooine.

// prototypal inheritance
