var score = 0;
var total = 0;
var victoryPoints = 100;

while (total < victoryPoints) {
  score = keks.getScore();
  total += score;
  
  console.log(score);
}

console.log(total);
