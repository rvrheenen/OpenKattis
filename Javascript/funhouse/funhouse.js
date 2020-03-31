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
  house_no = 1
  lines_index = 0

  while(true) {
    if (lines_index > lines.length) break
    if (lines[lines_index] == undefined) break
    let [width, length] = lines[lines_index].split(" ").map(x => parseInt(x))

    if (width == 0 && length == 0) break

    console.log("HOUSE", house_no)
    solve(lines.slice(lines_index+1, lines_index + length+1)).forEach(row => {
      console.log(row)
    })

    lines_index += length + 1
    house_no++
  }
})

function solve(house) {

  const directions = {
    up:  [-1,0],
    right:  [0,1],
    down:  [1,0],
    left:  [0,-1],
  }

  var [row, col] = getStartPosition(house)
  var direction = getStartDirection(directions, row, col, house.length, house[0].length)

  while (true) {
    row += direction[0]
    col += direction[1]

    if (house[row][col] == "x") { // wall found
      house[row] = house[row].substr(0,col) + "&" + house[row].substr(col+1)
      return house
    }

    if (house[row][col] == "/"){
      if (direction == directions.up) direction = directions.right
      else if (direction == directions.right) direction = directions.up
      else if (direction == directions.down) direction = directions.left
      else if (direction == directions.left) direction = directions.down
    } else if (house[row][col] == "\\") {
      if (direction == directions.up) direction = directions.left
      else if (direction == directions.right) direction = directions.down
      else if (direction == directions.down) direction = directions.right
      else if (direction == directions.left) direction = directions.up
    }
  }
}


function getStartPosition(house) {
  for (let r = 0; r < house.length; r++) {
    for (let c = 0; c < house[0].length; c++) {
      if (house[r][c] == "*") return [r,c]
    }
  }
}

function getStartDirection(directions, row, col, width, height) {
  if (row == 0) {
    return directions.down
  } else if (col == 0) {
    return directions.right
  } else if (row == height - 1) {
    return directions.up
  } else if (col == width - 1) {
    return directions.left
  }
}
