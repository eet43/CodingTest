def solution(n):
    print(format(n, 'b').count('1'))
    answer = n
    cnt = format(n, 'b').count('1')
    while True:
        answer += 1
        if format(answer, 'b').count('1') == cnt:
            break
    return answer
