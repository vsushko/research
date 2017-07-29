class Person {
    public name: string;
    public surname: string;
    constructor(name: string, surname: string) {
        this.name = name;
        this.surname = surname;
    }
    public greet(city: string, country: string) {
        // we use the this operator to access name and surname
        var msg = `Hi, my name is ${this.name} ${this.surname}. `;
        msg += `I'm from ${city} (${country}).`;
        console.log(msg);
    }
}


class SuperHero extends Person {
    public superpower: string;

    constructor(name: string, surname: string, superpower: string) {
        super(name, surname);
        this.superpower = superpower;
    }

    userSuperPower() {
        return `I'm using my ${this.superpower}`;
    }
}

var superHero = new SuperHero("name", "surname", "superpower");

