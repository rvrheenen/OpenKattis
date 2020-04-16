const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

var vars = {}

rl.on('line', (line) => {
    let [empties, found, needed] = line.split(" ").map(x => parseInt(x))
    
    let numberOfBottles = empties + found
    let drank = 0
    while (numberOfBottles >= needed) {
        let amountCanBuy = parseInt(numberOfBottles/needed)
        drank += amountCanBuy
        numberOfBottles -= amountCanBuy * needed
        numberOfBottles += amountCanBuy
    }
    console.log(drank)
});