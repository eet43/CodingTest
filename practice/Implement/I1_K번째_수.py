import sys
sys.stdin = open("input.txt", "rt")
T = int(input())

for i in range(0,T):
  n, s, e, k = map(int, input().split())
  a = list(map(int, input().split()))
  value = a[s-1:e]
  value.sort()

  result = '#{0} {1}'
  print(result.format(i+1, value[k-1]))
