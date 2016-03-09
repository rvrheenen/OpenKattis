import datetime

inp = input()
t1 = datetime.datetime.strptime(inp,'%H %M')
t2 = t1-datetime.timedelta(minutes=45)
print(t2.strftime('%-H %-M'))
