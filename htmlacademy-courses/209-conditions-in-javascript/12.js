var enoughDevelopers = true;
var techAvailable = false;
var onVacation = false;
var onSickLeave = true;

if (enoughDevelopers && techAvailable) {
  console.log('Можно начинать проект');
}

if (onVacation || onSickLeave) {
  console.log('Лучше подождать');
}
