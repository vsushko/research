var foodInGrams = keks.ask('Сколько грамм еды вы сегодня съели, только честно?');
var dayLimit = 80;

if (foodInGrams < dayLimit) {
  console.log('Ещё можно!');
} else {
  console.log('Больше ни кусочка!');
}
