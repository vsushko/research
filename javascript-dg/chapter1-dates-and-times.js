var then = new Date(2010, 0, 1);
console.log(then);

var later = new Date(2010, 0, 1,17, 10, 30);
console.log(later);

var now = new Date();
console.log(now);

var elapsed = now - then;
console.log(elapsed);

console.log(later.getFullYear());
console.log(later.getMonth());
console.log(later.getDate());
console.log(later.getDay());
console.log(later.getUTCHours());
console.log(later.toString());
console.log(later.toUTCString());
console.log(later.toLocaleDateString());
console.log(later.toLocaleTimeString());
console.log(later.toISOString());
