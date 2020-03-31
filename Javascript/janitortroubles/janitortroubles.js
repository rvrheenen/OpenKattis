const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.on('line', (line) => {
    solve( line.split(" ").map(n=>parseInt(n)) )
});

function solve(nums) {
  let sp = nums.reduce((a,b) => a + b, 0) / 2

  let ans = Math.sqrt( nums.reduce((a, b) => a * (sp - b), 1) )

  console.log(ans)

}
