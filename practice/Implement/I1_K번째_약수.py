import sys
n,k = map(int, input().split())

def getValue(n):
  value = []
  for i in range(2, n+1):
    if n%i==0:
      value.append(i)
      
  return value


result = getValue(n)
result.sort()
if(len(result) < k):
  print(-1)
else:
  print(result[k-1])
