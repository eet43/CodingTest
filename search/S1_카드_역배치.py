# 내가 짠 코드
import sys
sys.stdin = open("input.txt", "rt")

num=list(range(1, 21))

for _ in range(10):
  start, end = map(int, input().split())
  tmp = num[start-1:end]
  tmp.reverse()


  count = 0
  for i in range(start-1, end):
    num[i] = tmp[count]
    count = count + 1

print(num)


# 더 좋은 알고리즘 코드
import sys
sys.stdin = open("input.txt", "rt")

num=list(range(21))

for _ in range(10):
  start, end = map(int, input().split())

  for i in range((end-start+1)//2): //swap밑 탐색에 있어서 굳이 다 돌 필요없다. 이분탐색을 활용하면됨
    num[start+i], num[end-i] = num[end-i], num[start+i]

num.pop(0)
print(num)
