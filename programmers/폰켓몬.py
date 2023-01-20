def solution(nums):
    answer =len(nums)//2
    c=len(set(nums))
    if c<answer:
        answer=c
    return answer
