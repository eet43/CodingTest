import sys
sys.stdin = open("input.txt", "rt")

N = input()

value = 0
for i in N:
  if i.isdecimal():
    value = value*10 + int(i)

count = 0
for i in range(2, value+1):
  if value%i == 0:
    count= count +1
print(value, end='\n')
print(count)
