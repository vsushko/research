var enoughDevelopers = true;
var techAvailable = true;

var message = 'Нельзя приступать к проекту';

if (enoughDevelopers) {
  if (techAvailable) {
    message = 'Можно приступать к проекту';
  }
}

console.log(message);
