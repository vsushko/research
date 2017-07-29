var _this = this;
var t = 1;
var counter1; // unknown (any) type
var counter2 = 0; // number (inferred)
var counter3; // number
var counter4 = 0; // number
// boolean
var isDone = false;
// number
var height = 6;
// string 
var personName = "bob";
personName = 'smith';
// array
var list = [1, 2, 3];
var list = [1, 2, 3];
// enum
var Color;
(function (Color) {
    Color[Color["Red"] = 0] = "Red";
    Color[Color["Green"] = 1] = "Green";
    Color[Color["Blue"] = 2] = "Blue";
})(Color || (Color = {}));
;
var c = 1 /* Green */;
// any represent any JavaScript value
var notSure = 4;
notSure = "maybe a string instead";
notSure = "false"; // okay, definitely a boolean
var listOfAnyValues = [1, true, "free"];
listOfAnyValues[1] = 100;
// void
function warnUser() {
    alert("This is my warning message");
}
// in typescript we will not be able to use null or undefined as types:
// var TestVar : null;       // error, type expected
// var TestVar2 : undefined; // error, cannot find name undefined
// var mynum : number = 1;
// let isValid : boolean = true;
// const apiKey : string = "0E5CE8BD-6341-4CC2-904D-C4A94ACD276E";
// union types
var path;
path = '/temp/log.xml';
path = ['/temp/log.xml', '/temp/errors.xml'];
// type guards
var x = {};
if (typeof x === 'string') {
}
x.foo(); // OK
customerConsole.log("Log message");
var isValid = true;
if (isValid) {
    alert("is valid");
}
else {
    alert("Is NOT valid!");
}
var message = isValid ? "Is valid!" : "Is NOT valid!";
alert(message);
var AlertLevel;
(function (AlertLevel) {
    AlertLevel[AlertLevel["info"] = 0] = "info";
    AlertLevel[AlertLevel["warning"] = 1] = "warning";
    AlertLevel[AlertLevel["error"] = 2] = "error";
})(AlertLevel || (AlertLevel = {}));
;
function getAlertSubscribers(level) {
    var emails = new Array();
    switch (level) {
        case 0 /* info */:
            emails.push("cst@domain.com");
            break;
        case 1 /* warning */:
            emails.push("development@domain.com");
            emails.push("sysadmin@domain.com");
            break;
        case 2 /* error */:
            emails.push("development@domain.com");
            emails.push("sysadmin@domain.com");
            emails.push("management@domain.com");
            break;
        default:
            throw new Error("Invalid argument!");
    }
    return emails;
}
getAlertSubscribers(0 /* info */);
getAlertSubscribers(1 /* warning */);
var i = 0;
while (i < 5) {
    i += 1;
    console.log(i);
}
var i = 0;
do {
    i += 1;
    console.log(i);
} while (i < 5);
var obj = { a: 1, b: 2, c: 3 };
for (var key in obj) {
    console.log(key + " = " + obj[key]);
}
var prop;
for (var key in obj) {
    if (obj.hasOwnProperty(prop)) {
    }
}
for (var i = 0; i < 9; i++) {
    console.log(i);
}
// named function
function greet1(name) {
    if (name) {
        return "Hi! " + name;
    }
    else {
        return "Hi!";
    }
}
// anonymous function
var greet2 = function (name) {
    if (name) {
        return "H1i! " + name;
    }
    else {
        return "Hi!";
    }
};
// alternative function syntax which uses the arrow (=>) arrow function
var greet3 = function (name) {
    if (name) {
        return "Hi2! " + name;
    }
    else {
        return "Hi! my name is " + _this.fullname;
    }
};
// match the anonymous function signature
var greet4 = function (name) {
    if (name) {
        return "H1i! " + name;
    }
    else {
        return "Hi!";
    }
};
// declaring a function named sume that takes two numbers and a callback as a function
function sume(a, b, callback) {
    callback(a + b);
}
// classes
var Character = (function () {
    function Character(firstname, lastname) {
        this.fullname = firstname + " " + lastname;
    }
    Character.prototype.greet = function (name) {
        if (name) {
            return "Hi! " + name + "! my name is " + this.fullname;
        }
        else {
            return "Hi! my name is " + this.fullname;
        }
    };
    return Character;
})();
var spark = new Character("Jacob", "Keyes");
var msg = spark.greet();
alert(msg);
var msg1 = spark.greet("Dr. Halsey");
alert(msg1);
var Logger = (function () {
    function Logger() {
    }
    Logger.prototype.log = function (arg) {
        if (typeof console.log === "function") {
            console.log(arg);
        }
        else {
            alert(arg);
        }
    };
    return Logger;
})();
var user = {
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
