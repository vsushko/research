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
        }
    }
}

var army = makeArmy();
console.log(army[0]());
console.log(army[5]());

function makeAnotherArmy() {
    var shooters = []
    for (var i = 0; i < 10; i++) {
        (function (i) {
            var shooter = function () {
                alert(i);
            }
            shooters.push(shooter)
        })(i);
    }
    return shooters;
}
var anotherArmy = makeAnotherArmy();
// console.log(army[0]()); // 0
// console.log(army[5]()); // 5

class Counter {
    private static _COUNTER = 0;

    constructor() { }

    private _changeBy(val) {
        Counter._COUNTER += val;
    }

    public increment() {
        this._changeBy(1);
    }

    public decrement() {
        this._changeBy(-1);
    }

    public value() {
        return Counter._COUNTER;
    }
}

var counter1 = new Counter();
var counter2 = new Counter();
console.log(counter1.value()); // 0
console.log(counter2.value()); // 0
counter1.increment();
counter1.increment();
console.log(counter1.value()); // 2
console.log(counter2.value()); // 2 (expected 0)
counter1.decrement();
console.log(counter1.value()); // 1
console.log(counter2.value()); // 1 (expected 0)

// private members with closures
function makeCounter() {
    // closure context
    var _COUNTER = 0;
    function changeBy(val) {
        _COUNTER += val;
    }
    function Counter() { };
    Counter.prototype.increment = function () {
        changeBy(1);
    };
    Counter.prototype.decrement = function () {
        changeBy(-1);
    };
    Counter.prototype.value = function () {
        return _COUNTER;
    };
    return new Counter();
};

counter1 = makeCounter();
counter2 = makeCounter();
console.log(counter1.value()); // 0
console.log(counter2.value()); // 0
counter1.increment();
counter1.increment();
console.log(counter1.value()); // 2
console.log(counter2.value()); // 0 (expected 0)
counter1.decrement();
console.log(counter1.value()); // 1
console.log(counter2.value()); // 0 (expected 0)

// console.log(counter1.counter); // undefined
// counter1.changeBy(2); // changeBy is not a function
// console.log(counter1.value()); // 1



