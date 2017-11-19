var usersByDay = [4, 2, 1, 3];
console.log(usersByDay);

var currentIndex = 0;
var minValue = usersByDay[currentIndex];

for (var j = currentIndex + 1; j <= usersByDay.length - 1; j++) {
  if (usersByDay[j] < minValue) {
    minValue = usersByDay[j];
    var swap = usersByDay[currentIndex];
    usersByDay[currentIndex] = minValue;
    usersByDay[j] = swap;
    console.log('Меняю местами ' + swap + ' и ' + minValue);
    console.log('Массив сейчас: ' + usersByDay);
  }
}

console.log('На позиции ' + currentIndex + ' находится минимальный элемент ' + minValue);


console.log(usersByDay);
currentIndex = 1;
minValue = usersByDay[currentIndex];

for (var j = currentIndex + 1; j <= usersByDay.length - 1; j++) {
  if (usersByDay[j] < minValue) {
    minValue = usersByDay[j];
    var swap = usersByDay[currentIndex];
    usersByDay[currentIndex] = minValue;
    usersByDay[j] = swap;
    console.log('Меняю местами ' + swap + ' и ' + minValue);
    console.log('Массив сейчас: ' + usersByDay);
  }
}

console.log('На позиции ' + currentIndex + ' находится минимальный элемент ' + minValue);


console.log(usersByDay);
currentIndex = 2;
minValue = usersByDay[currentIndex];

for (var j = currentIndex + 1; j <= usersByDay.length - 1; j++) {
  if (usersByDay[j] < minValue) {
    minValue = usersByDay[j];
    var swap = usersByDay[currentIndex];
    usersByDay[currentIndex] = minValue;
    usersByDay[j] = swap;
    console.log('Меняю местами ' + swap + ' и ' + minValue);
    console.log('Массив сейчас: ' + usersByDay);
  }
}

console.log('На позиции ' + currentIndex + ' находится минимальный элемент ' + minValue);
