import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no1780 {

    static int plus;
    static int minus;
    static int zero;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        Integer[][] paper = new Integer[size][size];  // 최초의 종이

        // 종이 초기화
        for(int i=0; i<size ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<size ; j++) paper[i][j] = Integer.parseInt(st.nextToken());
        }

        // 카운트 초기화
        plus = 0;
        minus = 0;
        zero = 0;

        // 재귀 시작
        print(size, paper);

        // 결과 출력
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }

    /**
     * 재귀 메서드
     * @param size 현재 검사할 종이의 사이즈
     * @param paper 현재 검사할 종이
     */
    private static void print(int size, Integer[][] paper) {
        int check = paper[0][0];  // 종이의 첫 숫자 (반복을 하며 비교할 기준 숫자)
        boolean unmatched = false;  // 숫자 비교 중 숫자가 다르면 true로 전환

        // 종이를 검사하기 시작
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(!paper[i][j].equals(check)) { // 종이의 숫자가 기준숫자랑 다르면, 맞지않다고 표시하고 반복종료
                    unmatched = true;
                    break;
                }
            }
            if(unmatched) break; // 이중 반복문에서 숫자가 맞지않다고 판명되면, 반복 종료
        }

        // 재귀 할지 말지 정하는 곳
        if (!unmatched) {  // 모든 숫자가 일치하는 종이면, 종이의 숫자에 따라 count 해줌
            if(check==1) plus++;
            else if(check==-1) minus++;
            else zero++;
        } else {  // 종이가 다시 잘라야 하면, 9등분 해서 재귀 돌려줌
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

    // 종이 잘라주는 메소드
    // 자르기 전 종이를 기준으로 9분의 1로 잘라 채워주는 메소드
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

