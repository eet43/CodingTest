import sys
sys.stdin = open("input.txt", "rt")

N = int(input())

num = [list(map(int, input().split())) for _ in range(N)]

s = e = N//2
sum = 0

for i in range(N):
  for j in range(s, e+1):
    sum += num[i][j]
  if i < N//2:
    s-=1
    e+=1
  else:
    s+=1
    e-=1

print(sum)
