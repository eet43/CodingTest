import sys
sys.stdin = open("input.txt", "r")

def DFS(L, sum):
  global cnt
  if sum > T:
    return
    
  if L==k:
    if sum == T:
      cnt += 1
      return
  else:
    for i in range(cn[L]+1):
      DFS(L+1, sum+cv[L]*i)
      
T = int(input())
k = int(input())
cv=[]
cn=[]
for i in range(k):
  a, b = map(int, input().split())
  cv.append(a)
  cn.append(b)
cnt =0
DFS(0,0)
print(cnt)
