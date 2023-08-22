"""
1. 문제유형
- 이코테(책) p.322 : 문자열 재정렬

2. 알고리즘
- 설명에 따라 메서드를 추가한다.
"""

import sys

input = sys.stdin.readline().strip()
length = len(input)

new = []
value = 0

for i in input:
  if i.isalpha():
    new.append(i)
  else:
    value += int(i)
    
new.sort()
new.append(str(value))

print(''.join(new))
