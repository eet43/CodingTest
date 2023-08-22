"""
1. 문제유형
- 이코테(책) p.321 : 럭키스트레이트

2. 알고리즘
- 설명에 따라 메서드를 추가한다.
"""

import sys

input = sys.stdin.readline().strip()
length = len(input)

value = 0
for i in range(length//2):
  value += int(input[i])

for i in range(length//2, length):
  value -= int(input[i])

if value == 0:
  print("LUCKY")
else:
  print("READY")
