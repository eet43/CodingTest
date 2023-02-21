from collections import deque

def solution(cards1, cards2, goal):
    answer = ''
    goal = deque(goal)
    cards1 = deque(cards1)
    cards2 = deque(cards2)
    
    while goal:
        word = goal.popleft()
        if cards1:
            if word == cards1[0]:
                cards1.popleft()
                continue
            
        if cards2:
            if word == cards2[0]:
                cards2.popleft()
                continue
        
        answer = "No"
        break
            
    if answer == "":
        answer = "Yes"
    return answer
