var expectedUsers = 1000;

var usersByDay = [812, 1360, 657, 1247];

// Рисуем график посещаемости
keks.plot(usersByDay, expectedUsers);

var totalUsers = 0;
for (var i = 0; i <= usersByDay.length - 1; i++) {
  totalUsers += usersByDay[i];
}
console.log(totalUsers);

// Рассчитываем среднее значение посещаемости
var averageUsers = 0;
console.log('Средняя посещаемость: ' + averageUsers);

if (averageUsers > expectedUsers) {
  console.log('Посещаемость великолепна. Продолжай в том же духе!');
} else {
  console.log('Посещаемость так себе. Нужно поднапрячься!');
}
