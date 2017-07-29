// var declarations and hoisting
// variable declarations using var are treated as if they're at the top of the function
// or in the glogal scope, if declared outside of a function
// this is called hoisting

function getValue(condition) {
    if (condition) {
        var value = "blue";
        // other code
        return value;
    } else {
        // value exists here with a value of undifined
        return null;
    }
    // value exists here with a value of undifined
}

// the javascript engine changes the getValue functino to look like this:
// the declaration of value is hoisted to the top
function getValue(condition) {
    var value;
    if (condition) {
        value = "blue";
        // other code
        return value;
    } else {
        return null;
    }
}
