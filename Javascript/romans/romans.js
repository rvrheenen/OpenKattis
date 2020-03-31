const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.on('line', (line) => {
    solve(parseFloat(line.split()[0]))
});

function solve(x) {
  console.log(Math.round(x * 1000 * (5280 / 4854)))
}
