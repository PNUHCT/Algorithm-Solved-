# 절사평균을 이용한 난이도 구하기
# 30%의 절사평균을 통해 난이도를 구해야 한다. (즉, 위에서 15%, 아래에서 15%를 제외한 평균을 구한다)

# Input1 : 첫 번째 줄은 난이도 의견의 개수(반복 수) N이 주어진다.
# Input2 : N개의 줄로 각 난이도 평가가 주어진다.

# import math

# N = int(input())
# list = list()

# for i in range(0, N) :
#     list.insert(i, int(input()))

# list.sort()

# min = round(N * 0.15)
# max = round(N * 0.75)
# sum = 0
# if N==0 :
#     print(0)
# elif N==1 :
#     print(list[0])
# else :
#     for i in range(min, max) :
#         sum += list[i]
#     sub = N-(min*2)
#     print(round(sum/sub))

import sys
input = sys.stdin.readline
 
def round2(num):
    return int(num) + (1 if num - int(num) >= 0.5 else 0)
 
n = int(input())
if not n:
    print(0)
else:
    score = [int(input()) for _ in range(n)]
    trunc = round2(n * 0.15)
    apply_trunc = sorted(score)[trunc: n - trunc]
    average = round2(sum(apply_trunc) / len(apply_trunc))
    print(average)