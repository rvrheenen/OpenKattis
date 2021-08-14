use std::io::{self, BufRead};

fn process_case(case:u32, days:u32) -> () {
    
    let night_candles = days * (days + 1) / 2;
    let total_candles = night_candles + days;

    println!("{} {}", case, total_candles );
}


fn main() {
    let stdin = io::stdin();
    for line in stdin.lock().lines().map(|l| l.unwrap()) {
        let nums: Vec<u32> = line.split_whitespace()
            .map(|num| num.parse().unwrap())
            .collect();

        if nums.len() < 2 {
            continue
        }
        
        let case = nums[0];
        let days = nums[1];
        
        process_case(case, days)
    }
}