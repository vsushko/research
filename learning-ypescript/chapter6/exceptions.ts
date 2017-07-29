// exception handling

// The error class 
throw new Error();

// custom string
//Throw new Error("My basic custom error");

module CustomException {
    export declare class Error {
        public name: string;
        public message: string;
        public stack: string;
        constructor(message?: string);
    }
    export class Exception extends Error {
        constructor(public message: string) {
            super(message);
            this.name = 'Exception';
            this.message = message;
            this.stack = (<any>new Error()).stack;
        }
        toString() {
            return this.name + ': ' + this.message;
        }
    }
}

// create customError by inheritin from Exception class
class customError extends CustomException.Exception { }

// the try...catch statements and throw statements
try {
    // code that we want to work
    throw new Error("Oops!");
} catch(e) {
    // code executed if expected to work fails
    console.log(e);
} finally {
    // code executed always after try or try and catch (when errors)
    console.log("finally!");
}

