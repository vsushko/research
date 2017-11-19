var qualificationDistance = 200;
var attempts = [120, 150, 160, 201, 203, 180, 202];
var qualified = false;
var averageBest = 0;

var minValue;
var swap;
var bestAttemptsCount = 3;
var attemptsCount = attempts.length;

// Сортируем массив попыток по возрастанию,
// чтобы лучшие три попытки были в конце массива:
for (var i = 0; i <= attemptsCount - 2; i++) {
  minValue = attempts[i];

  for (var j = i + 1; j <= attemptsCount - 1; j++) {
    if (attempts[j] < minValue) {
      minValue = attempts[j];
      swap = attempts[i];
      attempts[i] = minValue;
      attempts[j] = swap;
    }
  }
}

// Суммируем три лучшие попытки:
for (var i = attemptsCount - bestAttemptsCount; i < attemptsCount; i++) {
  averageBest += attempts[i];
}

// Считаем среднее значение:
averageBest /= bestAttemptsCount;

if(averageBest > qualificationDistance) {
  qualified = true;
}

/*

Мяу! Я провожу тренировки и хочу понять, пройду ли квалификацию.

В течение тренировки я делаю несколько прыжков, и собираю длины прыжков в массив attempts.

Программа должна выбрать три лучших прыжка, а затем посчитать среднее значение этих трёх прыжков и записать его в переменную averageBest.

Квалификационное значение хранится в переменной qualificationDistance.

Если среднее от лучших трёх прыжков больше квалификационного значения, то я прошёл квалификацию и переменная qualified должна содержать true. Если квалификация не пройдена, то в qualified должно быть false.

*/
