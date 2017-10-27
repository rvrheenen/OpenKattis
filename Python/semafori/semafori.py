def get_wait_time(time, light):
    point_in_cycle = time % (light[1] + light[2])
    return (0 if point_in_cycle > light[1] else light[1] - point_in_cycle)

def main():
    n_lights, len_road = [int(x) for x in input().split()]
    time = 0
    prev_light = 0
    for i in range(n_lights):
        light = [int(x) for x in input().split()]
        time += light[0] - prev_light
        time += get_wait_time(time, light)
        prev_light = light[0]

    time += len_road - prev_light

    print(time)

if __name__ == '__main__':
    main()
