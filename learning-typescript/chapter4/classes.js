var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var Person = (function () {
    function Person(name, surname, email) {
        this.email = email;
        this.name = name;
        this.surname = surname;
    }
    Person.prototype.greet = function () {
        console.log("Hi! I'm " + this.name + ". You can reach me at " + this.email);
    };
    return Person;
})();
var Email = (function () {
    function Email(email) {
        if (this.validateEmail(email)) {
            this.email = email;
        }
        else {
            console.log("Invalid email!");
        }
    }
    Email.prototype.validateEmail = function (email) {
        var re = /\S+@\S+\.\S+/;
        return re.test(this.email);
    };
    Email.prototype.get = function () {
        return this.email;
    };
    return Email;
})();
var email = new Email("remo.jansen@wolksoftware.com");
var me = new Person("Remo", "Jansen", email);
// in typescript:
// an interface can extend another interface or class
// an interface can define data and behaviors as opposed to only behaviors
var Teacher = (function (_super) {
    __extends(Teacher, _super);
    function Teacher(name, surname, email, subjects) {
        _super.call(this, name, surname, email);
        this.subjects = subjects;
    }
    Teacher.prototype.greet = function () {
        _super.prototype.greet.call(this);
        console.log("I teach " + this.subjects);
    };
    Teacher.prototype.teach = function () {
        console.log("Welcome to class!");
    };
    return Teacher;
})(Person);
var SchoolPrincipal = (function (_super) {
    __extends(SchoolPrincipal, _super);
    function SchoolPrincipal() {
        _super.apply(this, arguments);
    }
    SchoolPrincipal.prototype.manageTeachers = function () {
        console.log("We need to help students to get better results!");
    };
    return SchoolPrincipal;
})(Teacher);
var teacher = new Teacher("remo", "jansen", new Email("remo.jansen@wolksoftware.com"), ["math", "physics"]);
me.greet();
teacher.greet();
teacher.teach();
var principal = new SchoolPrincipal("remo", "jansen", new Email("remo.jansen@wolksoftware.com"), ["math", "physics"]);
principal.greet();
principal.teach();
principal.manageTeachers();
// Mixins
// mixins are alternatives to multiple inheritance
// typescript doesn't support multiple inheritance
var Animal = (function () {
    function Animal() {
    }
    Animal.prototype.eat = function () {
        return "Delicious!";
    };
    return Animal;
})();
var Mammal = (function (_super) {
    __extends(Mammal, _super);
    function Mammal() {
        _super.apply(this, arguments);
    }
    Mammal.prototype.breathe = function () {
        return "I'm alive!";
    };
    Mammal.prototype.move = function () {
        return "I can move like a mammal!";
    };
    return Mammal;
})(Animal);
var WingedAnimal = (function (_super) {
    __extends(WingedAnimal, _super);
    function WingedAnimal() {
        _super.apply(this, arguments);
    }
    WingedAnimal.prototype.fly = function () {
        return "I can fly!";
    };
    WingedAnimal.prototype.move = function () {
        return "I can move like a bird!";
    };
    return WingedAnimal;
})(Animal);
var Bat = (function () {
    function Bat() {
    }
    return Bat;
})();
var Bat2 = (function () {
    function Bat2() {
    }
    return Bat2;
})();
/**
 * Iterate each property of the parent classes (contained in an array
 * name baseCtors) and copy the implementation to a child class(derivedCtor)
 */
function applyMixins(derivedCtor, baseCtors) {
    baseCtors.forEach(function (baseCtor) {
        Object.getOwnPropertyNames(baseCtor.prototype).forEach(function (name) {
            if (name !== 'constructor') {
                derivedCtor.prototype[name] = baseCtor.prototype[name];
            }
        });
    });
}
applyMixins(Bat, [Mammal, WingedAnimal]);
var bat = new Bat();
console.log(bat.breathe()); // I'm alive!
console.log(bat.fly()); // I can fly!
console.log(bat.move());
applyMixins(Bat2, [WingedAnimal, Mammal]);
var bat2 = new Bat2();
// console.log(bat2.eat()); // Error: not a function
console.log(bat2.breathe()); // I'm alive!
console.log(bat2.fly()); // I can fly!
console.log(bat2.move()); // I can move like a mammal
// Generic classes
var User = (function () {
    function User() {
    }
    User.prototype.isValid = function () {
        // user validation
        return true;
    };
    return User;
})();
var Talk = (function () {
    function Talk() {
    }
    Talk.prototype.isValid = function () {
        // talk validation
        return true;
    };
    return Talk;
})();
// create a Generic repository
var GenericRepository = (function () {
    function GenericRepository(url) {
        this._url = url;
    }
    GenericRepository.prototype.getAsync = function () {
        var _this = this;
        return Q.Promise(function (resolve, reject) {
            $.ajax({
                url: _this._url,
                type: "GET",
                dataType: "json",
                success: function (data) {
                    var items = data.items;
                    for (var i = 0; i < items.length; i++) {
                        if (items[i].isValid()) {
                            list.push(items[i]);
                        }
                    }
                    resolve(list);
                },
                error: function (e) {
                    reject(e);
                }
            });
        });
    };
    return GenericRepository;
})();
var userRepository = new GenericRepository("./users.json");
userRepository.getAsync().then(function (users) {
    console.log(users);
});
var talkRepository = new GenericRepository("./talks.json");
talkRepository.getAsync().then(function (talks) {
    console.log(talks);
});
;
var Example = (function () {
    function Example() {
    }
    Example.prototype.useT = function () {
        this.genericProperty.doSomething();
        this.genericProperty.doSomethingElse(); // there no error anymore
    };
    return Example;
})();
// the new operator in generic types
// to create a new object within generic code, we need to indicate 
// that the generic type T has a constructor function { new(): T;}
function factory() {
    var type;
    return new type();
}
var MyClass = (function () {
    function MyClass() {
    }
    return MyClass;
})();
var myClass = factory();
// use cookies as the storage for the application's data
var CookiePersitanceService = (function () {
    function CookiePersitanceService() {
    }
    CookiePersitanceService.prototype.save = function (entity) {
        var id = Math.floor((Math.random() * 100) + 1);
        // Cookie persistance logic...
        return id;
    };
    return CookiePersitanceService;
})();
var LocalStoragePersitanceService = (function () {
    function LocalStoragePersitanceService() {
    }
    LocalStoragePersitanceService.prototype.save = function (entity) {
        var id = Math.floor((Math.random() * 100) + 1);
        // Local storage persistance logic...
        return id;
    };
    return LocalStoragePersitanceService;
})();
var FavouritesController = (function () {
    function FavouritesController(persistanceService) {
        this._persistanceService = persistanceService;
    }
    FavouritesController.prototype.saveAsFavourite = function (articleId) {
        return this._persistanceService.save(articleId);
    };
    return FavouritesController;
})();
var favController = new FavouritesController(new CookiePersitanceService());
var favController = new FavouritesController(new LocalStoragePersitanceService());
