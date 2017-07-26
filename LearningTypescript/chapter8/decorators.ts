class Person {
    public name: string;
    public surname: string;

    constructor(name: string, surname: string) {
        this.name = name;
        this.surname = surname;
    }

    public saySomething(something: string): string {
        return this.name + " " + this.surname + " says: " + something;
    }
}

// class decorators
function logClass(traget: any) {
    // ...
}

@logClass
class Person {
    public name: string;
    public surname: string;
}



// A class decorator function is a function that accepts a constructor function
// as argument, and returns either undefined, the provided constructor function,
// or a new constructor function. Returning undefined is equivalent to returning
// the provided constructor function.

// Method decorators
// A method decorator function is a function that accepts three arguments:
// The object that owns the property, the key for the property (a string or a symbol),
// and optionally the property descriptor of the property. The function must return
// either undefined, the provided property descriptor, or a new property descriptor.
// Returning undefined is equivalent to returning the provided property descriptor.

// Property decorators
// A property decorator function is a function that accepts two arguments: The object
// that owns the property and the key for the property (a string or a symbol). A property
// decorator does not return.

// Parameter decorators
// A parameter decorator function is a function that accepts three arguments: The
// object that owns the method that contains the decorated parameter, the property key
// of the property (or undefined for a parameter of the constructor), and the ordinal
// index of the parameter. The return value of this decorator is ignored.

// Decorator factory
// A decorator factory is a function that can accept any number of arguments, and
// must return one of the above types of decorator function

// Decorators with parameters


// type - serialized
// void - undefined
// string - String
// number - Number
// boolean - Boolean
// symbol - Symbol
// any - Object
// enum - Number
// Class C{} - C
// Object literal {} - Object
// interface - Object
