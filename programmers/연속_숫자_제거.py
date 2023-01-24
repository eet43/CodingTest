def solution(arr):
    answer = []
    for x in arr:
        if not answer:
            answer.append(x)
        else:
            if answer[-1] != x:
                answer.append(x)
    return answer
