import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class no1929 {

    // 에라토스테네스의 체 알고리즘 사용
//    public static boolean[] prime;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        int M = Integer.parseInt(st.nextToken());
//        int N = Integer.parseInt(st.nextToken());
//        prime = new boolean[N + 1];
//        get_prime();
//
//        for(int i = M; i <= N; i++) {
//            if(!prime[i]) bw.write(""+i+"\n");
//        }
//        bw.close();
//    }
//
//    public static void get_prime() {
//        prime[0] = prime[1] = true;
//
//        for(int i = 2; i <= Math.sqrt(prime.length); i++) {
//            if(prime[i]) continue;
//            for(int j = i * i; j < prime.length; j += i) {
//                prime[j] = true;
//            }
//        }
//    }

    // 나의 코드
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = M; i <= N; i++) list.add(i);

        if(list.get(0)==2) {
            list.remove(0);
            bw.write("2\n");
        }

        for(int i = 0; i < list.size(); i++) {
            if(list.get(i)%2==0) list.remove(i);
            else if(Math.sqrt(list.get(i))==Math.floor(list.get(i))) list.remove(i);
        }

        for(int i = 0; i < list.size(); i++) {
            int count = list.get(i);
            while(count-->0) {
                if(count%2==0) continue;
                if(count==1) {
                    bw.write(""+list.get(i)+"\n");
                    break;
                }
                if(list.get(i)%count==0) break;
            }
        }
        bw.close();
    }
}

