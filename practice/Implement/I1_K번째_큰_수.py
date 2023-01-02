import sys
sys.stdin = open("input.txt", "rt")
e, K = map(int, input().split())
N = list(map(int, input().split()))

value = set()

for i in range(e):
  for j in range(i+1, e):
    for p in range(j+1, e):
      value.add(N[i]+N[j]+N[p])

result = list(value)
result.sort(reverse=True)
print(result[K-1])
