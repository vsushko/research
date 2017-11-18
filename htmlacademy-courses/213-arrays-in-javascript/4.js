var expectedUsers = 1000;

var firstDayUsers = 812;
var secondDayUsers = 1360;
var thirdDayUsers = 657;
var fourthDayUsers = 1247;

// Рисуем график посещаемости
keks.plot(firstDayUsers, secondDayUsers, thirdDayUsers, fourthDayUsers, expectedUsers);

// Рассчитываем среднее значение посещаемости
var averageUsers = (firstDayUsers + secondDayUsers + thirdDayUsers + fourthDayUsers) / 4;
console.log('Средняя посещаемость: ' + averageUsers);

if (averageUsers > expectedUsers) {
  console.log('Посещаемость великолепна. Продолжай в том же духе!');
} else {
  console.log('Посещаемость так себе. Нужно поднапрячься.');
}
