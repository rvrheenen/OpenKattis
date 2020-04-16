const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.on('line', (line) => {
    let [from, to] = line.split(" ").map(x => parseInt(x))
    
    let options = 0
    for (let i = from; i <= to; i++) {
        if ( isOption(i) ) options++
    }

    console.log(options)
});

const isOption = (num) => {
    let digs = num.toString()
    if (containsDuplicatesOrZeroes(digs)) return false

    for (let dig of digs) {
        if (num % parseInt(dig) != 0) return false;
    }

    return true;
}

const containsDuplicatesOrZeroes = (digs) => {
    let s = new Set(digs)
    return s.has('0') || s.size != digs.length
}