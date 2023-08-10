"""
1. 문제유형
- 백준 11723 : 집합
- https://www.acmicpc.net/problem/11723

2. 알고리즘
- 설명에 따라 메서드를 추가한다.
3. 실패
- 비트연산으로 풀어야한다. 시간초과
"""

import sys

num = int(input())
s = set()
for _ in range(num):
  com = list(input().split())
  if len(com) == 1:
    if com[0] == 'all':
      s = set([i for i in range(1, 21)])
    elif com[0] == 'empty':
      s.clear
  else :
    if com[0] == 'add':
      s.add(int(com[1]))
    elif com[0] == 'remove':
      s.discard(int(com[1]))
    elif com[0] == 'check':
      if int(com[1]) in s:
        print(1)
      else:
        print(0)
    elif com[0] == 'toggle':
      if int(com[1]) in s:
        s.remove(int(com[1]))
      else:
        s.add(int(com[1]))
print(s)
