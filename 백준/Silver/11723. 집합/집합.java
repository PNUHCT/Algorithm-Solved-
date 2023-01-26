import java.io.*;
import java.util.*;

public class Main {

    static List<String> list = new ArrayList<>();

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
            if (!list.contains(x)) list.add(x);
        } else if (cmd.equals("remove")) {
            if (list.contains(x)) list.remove(x);
        } else if (cmd.equals("check")) {
            if (list.contains(x)) bw.append("1\n");
            else bw.append("0\n");
        } else if (cmd.equals("toggle")) {
            if (list.contains(x)) list.remove(x);
            else list.add(x);
        }
        return null;
    }

    private static String allOrEmpty(String cmd) {
        if (cmd.equals("all")) {
            List<String> newList = new ArrayList<>();
            for (int i = 1; i <= 20; i++) newList.add(String.valueOf(i));
            list = newList;
        } else if (cmd.equals("empty")) {
            list.clear();
        }
        return null;
    }
}

