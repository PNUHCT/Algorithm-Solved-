import java.io.*;

public class Main {

public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 기준이 될 문자열에 포함된 O의 개수 (즉, 기준 문자열의 길이는 2N+1 이 된다.)
        int S = Integer.parseInt(br.readLine()); // 비교할 문자열 M의 길이
        String M = br.readLine();  // 비교할 문자열

        int count = 0; // "OI"의 개수를 count할 임시 변수
        int answer = 0;  // 결과값을 담을 변수
        int num = 1;  // 반복 조건용 변수. IOI중 OI만 셀 것이므로, I를 제외하기위해 1부터 시작
    
        // 2개씩 셀 것이므로, 0부터 S-2번 인덱스 까지 세기 위함 
        while(num<S-1) {
            // 만약 OI가 나오면,
            if(M.charAt(num) == 'O' && M.charAt(num+1) == 'I') {
                // 일단 하나 세고,
                count++;
                // 비교해야할 단위랑 일치하면, 
                if(count==N) {
                    // 맨 앞이 I인지 확인해서, I면 IOI...OI이므로 answer++
                    if(M.charAt(num-(count*2-1))=='I') answer++;
                    // 처음 세아린 만큼 -1 해줌 (즉, OIOI...OI의 맨 앞 OI만큼 센 거 빼줌)
                    count--;
                }
                // OI가 세트니까 2칸씩 움직어야하므로 +2
                num += 2;
            }
            else {
                // OI가 안나오면 그 부분 반복은 count초기화하고 시마이. 다음 칸으로 넘어감(이때는 OI가 아니므로 한칸만 이동)
                count = 0;
                num++;
            }
        }
        System.out.println(answer);
    }
}