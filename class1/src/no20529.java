import java.util.*;
import java.io.*;

public class no20529 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N, min; // 각 케이스별 학생의 수
        StringTokenizer st; // 각 케이스별 MBTI들

        int T = Integer.parseInt(br.readLine());    

        // OUTER 문법 : OUTER로 지정한 반복문에 대한 Break, countnue를 호출하면, 그 안의 다른 반복문에 전부 적용됨.(개꿀)
        OUTER : for (int test = 0 ; test<T ; test++ ) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            min = Integer.MAX_VALUE;
            List<Student> list = new ArrayList<>();
            for(int i=0 ; i<N ; i++) list.add(new Student(st.nextToken()));

            /**
             * N명 중 3명을 뽑는 경우의 수이므로, 3중 반복문으로 해결 가능하다.
             * (반복의 횟수가 지정되어 있기에 가능한 방식)
             */
            for ( int first=0 ; first<list.size(); first++ ) {
                for ( int second=first+1 ; second<list.size() ; second++ ) {
                    for( int third = second+1 ; third<list.size() ; third++ ) {
                        // 기존 조합의 최소값과 현재 새로 계산한 조합의 합산 중 더 작은 값을 메모라이즈
                        min = Math.min(min, sumDist(list.get(first),list.get(second),list.get(third)));

                        // 반복 중, 만약에 최소값이 0, 즉 세명의 MBTI가 모두 같은 경우가 발생하면, 나올 수 있는 최솟값이 더이상없으므로,
                        // 현재 반복 종료 후 다음케이스로 이동
                        if (min==0) {
                            bw.write(""+min+"\n");
                            continue OUTER;
                        }
                    }
                }
            }
            bw.write(""+min+"\n"); // 모든 경우의 수를 확인 하고 나온 최솟값을 이번 케이스의 출력에 저장
        }
        bw.close();
    }

    /**
     * 두 학생 사이의 거리계산 메소드를 3번 호출하여, 총 거리를 반환함
     * @param fst = A학생
     * @param snd = B학생
     * @param thd = C학생
     * @return 세 학생끼리의 각각의 거리 합
     */
    private static int sumDist (Student fst, Student snd, Student thd) {
        return (distance(fst, snd) + distance(snd,thd) + distance(fst, thd));
    }

    /**
     * 두 학생 사이의 거리 계산
     */
    private static int distance(Student student1, Student student2) {
        int sum = 0;
        if(student1.M != student2.M) sum++;
        if(student1.B != student2.B) sum++;
        if(student1.T != student2.T) sum++;
        if(student1.I != student2.I) sum++;
        return sum;
    }

    /**
     * 각 학생 객체
     * : 생성 조건을 들어온 MBTI마다 ENFP를 기준으로 T/F
     */
    private static class Student {
        private int M,B,T,I;

        public Student (String mbti) {
            M = mbti.contains("E") ? 0 : 1;
            B = mbti.contains("N") ? 0 : 1;
            T = mbti.contains("F") ? 0 : 1;
            I = mbti.contains("P") ? 0 : 1;
        } 
    }
}
