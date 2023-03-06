import java.io.*;
import java.util.*;

public class no5597 {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<Integer> set = new HashSet<>();
        for(int i=1; i<=30 ; i++) set.add(i);
        while(true) {
            try { set.remove(Integer.parseInt(br.readLine())); }
            catch (Exception e) { break; }
        }

        Iterator iterator = set.iterator();
        while(iterator.hasNext()) System.out.println(iterator.next());
    }
}

