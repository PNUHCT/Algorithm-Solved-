import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class no1991 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N;
    private static Node root = new Node('A', null, null); // 최초의 root Node는 A 고정이다.
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 0 ; i<N ; i++) {
            String[] line = br.readLine().split(" ");
            char head = line[0].charAt(0);
            char left = line[1].charAt(0);
            char right = line[2].charAt(0);
            /* insert 메소드는 조건에 따라 다르게 적용된다.
                1. 만약 입력된 head가 root 노드인 A이면 A에 자식노드 만들어줌
                2. 만약 root가 아니면, 재귀를 통해 다른 자식을 탐색 및 일치하면 자식노드를 넣어줌
                3.
             */
            insert(root, head, left, right);
        }
        preOrder(root);
        bw.write("\n");
        inOrder(root);
        bw.write("\n");
        postOrder(root);

        bw.close();
    }

    private static class Node {
        private char Val; // 현재 노드의 이름
        private Node Lt, Rt; // 좌/우 자식 노드
        public Node(char val,Node lt, Node rt) {
            this.Val = val;
            this.Lt = lt;
            this.Rt = rt;
        }
    }

    /**
     * 이진트리에 한해서 적용되는 트리 생성 메소드
     * @param temp : 현재 들어온 노드로서, 루트인 A부터 시작하여 재귀가 진행된다.
     * @param head : 루트(A)일떄 확인하고, 이후 아닐 때마다 업데이트하면서 재귀
     */
    private static void insert(Node temp, char head, char left, char right) {
        // 1. 현재 부모 노드가 root 노드인지 확인도 하고, head인지 확인도 함
        if(temp.Val == head) {
            // 자식노드가 .이면 없는거고(null), 있으면 만들어 준다.
            temp.Lt = (left == '.' ? null : new Node(left, null, null)); // 좌측 자식 노드 생성
            temp.Rt = (right == '.' ? null : new Node(right, null, null)); // 우측 자식 노드 생성
        }
        // 2. 현재 부모노드가 head가 아닌 경우
        else {
            if(temp.Lt != null) insert(temp.Lt, head, left, right);
            if(temp.Rt != null) insert(temp.Rt, head , left, right);
        }
    }

    // 전위 순회
    private static void preOrder (Node node) throws IOException {
        if(node == null) return; // 재귀 중 더이상 확인할 노드가없으면 정지 ;
        bw.append(node.Val);
        preOrder(node.Lt);
        preOrder(node.Rt);
    }

    // 중위 순회
    private static void inOrder (Node node) throws IOException {
        if(node==null) return;
        inOrder(node.Lt);
        bw.append(node.Val);
        inOrder(node.Rt);
    }

    // 후위 순회
    private static void postOrder(Node node) throws IOException {
        if(node == null) return;
        postOrder(node.Lt);
        postOrder(node.Rt);
        bw.append(node.Val);
    }
}

