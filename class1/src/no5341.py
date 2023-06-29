# 반복문을 사용한 합산
while 1 :
    N = int(input())
    if N == 0 : 
        break
    Result = 0
    for i in range(1, N+1):
        Result += i
    print(Result)


#  --------------------------------------- # 


#  N * (N+1) / 2 공식을 이용한 합산
def Pyramid(num):
    return num * (num+1) // 2

# if __name__ == "__main__": 
while 1:
    N = int(input())
    if N == 0 : 
        break

    print(Pyramid(num = N))
