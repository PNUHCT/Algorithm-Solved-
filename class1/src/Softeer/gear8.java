package Softeer;

import java.io.*;
import java.util.Arrays;

public class gear8 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] T = br.readLine().split(" ");
        int[] gear = Arrays.stream(T).mapToInt(a-> Integer.parseInt(a)).toArray();

        String result;
        if(gear[0]==1) {
            result = "ascending";
            for (int i = 0; i < T.length - 1; i++) {
                if (gear[i] > gear[i + 1]) {
                    result = "mixed";
                    break;
                }
            }
        } else if (gear[0]==8) {
            result = "descending";
            for (int i = 0; i < T.length - 1; i++) {
                if (gear[i] < gear[i + 1]) {
                    result = "mixed";
                    break;
                }
            }
        } else {
            result = "mixed";
        }

        System.out.println(result);
    }
}

