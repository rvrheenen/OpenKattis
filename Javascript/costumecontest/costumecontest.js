const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

var lines = []
rl.on('line', (line) => {
  lines.push(line)
});

rl.on("close", () => {

  // get costume counts
  costumes = {}
  lines.slice(1).forEach(costume => {
    if (costume in costumes) costumes[costume]++
    else costumes[costume] = 1
  })

  // get lowest count
  lowest = Object.keys(lines).length
  Object.values(costumes).forEach(occurance => {
      if (occurance < lowest) lowest = occurance
  })

  // get lowest costume(s)
  Object.keys(costumes).filter(costume => costumes[costume] == lowest).sort().forEach(costume => console.log(costume))
})
