import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class no7568 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        /**
         * 하나씩 집어서,
         * 각 배열을 순회
         * 앞의 값과 뒤의 값이 모두 크면 count++;
         * 첫 count = 1;
         * 다 순회하면 bw.write()
         */
        List<Size> list = new ArrayList<>();
        for(int i=0; i<T ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            Size size = new Size(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            list.add(size);
        }
        for(int i=0 ; i<T ; i++) {
            int count = 1;
            Size size1 = list.get(i);
            for(int j=0; j<T ; j++) {
                Size size2 = list.get(j);
                if(size1.getX()<size2.getX() && size1.getY()<size2.getY()) {
                    count++;
                }
            }
            bw.write(""+count+"\n");
        }
        bw.close();
    }

    static class Size {
        private int X;
        private int Y;

        public Size(int X, int Y) {
            this.X = X;
            this.Y = Y;
        }

        public int getX() {
            return X;
        }
        public int getY() {
            return Y;
        }
    }
}

