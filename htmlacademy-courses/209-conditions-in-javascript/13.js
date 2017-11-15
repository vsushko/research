var enoughDevelopers = true;
var techAvailable = true;
var onVacation = true;
var onSickLeave = false;

if (enoughDevelopers && techAvailable) {
  console.log('Можно начинать проект');
}

if (onVacation || onSickLeave) {
  console.log('Лучше подождать');
}
