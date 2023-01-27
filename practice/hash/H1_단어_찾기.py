import sys
sys.stdin = open("input.txt", "rt")

n = int(input())
answer = dict()

for _ in range(n):
  value = input()
  answer[value] = 1

for _ in range(n-1):
  value = input()
  answer[value] = 0

for key, value in answer.items():
  if value == 1:
    print(key)
