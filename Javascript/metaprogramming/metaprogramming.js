const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

var vars = {}

rl.on('line', (line) => {
    let args = line.split(" ")
    if (args[0] == "define") {
        processDefine(...args.slice(1))
    } else {
        console.log( processEval(...args.slice(1)) )
    }
});


const processDefine = (v, k) => {
    vars[k] = v
}

const processEval = (k1, operator, k2) => {
    if (!vars[k1] || !vars[k2]) return undefined
    if (operator == "=") return vars[k1] == vars[k2];
    return eval(`${vars[k1]}${operator}${vars[k2]}`)
}