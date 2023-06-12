import java.util.*;
import java.io.*;

public class no4299 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int Sum, Diff, A, B;
       public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Sum = Integer.parseInt(st.nextToken());
        Diff = Integer.parseInt(st.nextToken());

        /*
        1. 만약 합(Sum)과 차(Diff)의 합이 홀수일 경우, 해당하는 경우가 없으므로 -1 출력 
        2. 그 외에는 아래의 연립방적식을 이용

        A + B = Sum
        A - B = Diff

        A = Sum - B
        Diff = Sum - B - B = Sum - 2B

        따라서, 
        B = (Sum - Diff)/2
        A = Sum - (Sum - Diff)/2 = (Sum + Diff)/2 
        */
        if((Sum + Diff)%2 == 1) System.out.println(-1);       
        else {
            A = (Sum + Diff)/2;
            B = (Sum - Diff)/2;
            
            StringBuilder sb = new StringBuilder();
            sb.append(Math.max(A,B)).append(" ").append(Math.min(A,B));

            System.out.println(sb.toString());
        }
    }
}