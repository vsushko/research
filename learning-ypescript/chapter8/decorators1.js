var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var __param = (this && this.__param) || function (paramIndex, decorator) {
    return function (target, key) { decorator(target, key, paramIndex); }
};
function logClass(target) {
    var original = target;
    function construct(constructor, args) {
        var c = function () {
            return constructor.apply(this, args);
        };
        c.prototype = constructor.prototype;
        return new c();
    }
    var f = function () {
        var args = [];
        for (var _i = 0; _i < arguments.length; _i++) {
            args[_i] = arguments[_i];
        }
        console.log("New: " + original.name);
        return construct(original, args);
    };
    f.prototype = original.prototype;
    return f;
}
function logMethod(target, key, descriptor) {
    var originalMethod = descriptor.value;
    descriptor.value = function () {
        var args = [];
        for (var _i = 0; _i < arguments.length; _i++) {
            args[_i] = arguments[_i];
        }
        var a = args.map(function (a) { return JSON.stringify(a); }).join();
        var result = originalMethod.apply(this, args);
        var r = JSON.stringify(result);
        console.log("Call: " + key + "(" + a + ") => " + r);
        return result;
    };
    return descriptor;
}
function logProperty(target, key) {
    var _val = this[key];
    var getter = function () {
        console.log("Get: " + key + " => " + _val);
        return _val;
    };
    var setter = function (newVal) {
        console.log("Set: " + key + " => " + newVal);
        _val = newVal;
    };
    if (delete this[key]) {
        Object.defineProperty(target, key, {
            get: getter,
            set: setter,
            enumerable: true,
            configurable: true
        });
    }
}
function addMetadata(target, key, index) {
    var metadataKey = "_log_" + key + "_parameters";
    if (Array.isArray(target[metadataKey])) {
        target[metadataKey].push(index);
    }
    else {
        target[metadataKey] = [index];
    }
}
function readMetadata(target, key, descriptor) {
    var originalMethod = descriptor.value;
    descriptor.value = function () {
        var args = [];
        for (var _i = 0; _i < arguments.length; _i++) {
            args[_i] = arguments[_i];
        }
        var metadataKey = "_log_" + key + "_parameters";
        var indices = target[metadataKey];
        if (Array.isArray(indices)) {
            for (var i = 0; i < args.length; i++) {
                if (indices.indexOf(i) !== -1) {
                    var arg = args[i];
                    var argStr = JSON.stringify(arg) || arg.toString();
                    console.log(key + " arg[" + i + "]: " + argStr);
                }
            }
            var result = originalMethod.apply(this, args);
            return result;
        }
    };
    return descriptor;
}
function log() {
    var args = [];
    for (var _i = 0; _i < arguments.length; _i++) {
        args[_i] = arguments[_i];
    }
    switch (args.length) {
        case 1:
            return logClass.apply(this, args);
        case 2:
            // break instead of return as property
            // decorators don't have a return
            logProperty.apply(this, args);
            break;
        case 3:
            if (typeof args[2] === "number") {
                logParameter.apply(this, args);
            }
            return logMethod.apply(this, args);
        default:
            throw new Error("Decorators are not valid here!");
    }
}
function logClass(option) {
    return function (target) {
        var original = target;
        function construct(constructor, args) {
            var c = function () {
                return constructor.apply(this, args);
            };
            c.prototype = constructor.prototype;
            return new c();
        }
        var f = function () {
            var args = [];
            for (var _i = 0; _i < arguments.length; _i++) {
                args[_i] = arguments[_i];
            }
            console.log("New: " + original.name);
            return construct(original, args);
        };
        f.prototype = original.prototype;
        return f;
        console.log(target, option);
    };
}
var Person = (function () {
    function Person(name, surname) {
        this.name = name;
        this.surname = surname;
    }
    Person.prototype.saySomething = function (something) {
        return this.name + " " + this.surname + " says: " + something;
    };
    __decorate([
        logProperty,
        __metadata("design:type", String)
    ], Person.prototype, "name", void 0);
    __decorate([
        logMethod,
        readMetadata,
        __param(0, addMetadata),
        __metadata("design:type", Function),
        __metadata("design:paramtypes", [String]),
        __metadata("design:returntype", String)
    ], Person.prototype, "saySomething", null);
    Person = __decorate([
        logClass("option"),
        __metadata("design:paramtypes", [String, String])
    ], Person);
    return Person;
}());
var me = new Person("Vasiliy", "Sushko");
me.name = "Vasiliy A.";
var n = me.name;
me.saySomething("hello!");
