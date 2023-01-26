import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String cmd = st.nextToken();
              cmd = (cmd.equals("all") || cmd.equals("empty")) ? allOrEmpty(cmd) : calculate(cmd, st.nextToken(), bw);
        }
        bw.close();
    }

    private static String calculate(String cmd, String x, BufferedWriter bw) throws IOException {
        if (cmd.equals("add")) {
            if (!set.contains(x)) set.add(x);
        } else if (cmd.equals("remove")) {
            if (set.contains(x)) set.remove(x);
        } else if (cmd.equals("check")) {
            if (set.contains(x)) bw.append("1\n");
            else bw.append("0\n");
        } else if (cmd.equals("toggle")) {
            if (set.contains(x)) set.remove(x);
            else set.add(x);
        }
        return null;
    }

    private static String allOrEmpty(String cmd) throws IOException {
        if (cmd.equals("all")) {
            Set<String> newSet = new HashSet<>();
            for (int i = 1; i <= 20; i++) newSet.add(String.valueOf(i));
            set = newSet;
        } else if (cmd.equals("empty")) {
            set.clear();
        }
        return null;
    }
}

