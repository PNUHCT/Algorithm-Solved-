import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");
        List<String> list = Arrays.stream(arr).filter(a->a.length()>0).collect(Collectors.toList());
        System.out.println(list.size());
    }
}