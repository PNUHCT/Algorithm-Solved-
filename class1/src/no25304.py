import sys

total = int(sys.stdin.readline())
t = int(sys.stdin.readline())
real = 0

for i in range(0, t) :
    cost, N = sys.stdin.readline().split()
    cost = int(cost)
    N = int(N)
    real += (cost*N)

if total==real : print("Yes")
else : print("No")