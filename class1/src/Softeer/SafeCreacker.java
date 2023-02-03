package Softeer;

import java.io.*;
import java.util.*;

public class SafeCreacker {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int bag = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int [] arr = new int [1000000];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0; i<N ; i++) {
            StringTokenizer stN = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(stN.nextToken());
            int P = Integer.parseInt(stN.nextToken());
            arr[P] += M;
            dq.addFirst(P);
        }
        int result = 0;
        while(bag>0) {
            int temp = dq.pollFirst();
            if(bag>arr[temp]) {
                result += (temp*arr[temp]);
                bag-=arr[temp];
            }
            else {
                result += (temp *bag);
                bag = 0;
            }
        }
        System.out.println(result);
    }
}

