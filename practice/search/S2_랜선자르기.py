import sys
sys.stdin = open("input.txt", "rt")
K, N = map(int, input().split())
line = []

max = -99999
for i in range(K):
  a = int(input())
  line.append(a)
  if a > max:
    max = a

lt = 1
rt = max
result = 0

while lt<=rt:
  count = 0
  i = (lt+rt)//2
  for j in line:
    count += (j//i)
  if count < N:
    rt = i-1
  elif count > N:
    lt = i+1
  else:
    result = i
    lt = i+1
print(result)
