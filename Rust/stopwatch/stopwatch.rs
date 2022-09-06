use std::io::{self, BufRead};

fn main() {
    let mut prev_press = 0;
    let mut stopwatch_is_on = false;
    let mut total_time = 0;
    
    for line in io::stdin().lock().lines().skip(1).map(|l| l.unwrap()) {
        let press = line.parse::<u32>().unwrap();
        if stopwatch_is_on {
            total_time += press - prev_press;
        }
        stopwatch_is_on = !stopwatch_is_on;
        prev_press = press;
    }
    
    if stopwatch_is_on{
        println!("still running");
    } else {
        println!("{}", total_time );
    }
}