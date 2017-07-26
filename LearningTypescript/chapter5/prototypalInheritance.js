var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var Person = (function () {
    function Person(name, surname) {
        this.name = name;
        this.surname = surname;
    }
    Person.prototype.greet = function (city, country) {
        // we use the this operator to access name and surname
        var msg = "Hi, my name is " + this.name + " " + this.surname + ". ";
        msg += "I'm from " + city + " (" + country + ").";
        console.log(msg);
    };
    return Person;
})();
var SuperHero = (function (_super) {
    __extends(SuperHero, _super);
    function SuperHero(name, surname, superpower) {
        _super.call(this, name, surname);
        this.superpower = superpower;
    }
    SuperHero.prototype.userSuperPower = function () {
        return "I'm using my " + this.superpower;
    };
    return SuperHero;
})(Person);
var superHero = new SuperHero("name", "surname", "superpower");
