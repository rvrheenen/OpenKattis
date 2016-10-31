nTasks, time = [int(x) for x in input().split()]
tasks = [int(x) for x in input().split()]

time_counter = 0
task_counter = 0
for i in range(nTasks):
    time_counter += tasks[i]
    if time_counter <= time:
        task_counter += 1
    if time_counter >= time:
        break
print(task_counter)