import sys
sys.stdin = open("input.txt", "rt")
N, M = map(int, input().split())
num = list(map(int, input().split()))

num.sort()
lt = 0
rt = len(num)-1
for _ in range(N//2):
  i=(lt+rt)//2
  if num[i] == M:
    print(i+1)
    break
  elif num[i] > M:
    rt = i-1
  else:
    lt = i+1
