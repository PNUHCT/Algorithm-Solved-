import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String[] strArr = str.split("");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String[] alphaArr = alphabet.split("");
        int[] arr = new int[26];
        Arrays.fill(arr,-1);
        for (int i=0 ; i<strArr.length; i++) {
            for(int j=0 ; j<alphabet.length() ; j++) {
                if(strArr[i].equals(alphaArr[j]) && arr[j]==-1) arr[j] = i;
            }
        }

        String result = "";
        for(int i=0 ; i<arr.length; i++) {
            result += arr[i] + " ";
        }
        System.out.println(result);
    }
}
