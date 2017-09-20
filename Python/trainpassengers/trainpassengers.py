def test_scheme(capacity, num_stations):
    current = 0
    for i in range(num_stations):
        got_off, got_on, left_at_station = [int(x) for x in input().split()]
        
        current -= got_off
        
        if current < 0:
            return False

        current += got_on
        
        if current > capacity or (left_at_station is not 0 and current < capacity):
            return False

    return current == 0

capacity, num_stations = [int(x) for x in input().split()]
print("possible" if test_scheme(capacity, num_stations) else "impossible")