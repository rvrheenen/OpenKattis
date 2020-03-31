const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.on('line', (line) => {
    solve(parseInt(line.split()[0]))
});

function solve(x) {
  while(true) {
    let sumDigits = x.toString().split("").reduce((a,b) => parseInt(a) + parseInt(b), 0)
    if (x % sumDigits == 0) return console.log(x)
    x++
  }
}
