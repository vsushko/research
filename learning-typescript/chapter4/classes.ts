class Person {
    public name: string;
    public surname: string;
    public email: Email;

    constructor(name: string, surname: string, email: Email) {
        this.email = email;
        this.name = name;
        this.surname = surname;
    }

    greet() {
        console.log("Hi! I'm " + this.name + ". You can reach me at " +
            this.email);
    }
}

class Email {
    private email: string;

    constructor(email: string) {

        if (this.validateEmail(email)) {
            this.email = email;
        } else {
            console.log("Invalid email!");
        }
    }

    private validateEmail(email: string) {
        var re = /\S+@\S+\.\S+/;
        return re.test(this.email);
    }

    get(): string {
        return this.email;
    }
}

var email = new Email("remo.jansen@wolksoftware.com");
var me: Person = new Person("Remo", "Jansen", email);

// in typescript:
// an interface can extend another interface or class
// an interface can define data and behaviors as opposed to only behaviors

class Teacher extends Person {

    public subjects: string[];

    constructor(name: string, surname: string, email: Email, subjects: string[]) {
        super(name, surname, email);
        this.subjects = subjects;
    }

    greet() {
        super.greet();
        console.log("I teach " + this.subjects);
    }

    teach() {
        console.log("Welcome to class!");
    }
}

class SchoolPrincipal extends Teacher {
    manageTeachers() {
        console.log("We need to help students to get better results!");
    }
}

var teacher = new Teacher("remo", "jansen",
    new Email("remo.jansen@wolksoftware.com"), ["math", "physics"]);
me.greet();
teacher.greet();
teacher.teach();

var principal = new SchoolPrincipal("remo", "jansen",
    new Email("remo.jansen@wolksoftware.com"), ["math", "physics"]);
principal.greet();
principal.teach();
principal.manageTeachers();

// Mixins
// mixins are alternatives to multiple inheritance
// typescript doesn't support multiple inheritance
class Animal {
    eat(): string {
        return "Delicious!";
    }
}

class Mammal extends Animal {
    breathe(): string {
        return "I'm alive!";
    }
    move(): string {
        return "I can move like a mammal!";
    }
}

class WingedAnimal extends Animal {
    fly(): string {
        return "I can fly!";
    }
    move(): string {
        return "I can move like a bird!";
    }
}

class Bat implements Mammal, WingedAnimal {
    eat: () => string;
    breathe: () => string;
    fly: () => string;
    move: () => string;
}

class Bat2 implements WingedAnimal, Mammal {
    eat: () => string;
    breathe: () => string;
    fly: () => string;
    move: () => string;
}

/**
 * Iterate each property of the parent classes (contained in an array
 * name baseCtors) and copy the implementation to a child class(derivedCtor)
 */
function applyMixins(derivedCtor: any, baseCtors: any[]) {
    baseCtors.forEach(baseCtor => {
        Object.getOwnPropertyNames(baseCtor.prototype).forEach(name => {
            if (name !== 'constructor') {
                derivedCtor.prototype[name] = baseCtor.prototype[name];
            }
        });
    });
}

applyMixins(Bat, [Mammal, WingedAnimal]);

var bat = new Bat();
console.log(bat.breathe());  // I'm alive!
console.log(bat.fly());      // I can fly!
console.log(bat.move());

applyMixins(Bat2, [WingedAnimal, Mammal]);
var bat2 = new Bat2();
// console.log(bat2.eat()); // Error: not a function
console.log(bat2.breathe()); // I'm alive!
console.log(bat2.fly()); // I can fly!
console.log(bat2.move()); // I can move like a mammal

// Generic constraints
interface ValidatableInterface {
    isValid(): boolean;
}

// Generic classes
class User implements ValidatableInterface {
    public name: string;
    public password: string;
    public isValid(): boolean {
        // user validation
        return true;
    }
}

class Talk implements ValidatableInterface {
    public title: string;
    public description: string;
    public language: string;
    public url: string;
    public year: string;

    public isValid(): boolean {
        // talk validation
        return true;
    }
}

// create a Generic repository
class GenericRepository<T extends ValidatableInterface> {
    private _url: string;

    constructor(url: string) {
        this._url = url;
    }

    public getAsync() {
        return Q.Promise((resolve: (entities: T[]) => void, reject) => {
            $.ajax({
                url: this._url,
                type: "GET",
                dataType: "json",
                success: (data) => {
                    var items = <T[]>data.items;
                    for (var i = 0; i < items.length; i++) {
                        if (items[i].isValid()) {
                            list.push(items[i]);
                        }
                    }
                    resolve(list);
                },
                error: (e) => {
                    reject(e);
                }
            });
        });
    }
}

var userRepository = new GenericRepository<User>("./users.json");
userRepository.getAsync().then(function (users: User[]) {
    console.log(users);
});
var talkRepository = new GenericRepository<Talk>("./talks.json");
talkRepository.getAsync().then(function (talks: Talk[]) {
    console.log(talks);
});

// Multiple types in generic type constraints

interface IMyInterface {
    doSomething();
};
interface IMySecondinterface {
    doSomethingElse();
}
interface IChildInterface extends IMyInterface, IMySecondinterface {
}

class Example<T extends IChildInterface> {
    private genericProperty: T;

    useT() {
        this.genericProperty.doSomething();
        this.genericProperty.doSomethingElse(); // there no error anymore
    }
}

// the new operator in generic types
// to create a new object within generic code, we need to indicate 
// that the generic type T has a constructor function { new(): T;}
function factory<T>(): T {
    var type: { new(): T; };
    return new type();
}
class MyClass { }
var myClass: MyClass = factory<MyClass>();

// Liskov substitution principle
interface PersistanceServiceInterface {
    save(entity: any): number;
}
// use cookies as the storage for the application's data
class CookiePersitanceService implements PersistanceServiceInterface {
    save(entity: any): number {
        var id = Math.floor((Math.random() * 100) + 1);
        // Cookie persistance logic...
        return id;
    }
}

class LocalStoragePersitanceService implements
    PersistanceServiceInterface {
    save(entity: any): number {
        var id = Math.floor((Math.random() * 100) + 1);
        // Local storage persistance logic...
        return id;
    }
}

class FavouritesController {
    private _persistanceService: PersistanceServiceInterface;
    constructor(persistanceService: PersistanceServiceInterface) {
        this._persistanceService = persistanceService;
    }
    public saveAsFavourite(articleId: number) {
        return this._persistanceService.save(articleId);
    }
}
var favController = new FavouritesController(new CookiePersitanceService());
var favController = new FavouritesController(new LocalStoragePersitanceService());

// the interface segregation principle states that no client should be foreced
// to depend on methods it does not use
/*interface VehicleInterface {
    getSpeed(): number;
    getVehicleType: string;
    isTaxPayed(): boolean;
    isLightsOn(): boolean;
    isLightsOff(): boolean;
    startEngine(): void;
    acelerate(): number;
    stopEngine(): void;
    startRadio(): void;
    playCd: void;
    stopRadio(): void;
}*/
// ->
interface VehicleInterface {
    getSpeed(): number;
    getVehicleType: string;
    isTaxPayed(): boolean;
    isLightsOn(): boolean;
}
interface LightsInterface {
    isLightsOn(): boolean;
    isLightsOff(): boolean;
}
interface RadioInterface {
    startRadio(): void;
    playCd: void;
    stopRadio(): void;
}
interface EngineInterface {
    startEngine(): void;
    acelerate(): number;
    stopEngine(): void;
}

// the dependency inversion principle states, Depend upon abstractions.
// Do not depend upon concretions
// typescript's runtime doesn't support reflection or interfaces they can 
// arguably be considered pseudo IoC containers rather than real IoC containers

// namespaces
var user = new app.models.UserModel();
var user = new app.models.TalkModel();

/*namespace app.validation {
    // ...
}
namespace app.models {
    // ...
}*/

// import keyword can be used within an internal module to provide 
// an alias for another module
/*import TalkValidatorAlias = app.validation.TalkValidator;
var talkValidator = new TalkValidatorAlias();*/

// we can use the --out flag to compile all the input files into 
// a single JavaScript output file
// tsc --out output.js input.ts

// modules
// the difference between using modules (instead of namespaces) is that
// after declaring all our modules, we will not import them using an 
// HTML <script> tag and we will be able to use a module loader instead

// a module loader is a tool that allows us to have better control over 
// the module loading process.

// module loaders;
// RequireJS: RequireJS uses a syntax known as asynchronous module 
// definition (AMD)
// Browserify: Browserify uses a syntax known as CommonJS.
// SystemJS: SystemJS is a universal module loader, which means that it 
// supports all the available module syntaxes (ES6, CommonJS, AMD, and UMD).

// TypeScript allows us to choose which kind of module definition syntax
// we want to use at runtime:
// tsc --module commonjs main.ts // use CommonJS
// tsc --module amd main.ts // use AMD
// tsc --module umd main.ts // use UMD
// tsc --module system main.ts // use SytemJS

// es6 modules
class UserModel {
    // ...
}
export { UserModel };

// to import a module, we must use the import keyword
// import keyword creates a variable for each imported component
import { UserModel } from "./models";


// external modules
// declare a variable which takes the exported content of the 
// user_class module as its value
import User = require("./user_class");
