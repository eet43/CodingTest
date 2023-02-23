def solution(s):
    answer = [0, 0]
    while True:
        if s == '1':
            break
        answer[0] += 1
        
        answer[1] += s.count('0')
        s = len(s.replace('0', ''))
        s = format(s, 'b')
        
    return answer
