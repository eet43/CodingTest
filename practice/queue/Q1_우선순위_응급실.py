import sys
from collections import deque 
sys.stdin = open("input.txt", "rt")

n , m = map(int, input().split())
p = deque([(order, value) for order, value in enumerate(list(map(int, input().split())))])

count = 0
while True:
  cur = p.popleft()
  if any(cur[1]<x[1] for x in p):
    p.append(cur)
  else:
    count += 1
    if cur[0] == m:
      print(count)
      break
