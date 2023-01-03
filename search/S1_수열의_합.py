import sys
sys.stdin = open("input.txt", "rt")

n,m = map(int, input().split())
num = list(map(int, input().split()))
sum = num[0]
count = 0
lt =0
rt =1

while True:
  if sum < m:
    if rt < n:
      sum += num[rt]
      rt += 1
    else:
      break
  elif sum > m:
    if lt < n:
      sum -= num[lt]
      lt +=1
  elif sum == m:
    count +=1
    if lt < n:
      sum -= num[lt]
      lt +=1
print(count)
