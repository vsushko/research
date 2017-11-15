// Сегодня Кекс позавтракал чуть плотнее
var milkInGrams = 60;

var breakfastCalories = milkInGrams * (42 / 100);
console.log('Босс, в завтраке было ' + breakfastCalories + ' калорий.');

var dryFeedInGrams = (500 - breakfastCalories) / 4;
console.log('Вы ещё можете съесть ' + dryFeedInGrams + ' грамм сухого корма.');
