var usersByDay = [4, 2, 1, 3];
console.log(usersByDay);

var currentIndex = 0;
var minValue = usersByDay[currentIndex];

for (var j = currentIndex + 1; j <= usersByDay.length - 1; j++) {
  if (usersByDay[j] < minValue) {
    minValue = usersByDay[j];    
    console.log('Новый минимальный элемент: ' + minValue);
  }
}

console.log('Минимальный элемент: ' + minValue);