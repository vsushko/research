var expectedUsers = 1000;

var usersByDay = [817, 581, 1370, 752, 1247, 681, 1120, 915, 875, 1341, 757, 610, 812, 741, 1139, 812, 638, 877, 1242, 1159, 1372, 1170, 845, 1289, 515, 1247, 769, 1261, 2805, 1201];

// Рисуем график посещаемости
keks.plot(usersByDay, expectedUsers);

// Суммируем посещаемость и анализируем провалы
var totalUsers = 0;
var minUsers = expectedUsers - 300;
var badDays = [];

for (var i = 0; i <= usersByDay.length - 1; i++) {
  totalUsers += usersByDay[i];
  if (usersByDay[i] < minUsers) {
    badDays[i] = expectedUsers - usersByDay[i];
  } else {
    badDays[i] = 0;
  }
}

keks.plot(badDays, 300);

// Рассчитываем среднее значение посещаемости
var averageUsers = totalUsers / usersByDay.length;
console.log('Средняя посещаемость: ' + averageUsers);

if (averageUsers > expectedUsers) {
  console.log('Посещаемость великолепна. Продолжай в том же духе!');
} else {
  console.log('Посещаемость так себе. Нужно поднапрячься!');
}
