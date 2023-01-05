import sys
sys.stdin = open("input.txt", "rt")

N = int(input())
num = [list(map(int, input().split())) for _ in range(N)]

M = int(input())

for _ in range(M):
  l, d, c = map(int, input().split())
  for _ in range(c):
    if d == 0: #left
      num[l-1].append(num[l-1].pop(0))
    else: #right
      num[l-1].insert(0, num[l-1].pop())

s = 0
e = N
sum =0
for i in range(N):
  for j in range(s, e):
    sum +=num[i][j]
  if i <N//2:
    s+=1
    e-=1
  else:
    s-=1
    e+=1


print(sum)
