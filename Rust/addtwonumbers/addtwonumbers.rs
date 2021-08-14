use std::io::{self, BufRead};

fn main() {
    for line in io::stdin().lock().lines().map(|l| l.unwrap()) {
        let nums: Vec<i64> = line.split_whitespace()
            .map(|num| num.parse().unwrap())
            .collect();
            
        let n1 = nums[0];
        let n2 = nums[1];
        
        println!("{}", n1 + n2)
    }
}