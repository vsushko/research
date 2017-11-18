var score = 0;
var total = 0;
var victoryPoints = 100;
var misses = 0;

while (total < victoryPoints) {
  if (misses >= 3) {
    break;    
  }
  
  score = keks.getScore();

  if (score < 0) {
    console.log('Промах!');
    misses++;
  } else {
    total += score;
    console.log('Результат броска: ' + score);
  }
}

console.log(total);
