// https://developer.mozilla.org/ru/docs/Web/JavaScript/Reference/Lexical_grammar#Ключевые_слова

console.log('Завтракомер v0.1 запущен');

var milkInGrams = keks.ask('Босс, сколько грамм молока вы отведали?', '60');
console.log('Завтракомер получил данные о молоке. Выпито ' + milkInGrams + ' грамм.');

var breakfastCalories;
breakfastCalories = milkInGrams * (50 / 100);

console.log('Калорийность завтрака: ' + breakfastCalories + ' калорий, босс!');