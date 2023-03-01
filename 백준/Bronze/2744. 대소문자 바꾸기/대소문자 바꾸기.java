import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String T = br.readLine();
        String[] arr = T.split("");
        String result = "";
        for(int i=0; i<arr.length ; i++) {
            String temp = arr[i];
            if(Character.isUpperCase(T.charAt(i))) result += temp.toLowerCase();
            else result += temp.toUpperCase();
        }
        System.out.println(result);
    }
}