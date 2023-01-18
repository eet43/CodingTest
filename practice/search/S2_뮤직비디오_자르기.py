import sys
sys.stdin = open("input.txt", "rt")
N, M = map(int, input().split())
a = list(map(int, input().split()))

def Count(capacity):
  count = 1
  sum = 0
  for x in a:
    if sum+x > capacity:
      sum = x
      count += 1
    else:
      sum += x

  return count
      

lt = max(a)
rt = sum(a)
result = 0

while lt<=rt:
  i = (lt + rt)//2
  if Count(i) <= M:
    result = i
    rt = i-1
  else:
    lt = i+1
    
print(result)
