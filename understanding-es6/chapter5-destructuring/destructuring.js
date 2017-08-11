// fetch information from objects and arrays earlier in es5
let option = {
    repeat: true,
    save: false
}

// extract data from the object
let repeat = option.repeat,
    save = option.save;

// object destructuring
let node = {
    type: "Identifier",
    name: "foo"
};

let { type, name } = node;

console.log(type); // "Identifier"
console.log(name); // "foo"

// syntax error!
var { type, name };
// syntax error!
let { type, name };
// syntax error!
const { type, name };

// destructuring assignment
let node = {
    type: "Identifier",
    name: "foo"
}, type = "Literal", name = 5;

// assign different values using destructuring
// the parentheses signal that the next curly brace is not block statement
// and should be interpreted as an expression, allowing the assignment co complete
({ type, name } = node);
console.log(type); // "Identifier"
console.log(name); // "foo"

let node = {
    type: "Identifier",
    name: "foo"
}, type = "Literal", name = 5;

function outputInfo(value) {
    console.log(value === node); // true
}

outputInfo({ type, name } = node);
console.log(type); // "Identifier"
console.log(name); // "foo"

// default values
let node = {
    type: "Identifier",
    name: "foo"
};

let { type, name, value } = node;

console.log(type); // "Identifier"
console.log(name); // "foo"
console.log(value); // undefined

// with specifying default value
let node = {
    type: "Identifier",
    name: "foo"
};

let { type, name, value = true } = node;

console.log(type); // "Identifier"
console.log(name); // "foo"
console.log(value); // true

// assigning to different local valiable names
let node = {
    type: "Identifier",
    name: "foo"
};

let { type: localType, name: localName } = node;

console.log(localType); // "Identifier"
console.log(localName); // "foo"

// with default values
let node = {
    type: "Identifier"
};

let { type: localType, name: localName = "bar" } = node;

console.log(localType); // "Identifier"
console.log(localName); // "bar"

// nested object destructuring
let node = {
    type: "Identifier",
    name: "foo",
    loc: {
        start: {
            line: 1,
            column: 1
        },
        end: {
            line: 1,
            column: 4
        }
    }
};

let { loc: { start } } = node;

console.log(start.line); // 1
console.log(start.columng); // 1

// extract node.log.start
let { loc: { start: localStart } } = node;

console.log(localStart.line); // 1
console.log(localStart.columng); // 1

// no variables declared!
let { loc: { } } = node;

// array destructuring
let colors = ["red", "green", "blue"];
let [firstColor, secondColor] = colors;

console.log(firstColor); // "red"
console.log(secondColor); // "green"

// omit items in the destructuring pattern
let colors = ["red", "green", "blue"];
let [, , thirdColor] = colors;

console.log(secondColor); // "blue"

// destructuring assignment
let colors = ["red", "green", "blue"],
    firstColor = "black",
    secondColor = "purple";

[firstColor, secondColor] = colors;
console.log(firstColor);  // "red"
console.log(secondColor); // "green"

// swapping variables in ECMAScript 5
let a = 1,
    b = 2,
    tmp;

tmp = a;
a = b;
b = a;

console.log(a); // 2
console.log(b); // 1

// swapping variables in es6
let a = 1, b = 2;
[a, b] = [b, a];

console.log(a); // 2
console.log(b); // 1

// default values
let colors = ["red"];
let [firstColor, secondColor = "green"] = colors;

console.log(firstColor); // "red"
console.log(secondColor); // "green"

// nested array destructuring
let colors = ["red", ["green", "lightgreen"], "blue"];
// later
let [firstColor, [secondColor]] = colors;

console.log(firstColor); // "red"
console.log(secondColor); // "green"

// rest items
let colors = ["red", "green", "blue"];
let [firstColor, ...restColors] = colors;
console.log(firstColor); // "red"
console.log(restColors.length); // 2
console.log(restColors[0]); // "green"
console.log(restColors[1]); // "blue"

// cloning an array in ECMAScript 5
var colors = ["red", "green", "blue"];
var clonedColors = colors.concat();
console.log(clonedColors); // "[red,green,blue]"

// cloning an array in ECMAScript 6
let colors = ["red", "green", "blue"];
let [...clonedColors] = colors;
console.log(clonedColors); // "[red,green,blue]"

// mixed destructuring
let node = {
    type: "Identifier",
    name: "foo",
    loc: {
        start: {
            line: 1,
            column: 1
        },
        end: {
            line: 1,
            column: 4
        }
    },
    range: [0, 3]
};

let {
    loc: { start },
    range: [startIndex]
} = node;

console.log(start.line); // 1
console.log(start.column); // 1
console.log(startIndex); // 0

// destructured parameters
// properties on options represent additional parameters
function setCookie(name, value, options) {

    options = options || {};

    let secure = options.secure,
        path = options.path,
        domain = options.domain,
        expires = options.expires;
    // code to set the cookie
}

// third argument maps to options 
setCookie("type", "js", {
    secure: true,
    expires: 60000
});

// rewritten version of setCookie()
function setCookie(name, value, { secure, path, domain, expires }) {
    let { secure, path, domain, expires } = options;
}

setCookie("type", "js", {
    secure: true,
    expires: 60000
});

// destructured parameters are required
// error! - the missing third argument evalueates to undefined
setCookie("type", "js");

// set destructured parameter to be optional
function setCookie(name, value, { secure, path, domain, expires } = {}) {
    // empty
}

// default values for destructured parameters
function setCookie(name, value, {
    secure = false,
    path = "/",
    domain = "example.com",
    expires = new Date(Date.now() + 360000000)
} = {}) {
    // empty
}
