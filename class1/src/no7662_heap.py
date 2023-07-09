import sys
import heapq

for T in range (int (sys.stdin.readline())) : # 테스트 케이스만큼 반복할 것
    k = int(sys.stdin.readline())   # 각 테스트 케이스마다 k줄만큼 입력이 있을 것
    visited = [False] * k  # 각 입력 수만큼 방문체크하기위한 리스트(배열) 생성
    maxHeap, minHeap = [], []

    for i in range(k) :
        operation, n = sys.stdin.readline().split()  # 입력된 명령어(I/D)와 숫자n을 " "을 기준으로 분리해 저장
        n = int(n)

        if operation == 'I' :
            heapq.heappush(minHeap, (n, i))  # 최소힙을 만들어줄 리스트에, 인덱스에 맞춰 순차적으로 n값을 넣어줌
            heapq.heappush(maxHeap, (-n, i))  # 최대힙을 만들어줄 리스트에, 인덱스에 맞춰 순차적으로 n값을 반전시켜 넣어줌
            visited[i] = True

        elif n == 1 :  # I가 아닌경우는 무조건 1 또는 -1의 경부밖에 없기 때문
            while maxHeap and not visited[maxHeap[0][1]]:
                heapq.heappop(maxHeap)
            if maxHeap :  # maxHeap이 비어있지 않을 때
                visited[maxHeap[0][1]] = False
                heapq.heappop(maxHeap)

        else :  # D이고 -1일 때
            while minHeap and not visited[minHeap[0][1]]:
                heapq.heappop(minHeap)
            if minHeap:
                visited[minHeap[0][1]] = False
                heapq.heappop(minHeap)

    while minHeap and not visited[minHeap[0][1]]:
        heapq.heappop(minHeap)
    while maxHeap and not visited[maxHeap[0][1]]:
        heapq.heappop(maxHeap)

    # 최대힙은 값을 반전시킨 최소힙으로 되어있으므로, 출력 전에 -를 곱해서 반전 시켜준 뒤 출력
    if maxHeap and minHeap:
        print(-maxHeap[0][0], minHeap[0][0]) 
    else: 
        print("EMPTY")