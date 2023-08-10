"""
1. 문제유형
- 백준 1157 : 단어공부
- https://www.acmicpc.net/problem/1157

2. 알고리즘
- 우선 대소문자를 구분하지 않기 때문에 upper, lower 를 통해 통합시킨다.
- 문자열 최다빈도 알파벳을 구하려면 set 자료구조와 count() 메서드가 필요하다.
"""

import sys

str = sys.stdin.readline().strip()
str = str.upper()
alph = list(set(str))

check = []
for a in alph:
  check.append(str.count(a))

if check.count(max(check)) >= 2:
  print('?')
else:
  print(alph[check.index(max(check))])
