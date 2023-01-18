def solution(numbers):
    if max(numbers) == 0:
        return "0"
    numbers = list(map(lambda x:str(x)*3,numbers))
    numbers.sort(reverse=True)

    return ''.join(map(lambda x:x[:len(x)//3],numbers))
