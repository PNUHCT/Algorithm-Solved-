import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int plus;
    static int minus;
    static int zero;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        Integer[][] paper = new Integer[size][size];

        // 종이 초기화
        for(int i=0; i<size ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<size ; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        plus = 0;
        minus = 0;
        zero = 0;

        print(size, paper);

        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }

    private static void print(int size, Integer[][] paper) {
        int check = paper[0][0];
        boolean unmatched = false;
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(!paper[i][j].equals(check)) {
                    unmatched = true;
                    break;
                }
            }
            if(unmatched) break;
        }
        if (!unmatched) {
            if(check==1) plus++;
            else if(check==-1) minus++;
            else zero++;
        } else {
            Integer[][] one = makePaper(paper, new Integer[size/3][size/3], 0, size/3-1, 0, size/3-1);
            Integer[][] two = makePaper(paper, new Integer[size/3][size/3], size/3, size/3*2-1, 0, size/3-1);
            Integer[][] three = makePaper(paper, new Integer[size/3][size/3], size/3*2, size-1, 0, size/3-1);

            Integer[][] four = makePaper(paper, new Integer[size/3][size/3], 0, size/3-1, size/3, size/3*2-1);
            Integer[][] five = makePaper(paper, new Integer[size/3][size/3], size/3, size/3*2-1, size/3, size/3*2-1);
            Integer[][] six = makePaper(paper, new Integer[size/3][size/3], size/3*2, size-1, size/3, size/3*2-1);

            Integer[][] seven = makePaper(paper, new Integer[size/3][size/3], 0, size/3-1, size/3*2, size-1);
            Integer[][] eight = makePaper(paper, new Integer[size/3][size/3], size/3, size/3*2-1, size/3*2, size-1);
            Integer[][] nine = makePaper(paper, new Integer[size/3][size/3], size/3*2, size-1, size/3*2, size-1);


            print(size/3, one);
            print(size/3, two);
            print(size/3, three);

            print(size/3, four);
            print(size/3, five);
            print(size/3, six);

            print(size/3, seven);
            print(size/3, eight);
            print(size/3, nine);
        }
    }


    private static Integer[][] makePaper (Integer[][] paper, Integer[][] mini,
                                          int startW, int endW, int startH, int endH) {
        int miniH = 0;
        for(int i = startH; i <= endH ; i++) {
            int miniW = 0;
            for(int j = startW; j <= endW ; j++) {
                mini[miniH][miniW] = paper[i][j];
                miniW++;
            }
            miniH++;
        }
        return mini;
    }
}