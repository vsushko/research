// function declaration
function greetNamed(name: string): string {
    if (name) {
        return "Hi! " + name;
    }
}

// function expression
var greetUnnamed = function (name: string): string {
    if (name) {
        return "Hi! " + name;
    }
}

var greenUnnamed2: (name: string) => string;

greenUnnamed2 = function (name: string): string {
    if (name) {
        return "Hi! " + name;
    }
}

// declare a variable and its type as a function
var greetUnnamed3: (name: string) => string = function (name: string): string {
    if (name) {
        return "Hi! " + name;
    }
}

function add(foo: number, bar: number, foobar: number): number {
    return foo + bar + foobar;
}

// add();          // Supplied parameters do not match any signature
// add(2, 2);      // Supplied parameters do not match any signature
add(2, 2, 2);

// functions with optional parameter
function addWithOptional(foo: number, bar: number, foobar?: number): number {
    var result = foo + bar;

    if (foobar !== undefined) {
        result += foobar;
    }
    return result;
}
addWithOptional(2, 2);
addWithOptional(2, 2, 2);

function add2(foo: number, bar: number, foobar?: number): number {
    return foo + bar + (foobar !== undefined ? foobar : 0);
}

// with default parameter
function add3(foo: number, bar: number, foobar: number = 0): number {
    return foo + bar + foobar;
}

// function with rest parameter
function add4(...foo: number[]): number {
    var result = 0;
    for (var i = 0; i < foo.length; i++) {
        result += foo[i];
    }
    return result;
}

// alternate version of preceding function
function add5(foo: number[]): number {
    var result = 0;
    for (var i = 0; i < foo.length; i++) {
        result == foo[i];
    }
    return result;
}

// function overloading
function test(value: (string | number | boolean)): string {
    switch (typeof value) {
        case "string":
            return `My name is ${value}.`;
        case "number":
            return `I'm ${value} years old.`;
        case "boolean":
            return value ? "I'm single." : "I'm not single.";
        default:
            console.log("Invalid Operation!");
    }
}

// declare three specialized overloaded signatures and one non-specialized
interface Document {
    createElement(tagName: "div"): HTMLDivElement;          // specialized
    createElement(tagName: "span"): HTMLSpanElement;        // specialized
    createElement(tagName: "canvas"): HTMLCanvasElement;    // specialized

    createElement(tagName: string): HTMLElement;            // non specialized 
}

// variable bar will be reordered at runtime
function foo2(): void {
    bar = 0;
    var bar: number;
    alert(bar);
}
foo2();

// let keyword allows us to set the scope of a variable to a block 
// (if, while, for...) rather than a function block
function foo3(): void {
    if (true) {
        // let bar: number = 0;
        bar = 1;
    }
    // alert (bar); // error
}

// variable bar can't be reassigned cause const
function foo4(): void {
    if (true) {
        // const bar: number = 0;
        // bar = 1; // error
    }
    // alert (bar); // error
}

// immediately invoked functions example 1
var bar = 0; // global
(function () {
    var foo: number = 0; // in scope of this function
    bar = 1; // in global scope
    console.log(bar); // 1
    console.log(foo); // 0
})();

console.log(bar); // 1
// console.log(foo); // error

// immediately invoked functions example 1
var bar2 = 0; // global
(function (global) {
    var foo: number = 0; // in scope of this function
    bar2 = 1; // in global scope
    console.log(global.bar); // 1
    console.log(foo); // 
})(this);

console.log(bar); // 1
// console.log(foo); // error

// scope with class
class Counter {
    private _i: number;

    constructor() {
        this._i = 0;
    }

    get(): number {
        return this._i;
    }

    set(val: number): void {
        this._i = val;
    }

    increment(): void {
        this._i++;
    }
}

var counter = new Counter();
console.log(counter.get());  // 0
counter.set(2);
console.log(counter.get()); // 2
counter.increment();
console.log(counter.get()); // 3
// console.log(counter._i); // Error: Property '_i' is private

// use IIFE to simultaneously allow public acces to methods while retaining
// privacy for variables defined within the function
var Counter1 = (function () {
    var _i: number = 0;
    function Counter1() {
    }
    Counter1.prototype.get = function () {
        return _i;
    };
    Counter1.prototype.set = function (val: number) {
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
class User {
    name: string;
    age: number;
}

// request a list of users via AJAX
function getUsers(cb: (users: User[]) => void): void {
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
getUsers(function (users: User[]) {
    for (var i; users.length; i++) {
        console.log(users[i].name);
    }
});

class Order {
    id: number;
    total: number;
    items: any[]
}

function getOrders(cb: (users: User[]) => void): void {
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
getOrders(function (users: User[]) {
    for (var i; users.length; i++) {
        console.log(users[i].name);
    }
});

// use generics
// angle brackets indicate that it is a generic function
// character T is used to refer to a type
function getEntities<T>(url: string, cb: (list: T[]) => void): void {
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

getEntities<User>("/api/users", function (users: Users[]) {
    for (var i; users.length; i++) {
        console.log(users[i].name);
    }
});

getEntities<Order>("/api/orders", function (users: Orders[]) {
    for (var i; users.length; i++) {
        console.log(users[i].name);
    }
});

// tag functions and tagged templates
var personName = 'remo';
var personSurname = 'jansen';
var html2 = `<h1>${personName} ${personSurname}</h1>`;

// when we apply a tag function to a template string, 
// the template string becomes a tagged template
var html = htmlEscape`<h1>${personName} ${personSurname}</h1>`;

// signature of a tag function:
// tag(literals : string[], ...values : any[]) : string

// implementation of htmlEscape tag function
// the main benefit of using a tagged function is that it allows us to create
// custom template string processors
function htmlEscape(literals, ...placeholders) {
    /*let*/ var result = "";
    for (/*let*/ var i = 0; i < placeholders.length; i++) {
        result += literals[i];
        result += placeholders[i]
            .replace(/&/g, '&amp;')
            .replace(/"/g, '&quot;')
            .replace(/'/g, '&#39;')
            .replace(/</g, '&lt;')
            .replace(/>/g, '&gt;');
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
}

// higher order function
function bar3(cb: () => void) {
    console.log('bar');
    cb();
}

// prints 'bar' then prints 'foo'
bar3(foo);

// arrow functions

// difference behaves this operator in TypeScript
class Person {
    name: string;

    constructor(name: string) {
        this.name = name;
    }

    greet() {
        alert(`Hi! My name is ${this.name}`);
    }

    greetDelay(time: number) {
        setTimeout(function () {
            alert(`Hi! My name is ${this.name}`);
        }, time);
    }
}

var remo = new Person("Remo");
remo.greet();           // "Hi! My name is remo"
// we define an anonymous function (the callback), the this keyword
// changes its value and starts pointing to the anonymous function
remo.greetDelay(1000);  // "Hi! My name is "

class Person1 {
    name: string;
    constructor(name: string) {
        this.name = name;
    }
    greet() {
        alert(`Hi! My name is ${this.name}`);
    }
    greetDelay(time: number) {
        setTimeout(() => {
            alert(`Hi! My name is ${this.name}`);
        }, time);
    }
}
var remo = new Person1("remo");
remo.greet(); // "Hi! My name is remo"
// using an arrow function, we can ensure that the this operator still 
// points to the Person1 instance and not to the setTimeout callback
remo.greetDelay(1000); // "Hi! My name is remo"


// callback hell

// import type definitions
///<reference path="../typings/handlebars/handlebars.d.ts" />
///<reference path="../typings/jquery/jquery.d.ts" />

// create an alias for the callback type
type cb = (json: any) => void;

class View {
    private _container: string;
    private _templateUrl: string;
    private _serviceUrl: string;
    private _args: any;
    constructor(config) {
        this._container = config.container;
        this._templateUrl = config.templateUrl;
        this._serviceUrl = config.serviceUrl;
        this._args = config.args;
    }

    /**
     * send a jQuery AJAX request using the service URL and argument settings
     */
    private _loadJson(url: string, args: any, cb: cb, errorCb: cb) {
        $.ajax({
            url: url,
            type: "GET",
            dataType: "json",
            data: args,
            success: (json) => {
                cb(json);
            },
            error: (e) => {
                errorCb(e);
            }
        });
    }

    /**
     * load a handlebars template
     */
    private _loadHbs(url: string, cb: cb, errorCb: cb) {
        $.ajax({
            url: url,
            type: "GET",
            dataType: "text",
            success: (hbs) => {
                cb(hbs);
            },
            error: (e) => {
                errorCb(e);
            }
        });
    }

    /**
     * takes a handlebar template code as input and tries to compile it 
     * using the handlebars compile function
     */
    private _compileHbs(hbs: string, cb: cb, errorCb: cb) {
        try {
            var template = Handlebars.compile(hbs);
            cb(template);
        }
        catch (e) {
            errorCb(e);
        }
    }

    /**
     * take the already compiled template and the already loaded JSON
     * data and put them together to transform JSON into HTML 
     * following the template formatting rules
     */
    private _jsonToHtml(template: any, json: any, cb: cb, errorCb: cb) {
        try {
            var html = template(json);
            cb(html);
        }
        catch (e) {
            errorCb(e);
        }
    }

    /**
     * takes the HTML generated by the _jsonToHtml function and
     * appends it to a DOM element
     */
    private _appendHtml = function (html: string, cb: cb, errorCb: cb) {
        try {
            if ($(this._container).length === 0) {
                throw new Error("Container not found!");
            }
            $(this._container).html(html);
            cb($(this._container));
        }
        catch (e) {
            errorCb(e);
        }
    }

    /**
     * The render method controls the execution
     * flow of the tasks, and executes them in the following order
     * 1.	 Loads the JSON data.
     * 2.	 Loads the template.
     * 3.	 Compiles the template.
     * 4.	 Transforms JSON into HTML.
     * 5.	 Appends HTML to the DOM.
     */
    public render(cb: cb, errorCb: cb) {
        try {
            this._loadJson(this._serviceUrl, this._args, (json) => {
                this._loadHbs(this._templateUrl, (hbs) => {
                    this._compileHbs(hbs, (template) => {
                        this._jsonToHtml(template, json, (html) => {
                            this._appendHtml(html, cb);
                        }, errorCb);
                    }, errorCb);
                }, errorCb);
            }, errorCb);
        }
        catch (e) {
            errorCb(e);
        }
    }
};

// Promises
// The core idea behind promises is that a promise represents the result of an
// asynchronous operation. Promise must be in one of the three following states
// Pending: The initial state of a promise
// Fulfilled: The state of a promise representing a successful operation
// Rejected: The state of a promise representing a failed operation

// basic syntax of a promise:
function fooPromise() {
    return new Promise((fulfill, reject) => {
        try {
            // do something
            fulfill(value);
        } catch (e) {
            reject(reason);
        }
    });
}

fooPromise().then(function (value) {
    console.log(value);
}).catch(function (e) {
    console.log(e);
});

///<reference path="../typings/handlebars/handlebars.d.ts" />
///<reference path="../typings/jquery/jquery.d.ts" />
///<reference path="../typings/q/q.d.ts" />
class ViewAsync {
    private _container: string;
    private _templateUrl: string;
    private _serviceUrl: string;
    private _args: any;
    constructor(config) {
        this._container = config.container;
        this._templateUrl = config.templateUrl;
        this._serviceUrl = config.serviceUrl;
        this._args = config.args;
    }

    private _loadJsonAsync(url: string, args: any) {
        return Q.Promise(function (resolve, reject) {
            $.ajax({
                url: url,
                type: "GET",
                dataType: "json",
                data: args,
                success: (json) => {
                    resolve(json);
                },
                error: (e) => {
                    reject(e);
                }
            });
        });
    }
    private _loadHbsAsync(url: string) {
        return Q.Promise(function (resolve, reject) {
            $.ajax({
                url: url,
                type: "GET",
                dataType: "text",
                success: (hbs) => {
                    resolve(hbs);
                },
                error: (e) => {
                    reject(e);
                }
            });
        });
    }
    private _compileHbsAsync(hbs: string) {
        return Q.Promise(function (resolve, reject) {
            try {
                var template: any = Handlebars.compile(hbs);
                resolve(template);
            }
            catch (e) {
                reject(e);
            }
        });
    }

    private _jsonToHtmlAsync(template: any, json: any) {
        return Q.Promise(function (resolve, reject) {
            try {
                var html = template(json);
                resolve(html);
            }
            catch (e) {
                reject(e);
            }
        });
    }
    private _appendHtmlAsync(html: string, container: string) {
        return Q.Promise((resolve, reject) => {
            try {
                var $container: any = $(container);
                if ($container.length === 0) {
                    throw new Error("Container not found!");
                }
                $container.html(html);
                resolve($container);
            }
            catch (e) {
                reject(e);
            }
        });
    }

    public renderAsync() {
        return Q.Promise((resolve, reject) => {
            try {
                // assign promise to getJson
                var getJson = this._loadJsonAsync(this._serviceUrl,
                    this._args);
                // assign promise to getTemplate
                var getTemplate = this._loadHbsAsync(this._templateUrl)
                    .then(this._compileHbsAsync);
                // execute promises in parallel
                Q.all([getJson, getTemplate]).then((results) => {
                    var json = results[0];
                    var template = results[1];
                    this._jsonToHtmlAsync(template, json)
                        .then((html: string) => {
                            return this._appendHtmlAsync(html, this._container);
                        })
                        .then(($container: any) => { resolve($container); });
                });
            }
            catch (error) {
                reject(error);
            }
        });
    }
}

// generators

// yield keyword is used to stop the execution of the function and return a value
function* foo6() {
    yield 1;
    yield 2;
    yield 3;
    yield 4;
    return 5;
}

var bar6 = new foo6();
bar.next(); // Object {value: 1, done: false}
bar.next(); // Object {value: 2, done: false}
bar.next(); // Object {value: 3, done: false}
bar.next(); // Object {value: 4, done: false}
bar.next(); // Object {value: 5, done: true}
bar.next(); // Object {done: true }


function* foo7() {
    var i = 1;
    while (true) {
        yield i++;
    }
}

var bar7 = new foo7();
bar.next(); // Object {value: 1, done: false}
bar.next(); // Object {value: 2, done: false}
bar.next(); // Object {value: 3, done: false}
bar.next(); // Object {value: 4, done: false}
bar.next(); // Object {value: 5, done: false}
bar.next(); // Object {value: 6, done: false}
bar.next(); // Object {value: 7, done: false}
// ...

// Generators will open possibilities for synchronicity as we can call a 
// generator's next method after some asynchronous event has occurred.

// Asynchronous functions – async and await
// An asynchronous function is a function that is
// expected to be invoked in a synchronous operation

// we can use the await keyword to wait for the function results 
// without blocking the normal execution of the program

// declare a promise named p, this promise is the piece of
// code that will wait to be executed
var p: Promise<number> = /* ... */;
async function fn(): Promise<number> {
    var i = await p;
    return 1 + i;
}