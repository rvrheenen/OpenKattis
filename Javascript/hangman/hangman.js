const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

var lines = []
rl.on('line', (line) => {
  lines.push(line.split(""))
});

rl.on("close", () => solve(lines))

function solve([word, alphabet]) {
  var triesLeft = 10
  var alphaIndex = 0

  while (triesLeft > 0 && alphaIndex < 26 && word.length > 0) {
    let newWord = word.filter(letter => letter != alphabet[alphaIndex])

    if (newWord.length < word.length) {
      word = newWord
    } else {
      triesLeft--
    }

    alphaIndex ++
  }
  console.log(word.length > 0 ? "LOSE" : "WIN")
}
