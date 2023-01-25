import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        List<Integer> rand = new ArrayList<>();

        for(int i=0; i<N ; i++) {
            StringTokenizer randSt = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M ; j++) {
                rand.add(Integer.valueOf(randSt.nextToken()));
            }
        }

        int max = rand.stream().mapToInt(a->a).max().getAsInt();
        int time = 128000000;
        max++;
        while(max-->=0) {
            int inventory = B;
            int removedBlock = 0;
            int needs = 0;
            for(int i=0; i<N*M ; i++) {
                int block = rand.get(i);
                if(block>max) {
                    inventory += block - max;
                    removedBlock += block - max;
                }
                else needs += max - block;
            }

            if(inventory<needs) continue;

            int tempTime = (removedBlock * 2) + needs;

            if(time <= tempTime) {
                max++;
                break;
            } else {
                time = tempTime;
            }
        }
        bw.append(""+time+" "+max);

        bw.close();
    }
}