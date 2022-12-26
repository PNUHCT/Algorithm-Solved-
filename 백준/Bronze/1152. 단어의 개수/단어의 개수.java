import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");
        int count = 0;
        for(int i = 0; i < arr.length ; i++) {
            if(!arr[i].equals("")) count++;  
        }
        System.out.println(count);
    }
}