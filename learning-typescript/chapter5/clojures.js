/* Closures are functions that refer to independent (free) variables.
   In other words, the function defined in the closure 'remembers'
   the environment in which it was created.
*/
function makeArmy() {
    var shooters = [];
    for (var i = 0; i < 10; i++) {
        // a shooter is a function
        var shooter = function () {
            // shich should log it's number
            console.log(i);
        };
    }
}
var army = makeArmy();
// console.log(army[0]());
// console.log(army[5]());
function makeAnotherArmy() {
    var shooters = [];
    for (var i = 0; i < 10; i++) {
        (function (i) {
            var shooter = function () {
                alert(i);
            };
            shooters.push(shooter);
        })(i);
    }
    return shooters;
}
var anotherArmy = makeAnotherArmy();
console.log(army[0]()); // 0
console.log(army[5]()); // 5
