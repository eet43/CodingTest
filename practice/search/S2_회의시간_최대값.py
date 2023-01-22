import sys
sys.stdin = open("input.txt", "rt")

n = int(input())

con = []
for _ in range(n):
  s, e = map(int, input().split())
  con.append((s,e))

con.sort(key = lambda x : (x[1], x[0]))

endTime = 0
count = 0
for s,e in con:
  if s>=endTime:
    endTime = e
    count+=1
print(count)
