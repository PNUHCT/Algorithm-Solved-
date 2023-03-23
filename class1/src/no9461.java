import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class no9461 {
    private static Long[] arr = new Long[101]; // 최대 N은 100이므로

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        arr[0] = 0L;
        arr[1] = 1L;
        arr[2] = 1L;
        arr[3] = 1L;
        int T = Integer.parseInt(br.readLine());

        while(T-->0) {
            bw.write(""+padovan(Integer.parseInt(br.readLine()))+"\n");
        }
        bw.close();
    }

    private static Long padovan(int N) {
        if(arr[N] == null) arr[N] = padovan(N-2) + padovan(N-3);
        return arr[N];
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        int T = Integer.parseInt(br.readLine());
//        for(int i=0; i<T ; i++) {
//            int N = Integer.parseInt(br.readLine());
//            List<Long> list = new ArrayList<>();
//            list.add(0L);
//            list.add(1L);
//            list.add(1L);
//
//            if(N<3) bw.write(""+list.get(N)+"\n");
//            else {
//                for (int j = 0; j <= N - 3; j++) {
//                    Long next = list.get(j) + list.get(j + 1);
//                    list.add(next);
//                }
//                bw.write(""+list.get(N)+"\n");
//            }
//        }
//        bw.close();
//    }

    /**
     * 방법 1 : 현재 + 4번째 전 = 다음칸
     */
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int T = Integer.parseInt(br.readLine());
//
//        for(int i=0; i<T ; i++) {
//            List<Long> list = new ArrayList<>();
//            list.add(0L);
//            list.add(1L);
//            list.add(1L);
//            list.add(1L);
//            list.add(2L);
//            list.add(2L);
//
//            int N = Integer.parseInt(br.readLine());
//
//            if(N<=5) bw.write(""+list.get(N)+"\n");
//            else {
//                for(int j=5;j<N ; j++ ) list.add(list.get(j) + list.get(j-4));
//                bw.write(""+list.get(N)+"\n");
//            }
//        }
//        bw.close();
//    }
}


