var t: number = 1;

var counter1;              // unknown (any) type
var counter2 = 0;          // number (inferred)
var counter3: number;     // number
var counter4: number = 0; // number

// boolean
var isDone: boolean = false;

// number
var height: number = 6;

// string 
var personName: string = "bob";
personName = 'smith';

// array
var list: number[] = [1, 2, 3];
var list: Array<number> = [1, 2, 3];

// enum
enum Color {
    Red,
    Green,
    Blue
};

var c: Color = Color.Green;

// any represent any JavaScript value
var notSure: any = 4;
notSure = "maybe a string instead";
notSure = "false"; // okay, definitely a boolean

var listOfAnyValues: any[] = [1, true, "free"];
listOfAnyValues[1] = 100;

// void
function warnUser(): void {
    alert("This is my warning message");
}

// in typescript we will not be able to use null or undefined as types:
// var TestVar : null;       // error, type expected
// var TestVar2 : undefined; // error, cannot find name undefined

// var mynum : number = 1;
// let isValid : boolean = true;
// const apiKey : string = "0E5CE8BD-6341-4CC2-904D-C4A94ACD276E";

// union types
var path: string[] | string;
path = '/temp/log.xml';
path = ['/temp/log.xml', '/temp/errors.xml'];


// type guards
var x: any = { /* ... */ };

if (typeof x === 'string') {
    // console.log(x.splice(3, 1)); // error, 'splice' does not exist on 'string'
}

x.foo(); // OK

// type aliases
type PrimitiveArray = Array<string | number | boolean>;
type MyNumber = number;
//type NgScope = ng.IsScope;
type Callback = () => void;

// ambient declarations
interface ICustomConsole {
    log(arg: string): void;
}

declare var customerConsole: ICustomConsole;

customerConsole.log("Log message");

var isValid: boolean = true;

if (isValid) {
    alert("is valid");
} else {
    alert("Is NOT valid!");
}

var message = isValid ? "Is valid!" : "Is NOT valid!";
alert(message);

enum AlertLevel {
    info,
    warning,
    error
};

function getAlertSubscribers(level: AlertLevel) {
    var emails = new Array<string>();
    switch (level) {
        case AlertLevel.info:
            emails.push("cst@domain.com");
            break;
        case AlertLevel.warning:
            emails.push("development@domain.com");
            emails.push("sysadmin@domain.com");
            break;
        case AlertLevel.error:
            emails.push("development@domain.com");
            emails.push("sysadmin@domain.com");
            emails.push("management@domain.com");
            break;
        default:
            throw new Error("Invalid argument!");
    }
    return emails;
}

getAlertSubscribers(AlertLevel.info);
getAlertSubscribers(AlertLevel.warning);

var i: number = 0;
while (i < 5) {
    i += 1;
    console.log(i);
}

var i: number = 0;
do {
    i += 1;
    console.log(i);
} while (i < 5);

var obj: any = { a: 1, b: 2, c: 3 };
for (var key in obj) {
    console.log(key + " = " + obj[key]);
}

var prop;

for (var key in obj) {
    if (obj.hasOwnProperty(prop)) {
        // prop is not inherited
    }
}

for (var i: number = 0; i < 9; i++) {
    console.log(i);
}

// named function
function greet1(name?: string): string {
    if (name) {
        return "Hi! " + name;
    } else {
        return "Hi!";
    }
}

// anonymous function
var greet2 = function (name?: string): string {
    if (name) {
        return "H1i! " + name;
    } else {
        return "Hi!";
    }
}

// alternative function syntax which uses the arrow (=>) arrow function
var greet3 = (name: string): string => {
    if (name) {
        return "Hi2! " + name;
    } else {
        return "Hi! my name is " + this.fullname;
    }
}

// match the anonymous function signature
var greet4: (name: string) => string = function (name: string): string {
    if (name) {
        return "H1i! " + name;
    } else {
        return "Hi!";
    }
}

// declaring a function named sume that takes two numbers and a callback as a function
function sume(a: number, b: number, callback: (result: number) => void) {
    callback(a + b);
}

// classes
class Character {
    fullname: string;
    constructor(firstname: string, lastname: string) {
        this.fullname = firstname + " " + lastname;
    }
    greet(name?: string) {
        if (name) {
            return "Hi! " + name + "! my name is " + this.fullname;
        }
        else {
            return "Hi! my name is " + this.fullname;
        }
    }
}

var spark = new Character("Jacob", "Keyes");
var msg = spark.greet();
alert(msg);
var msg1 = spark.greet("Dr. Halsey");
alert(msg1);

// interfaces
interface LoggerInterface {
    log(arg: any): void;
}

class Logger implements LoggerInterface {
    log(arg) {
        if (typeof console.log === "function") {
            console.log(arg);
        } else {
            alert(arg);
        }
    }
}

interface UserInterface {
    name: string;
    password: string;
}

var user: UserInterface = {
    name: "",
    password: "" // error property password is missing
};

// namespaces
/*namespace Geometry {
    interface VerctorInterface { };
    export interface Vector2dInterface { };
    export interface Vector3dInterface { };
    export class Vector2d implements VerctorInterface, Vector2dInterface { };
    export class Vector3d implements VerctorInterface, Vector2dInterface { };
};

var vector2dInstance : Geometry.Vector2dInterface = new Geometry.Vector2d;
var vector3dInstance : Geometry.Vector3dInterface = new Geometry.Vector3d;
*/

// putting everything together
module Geometry {

    export interface Vector2dInterface {
        toArray(callback: (x: number[]) => void): void;
        length(): number;
        normalize();
    }
    export class Vector2d implements Vector2dInterface {
        private _x: number;
        private _y: number;

        constructor(x: number, y: number) {
            this._x = x;
            this._y = y;
        }

        toArray(callback: (x: number[]) => void): void {
            callback([this._x, this._y]);
        }

        length(): number {
            return Math.sqrt(this._x * this._y + this._x * this._y);
        }

        normalize() {
            var len = 1 / this.length();
            this._x *= len;
            this._y *= len;
        }
    }
}

var vector: Geometry.Vector2dInterface = new Geometry.Vector2d(2, 3);
vector.normalize();
vector.toArray(function (vectorAsArray: number[]) {
    alert(' x:' + vectorAsArray[0] + ' y: ' + vectorAsArray[1]);
});

