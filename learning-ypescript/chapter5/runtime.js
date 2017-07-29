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
function Person2() {
}
Person2.prototype.age = 37;
Person2.prototype.getAge = function () {
    return this.age;
};
var p1 = new Person2();
p.age; // 37
p.getAge(); // 37
function Person3() {
    this.age = 37;
}
var p2 = new Person3();
console.log(p.age); // logs 37
// the call, apply, and bind methods
var Person4 = (function () {
    function Person4(name, surname) {
        this.name = name;
        this.surname = surname;
    }
    Person4.prototype.greet = function (city, country) {
        // we use the this operator to access name and surname
        var msg = "Hi, my name is " + this.name + " " + this.surname + ". ";
        msg += "I'm from " + city + " (" + country + ").";
        console.log(msg);
    };
    return Person4;
})();
var person = new Person4("remo", "jansen");
person.greet("Seville", "Spain");
person.greet.call(person, "seville", "spain");
person.greet.apply(person, ["seville", "spain"]);
person.greet.call(null, "seville", "spain");
person.greet.apply(null, ["seville", "spain"]);
