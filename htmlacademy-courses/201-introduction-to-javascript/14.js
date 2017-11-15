/**
 * KeksoFit v0.1
 * Author: @keksobot
 * License: CatoFree, NoDogs
 */

var foodInGrams = 100;
var sleepInHours = 15;

var jumps = foodInGrams / 10 * 3;
var pulls = sleepInHours * 2;

var runs = jumps + pulls * 0.5;

/*

Вес корма храним в переменной foodInGrams, а время сна в переменной sleepInHours.
В обе переменные будем записывать целые числа.

За каждые 10 грамм корма, которые я съел, я получаю 3 прыжка.
Например: за 50 грамм корма я должен сделать 15 прыжков.
Прыжки храним в переменной jumps.

За каждый час сна — 2 подтягивания.
Например: я поспал 5 часов и должен подтянуться 10 раз.
Подтягивания храним в переменной pulls.

Каждый прыжок дополняется одним кругом пробежки, а каждое подтягивание — половиной круга.
Например: 20 кругов по комнате даётся за 15 прыжков и 10 подтягиваний.
Круги храним в переменной runs.

*/
