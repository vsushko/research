var enoughDevelopers = true;
var techAvailable = true;
var onVacation = true;
var onSickLeave = false;

if (enoughDevelopers && techAvailable && !onVacation && !onSickLeave) {
  console.log('Можно начинать проект');
} else {
  console.log('Нельзя начинать проект');
}
