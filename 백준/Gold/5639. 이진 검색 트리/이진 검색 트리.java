import java.io.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int T;

    public static void main(String[] args) throws IOException {
        Node root = new Node(Integer.parseInt(br.readLine()));

        String input; // 메모리 아끼기 위해 변수는 반복문 밖에 선언
        while (true) {
            input = br.readLine(); // 새로들어오는 값 할당

            if(input == null || input.equals("")) break; // 더이상 입력이 없으면 무한반복 종료

            root.insert(Integer.parseInt(input)); // root를 대상으로 이중 트리 생성 시작.
            /*
                root를 대상으로 탐색하지만,
                루트에 대해 자식노드가 가득 차 있으면 그 다음 레벨들의 노드에 대해 insert가 실행되는 방식이다.
             */
        }

        // 후위순회 시작 -> 후위 순회하면서 맨 아래 왼쪽부터 시계반대 방향으로 차곡차곡 출력해줌
        postOrder(root);
    }

    private static class Node {
        private int Num; // 현재 노드의 값
        private Node Lt, Rt; // 자식 노드들 (없으면 null)

        private Node(int num) { this.Num = num; } // 빈 노드 생성용
        /* 어차피 Lt, Rt값은 insert메소드의 탐색을 통해 넣어질 것이다. */

        // 재귀 메소드
        public void insert (int n) {
            if(n<this.Num) { // 주어진 숫자가 현재노드보다 작은 수 일때,
                if(this.Lt == null) this.Lt = new Node(n); // 왼쪽 자식 노드(작은 수)가 없으면, 거기 넣어줌
                else this.Lt.insert(n);  // 이미 왼쪽 자식이 있다면, 해당 자식노드에 대해 다시 탐색해서 넣어줌
            }
            else { // 주어진 숫자가 현재노드보다 크거나 같은 수 일 때,
                if(this.Rt==null) this.Rt = new Node(n); // 오른쪽 자식 노드(큰 수)가 없으면, 거기 넣어줌
                else this.Rt.insert(n); // 이미 오른쪽 자식이 있다면, 해당 자식노드에 대해 다시 탐색해서 넣어줌
            }
        }
    }
    private static void postOrder (Node node) {
        if(node == null) return; // 더이상 탐색할 노드가 없으면 이전 뎁스로

        postOrder(node.Lt); // 가장 왼쪽부터 System.out.println(node.Num);
        postOrder(node.Rt); // 그다음 오른쪽부터 아래부터 System.out.println(node.Num);
        System.out.println(node.Num); // 최종적으로 루트가 가장 왼쪽부터 System.out.println(node.Num);
    }
}