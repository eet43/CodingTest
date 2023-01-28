
import sys
sys.stdin = open("input.txt", "rt")

str1 = input()
str2 = input()

dic1 = dict()
dic2 = dict()

for x in str1:
  dic1[x] = dic1.get(x, 0) + 1
  
for x in str2:
  dic2[x] = dic2.get(x, 0) + 1

for x in dic1.keys():
  if x in dic2.keys():
    if dic1[x] != dic2[x]:
      print("NO")
      break
  else:
    print("NO")
    break

else:
  print("YES")
