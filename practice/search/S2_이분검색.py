import sys
sys.stdin = open("input.txt", "rt")
N, M = map(int, input().split())
num = [list(map(int, input().split())) for _ in range(N)]

num.sort()
i=N//2
for j in range(N//2):
  if num[i] == M:
    print(i)
  elif num[i] > M:
