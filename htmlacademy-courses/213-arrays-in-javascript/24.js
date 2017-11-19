var usersByDay = [1, 2, 3, 4, 5];
console.log(usersByDay);

if (usersByDay.length % 2 !== 0) {
  var medianIndex = (usersByDay.length - 1) / 2;  
  console.log(medianIndex);
  var median = usersByDay[medianIndex];
  console.log(median);
}
