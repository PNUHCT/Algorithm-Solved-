import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class no1018_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if(N<8 || M<8) {
            bw.write(""+0+"\n");
            bw.close();
        }

        List<String> Atype = new ArrayList<>();
        List<String> Btype = new ArrayList<>();
        for(int i=1; i<=8 ; i++) {
            String BW = "BWBWBWBW";
            String WB = "WBWBWBWB";
            if(i%2==1) {
                Atype.add(BW);
                Btype.add(WB);
            } else if (i%2==0) {
                Atype.add(WB);
                Btype.add(BW);
            }
        }

        String[][] data = new String[N][M];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                data[i][j] = String.valueOf(temp.charAt(j));
            }
        }

        int min = 64;
        for(int i=0; i<=N-8 ; i++) {
            for(int j=0 ; j<=M-8 ; j++) {
                min = compare(Atype, Btype, data, i, j, min);
            }
        }

        bw.write(""+min+"\n");
        bw.close();
    }

    private static int compare (List<String> Atype, List<String> Btype, String[][] data, int low, int col, int min) {
        int countA = 0;
        int countB = 0;
        int result = 0;

        for(int i=low; i<low+8; i++){
            for(int j=col; j<col+8; j++) {
                if(!data[i][j].equals(String.valueOf(Atype.get(i-low).charAt(j-col)))) countA++;
            }
        }

        for(int i=low; i<low+8; i++){
            for(int j=col; j<col+8; j++) {
                if(!data[i][j].equals(String.valueOf(Btype.get(i-low).charAt(j-col)))) countB++;
            }
        }

        if(countA>=min && countB>=min) result = min;
        else if(countA<countB) result = countA;
        else if(countB<=countA) result = countB;

        return result;
    }
}

