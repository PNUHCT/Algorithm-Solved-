# 1. 입력이 I n일경우, n을 add
# 2. 입력이 D 1일경우, 최대값 삭제
# 3. 입력이 D -1일경우, 최소값 삭제
# 4. 만약 Q가 비어있는 경우, D 연산은 무시
# 5. 모든 연산이 끝나고, 만약 Q가 비어있으면 Empty출력
# 6. 숫자가 남아있으면 최대값과 최소값을 출력

from collections import deque  

T = int(input())

for i in range(0, T) :
    N = int(input())
    Q = []
    for j in range(0, N) :
        A, B = input().split()
        B = int(B)
        if(A=="I"):
            Q.append(B)
        elif (B == 1) :
            if (Q) :
                Q.sort()
                Q.reverse()
                Q.pop(0)
        else :
            if (Q) :
                Q.sort()
                Q.pop(0)
    if(Q) :
        Q.sort()
        Q.reverse()
        result1= Q.pop(0)
        Q.sort()
        print (str(result1) + " " + str(Q.pop(0)))
    else :
        print("Empty")