// function declaration
function greetNamed(name) {
    if (name) {
        return "Hi! " + name;
    }
}
// function expression
var greetUnnamed = function (name) {
    if (name) {
        return "Hi! " + name;
    }
};
var greenUnnamed2;
greenUnnamed2 = function (name) {
    if (name) {
        return "Hi! " + name;
    }
};
// declare a variable and its type as a function
var greetUnnamed3 = function (name) {
    if (name) {
        return "Hi! " + name;
    }
};
function add(foo, bar, foobar) {
    return foo + bar + foobar;
}
// add();          // Supplied parameters do not match any signature
// add(2, 2);      // Supplied parameters do not match any signature
add(2, 2, 2);
// functions with optional parameter
function addWithOptional(foo, bar, foobar) {
    var result = foo + bar;
    if (foobar !== undefined) {
        result += foobar;
    }
    return result;
}
addWithOptional(2, 2);
addWithOptional(2, 2, 2);
function add2(foo, bar, foobar) {
    return foo + bar + (foobar !== undefined ? foobar : 0);
}
// with default parameter
function add3(foo, bar, foobar) {
    if (foobar === void 0) { foobar = 0; }
    return foo + bar + foobar;
}
// function with rest parameter
function add4() {
    var foo = [];
    for (var _i = 0; _i < arguments.length; _i++) {
        foo[_i - 0] = arguments[_i];
    }
    var result = 0;
    for (var i = 0; i < foo.length; i++) {
        result += foo[i];
    }
    return result;
}
// alternate version of preceding function
function add5(foo) {
    var result = 0;
    for (var i = 0; i < foo.length; i++) {
        result == foo[i];
    }
    return result;
}
// function overloading
function test(value) {
    switch (typeof value) {
        case "string":
            return "My name is " + value + ".";
        case "number":
            return "I'm " + value + " years old.";
        case "boolean":
            return value ? "I'm single." : "I'm not single.";
        default:
            console.log("Invalid Operation!");
    }
}
// variable bar will be reordered at runtime
function foo2() {
    bar = 0;
    var bar;
    alert(bar);
}
foo2();
// let keyword allows us to set the scope of a variable to a block 
// (if, while, for...) rather than a function block
function foo3() {
    if (true) {
        // let bar: number = 0;
        bar = 1;
    }
    // alert (bar); // error
}
// variable bar can't be reassigned cause const
function foo4() {
    if (true) {
    }
    // alert (bar); // error
}
// immediately invoked functions example 1
var bar = 0; // global
(function () {
    var foo = 0; // in scope of this function
    bar = 1; // in global scope
    console.log(bar); // 1
    console.log(foo); // 0
})();
console.log(bar); // 1
// console.log(foo); // error
// immediately invoked functions example 1
var bar2 = 0; // global
(function (global) {
    var foo = 0; // in scope of this function
    bar2 = 1; // in global scope
    console.log(global.bar); // 1
    console.log(foo); // 
})(this);
console.log(bar); // 1
// console.log(foo); // error
// scope with class
var Counter = (function () {
    function Counter() {
        this._i = 0;
    }
    Counter.prototype.get = function () {
        return this._i;
    };
    Counter.prototype.set = function (val) {
        this._i = val;
    };
    Counter.prototype.increment = function () {
        this._i++;
    };
    return Counter;
})();
var counter = new Counter();
console.log(counter.get()); // 0
counter.set(2);
console.log(counter.get()); // 2
counter.increment();
console.log(counter.get()); // 3
// console.log(counter._i); // Error: Property '_i' is private
// use IIFE to simultaneously allow public acces to methods while retaining
// privacy for variables defined within the function
var Counter1 = (function () {
    var _i = 0;
    function Counter1() {
    }
    Counter1.prototype.get = function () {
        return _i;
    };
    Counter1.prototype.set = function (val) {
        _i = val;
    };
    Counter1.prototype.increment = function () {
        _i++;
    };
    return Counter1;
})();
var counter1 = new Counter1();
console.log(counter1.get()); // 0
counter1.set(2);
console.log(counter1.get()); // 2
counter1.increment();
console.log(counter1.get()); // 3
console.log(counter1._i); // undefined
/*
    Closures are functions that refer to independent (free) variables.
    In other words, the function defined in the closure remembers
    the environment (variables in the scope) in which it was created.
*/
// Generics
var User = (function () {
    function User() {
    }
    return User;
})();
// request a list of users via AJAX
function getUsers(cb) {
    $.ajax({
        url: "api/users",
        method: "GET",
        succes: function (data) {
            cb(data.items);
        },
        error: function (error) {
            cb(null);
        }
    });
}
// invoke the getUsers function
getUsers(function (users) {
    for (var i; users.length; i++) {
        console.log(users[i].name);
    }
});
var Order = (function () {
    function Order() {
    }
    return Order;
})();
function getOrders(cb) {
    $.ajax({
        url: "api/orders",
        method: "GET",
        succes: function (data) {
            cb(data.items);
        },
        error: function (error) {
            cb(null);
        }
    });
}
// invoke the getOrders function
getOrders(function (users) {
    for (var i; users.length; i++) {
        console.log(users[i].name);
    }
});
// use generics
// angle brackets indicate that it is a generic function
// character T is used to refer to a type
function getEntities(url, cb) {
    $.ajax({
        url: url,
        method: "GET",
        success: function (data) {
            cb(data.items);
        },
        error: function (error) {
            cb(null);
        }
    });
}
getEntities("/api/users", function (users) {
    for (var i; users.length; i++) {
        console.log(users[i].name);
    }
});
getEntities("/api/orders", function (users) {
    for (var i; users.length; i++) {
        console.log(users[i].name);
    }
});
// tag functions and tagged templates
var personName = 'remo';
var personSurname = 'jansen';
var html2 = "<h1>" + personName + " " + personSurname + "</h1>";
// when we apply a tag function to a template string, 
// the template string becomes a tagged template
// Tagged templates are only available when targeting ECMAScript 6 and higher.
//var html = htmlEscape`<h1>${personName} ${personSurname}</h1>`;
// signature of a tag function:
// tag(literals : string[], ...values : any[]) : string
// implementation of htmlEscape tag function
// the main benefit of using a tagged function is that it allows us to create
// custom template string processors
function htmlEscape(literals) {
    var placeholders = [];
    for (var _i = 1; _i < arguments.length; _i++) {
        placeholders[_i - 1] = arguments[_i];
    }
    /*let*/ var result = "";
    for (var i = 0; i < placeholders.length; i++) {
        result += literals[i];
        result += placeholders[i].replace(/&/g, '&amp;').replace(/"/g, '&quot;').replace(/'/g, '&#39;').replace(/</g, '&lt;').replace(/>/g, '&gt;');
    }
    result += literals[literals.length - 1];
    return result;
}
// callbacks and higher-order functions
// the function passed to another as an argument is known as a callback
// the functions that accept functions as parameters (callbacks) or return
// functions as an argument are known as highter-order functions
// callback
var foo = function () {
    console.log('foo');
};
// higher order function
function bar3(cb) {
    console.log('bar');
    cb();
}
// prints 'bar' then prints 'foo'
bar3(foo);
// arrow functions
// difference behaves this operator in TypeScript
var Person = (function () {
    function Person(name) {
        this.name = name;
    }
    Person.prototype.greet = function () {
        alert("Hi! My name is " + this.name);
    };
    Person.prototype.greetDelay = function (time) {
        setTimeout(function () {
            alert("Hi! My name is " + this.name);
        }, time);
    };
    return Person;
})();
var remo = new Person("Remo");
remo.greet(); // "Hi! My name is remo"
// we define an anonymous function (the callback), the this keyword
// changes its value and starts pointing to the anonymous function
remo.greetDelay(1000); // "Hi! My name is "
var Person1 = (function () {
    function Person1(name) {
        this.name = name;
    }
    Person1.prototype.greet = function () {
        alert("Hi! My name is " + this.name);
    };
    Person1.prototype.greetDelay = function (time) {
        var _this = this;
        setTimeout(function () {
            alert("Hi! My name is " + _this.name);
        }, time);
    };
    return Person1;
})();
var remo = new Person1("remo");
remo.greet(); // "Hi! My name is remo"
// using an arrow function, we can ensure that the this operator still 
// points to the Person1 instance and not to the setTimeout callback
remo.greetDelay(1000); // "Hi! My name is remo"
