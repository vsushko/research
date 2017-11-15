var foodInGrams = keks.ask('Сколько грамм еды вы сегодня съели, только честно?');
var dayLimit = 80;
var foodToEat;

if (foodInGrams < dayLimit) {
  foodToEat = dayLimit - foodInGrams;
} else {
  console.log('Больше ни кусочка!');
}
