def solution(array, commands):
    
    answer = []

    for i in range(len(commands)):
        
        st = commands[i][0]
        end = commands[i][1]
        pick = commands[i][2]
        
        arr = array[st-1:end]
        arr.sort()
        answer.append(arr[pick-1])
    return answer
