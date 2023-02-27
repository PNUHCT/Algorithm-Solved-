import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String head = br.readLine();
        String tail = br.readLine();

        if(head.contains(tail)) System.out.println("go");
        else System.out.println("no");
    }
}