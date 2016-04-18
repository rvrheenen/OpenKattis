import datetime

t1 = datetime.datetime.strptime(input(),'%H:%M:%S')
t2 = datetime.datetime.strptime(input(),'%H:%M:%S')
if t1 == t2:
    print("24:00:00")
else:
    if t1 > t2:
        t2 += datetime.timedelta(days=1)
    t3 = t2 - t1
    print("0" + str(t3) if str(t3)[1] == ":" else str(t3))