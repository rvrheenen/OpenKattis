const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

var lines = []
rl.on('line', (line) => {
  lines.push(line.split(" ").map(n=>parseInt(n)))
});

rl.on("close", () => solve(lines[1]))

function solve(numbers) {
  console.log( Math.abs(numbers.filter(n => n < 0).reduce((a,b) => a + b, 0)) )
}
