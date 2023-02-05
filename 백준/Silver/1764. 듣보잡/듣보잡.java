import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int hear = Integer.parseInt(st.nextToken());
        int see = Integer.parseInt(st.nextToken());
        Set<String> notHear = new HashSet<>();
        List<String> notHearAndSee = new ArrayList<>();

        while(hear-->0) notHear.add(br.readLine());
        while(see-->0) {
            String notSee = br.readLine();
            if(notHear.contains(notSee)) notHearAndSee.add(notSee);
        };

        Collections.sort(notHearAndSee);

        bw.write(""+notHearAndSee.size()+"\n");
        for(String person : notHearAndSee) bw.write(person+"\n");

        bw.close();
    }
}

