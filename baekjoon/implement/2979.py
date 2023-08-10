"""
1. 문제유형
- 백준 2979 : 트럭 주차
- https://www.acmicpc.net/problem/2979

2. 알고리즘
- 튜플로 기준을 잡아 정렬한 후 겹치는 시간을 체크 => 정렬할 필요가 없었다.
"""

import sys

A, B, C = map(int, sys.stdin.readline().split())
time = []
for _ in range (3):
  time.append(list(map(int, sys.stdin.readline().split())))

n = max(time[0][1], time [1][1], time[2][1])

check = [0] * n

for x in time:
  for i in range(x[0], x[1]):
    check[i] += 1

sum = 0
for i in check:
  if i == 3:
    sum += C*3
  elif i ==2:
    sum += B*2
  elif i ==1:
    sum += A

print(sum)
  
