var usersByDay = [4, 1, 2, 3];
console.log(usersByDay);

var swap = usersByDay[0];

usersByDay[0] = usersByDay[1];
console.log(usersByDay);

usersByDay[1] = swap;
console.log(usersByDay);
