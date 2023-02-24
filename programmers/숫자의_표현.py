def solution(n):
    answer = 1
    for i in range(1, n//2+1):
        result = 0
        for j in range(i, n):
            result += j
            if result < n:
                continue
            elif result > n:
                break
            else :
                print(j)
                answer += 1
                break
    return answer
