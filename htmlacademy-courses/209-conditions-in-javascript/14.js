var enoughDevelopers = false;
var techAvailable = false;
var onVacation = true;
var onSickLeave = true;

if (enoughDevelopers && techAvailable) {
  console.log('Можно начинать проект');
}

if (!onVacation) {
  console.log('Никого нет в отпуске');
} else {
  console.log('Кто-то в отпуске');
}

if (!onSickLeave) {
  console.log('Никого нет на больничном');
} else {
  console.log('Кто-то на больничном');
}
