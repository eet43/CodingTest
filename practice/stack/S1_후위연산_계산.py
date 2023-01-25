
import sys
sys.stdin = open("input.txt", "rt")

line = input()
stack = []

for x in line:
  if x.isdecimal():
    stack.append(int(x))
  else:
    if x == '+':
      num1 = stack.pop()
      num2 = stack.pop()
      stack.append(num1+num2)
    elif x == '-':
      num1 = stack.pop()
      num2 = stack.pop()
      stack.append(num2-num1)
    elif x == '*':
      num1 = stack.pop()
      num2 = stack.pop()
      stack.append(num2*num1)
    else:
      num1 = stack.pop()
      num2 = stack.pop()
      stack.append(num2/num1)
print(stack[0])
