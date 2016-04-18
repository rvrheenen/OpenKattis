from random import shuffle

def check(nums, t):
    if nums[0] > nums[1] and nums[1] > nums[2] and sum(nums) == t:
        return True
    return False

inp = [int(x) for x in input().split()]
nums = inp[0:6]
t1 = inp[6]
t2 = inp[7]
while (True):
    shuffle(nums)
    if check(nums[0:3], t1) and check(nums[3:6], t2):
        break
print(" ".join([str(x) for x in nums]))