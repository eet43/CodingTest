import sys
sys.stdin = open("input.txt", "r")
n, m = map(int, input().split())

count = 0

ball = list(map(int, input().split()))
for i in range(n-1):
  for j in range(i+1,n):
    if ball[i] != ball[j]:
      count += 1

print(count)
