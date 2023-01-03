import sys
sys.stdin = open("input.txt", "rt")

N = int(input())
a = list(map(int, input().split()))

def digit_sum(x):
  sum = 0
  for i in str(x):
    sum += int(i)
  return sum

max = -2400000
for i in a:
  value = digit_sum(i)
  if(max < value):
    max = value
    result = i

print(result)
    
