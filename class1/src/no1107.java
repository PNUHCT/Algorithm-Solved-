import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class no1107 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strN = br.readLine(); // 목표 채널의 String 형태. 숫자 비교와 길이를 구하기 위함
        int[] arrN = Arrays.stream(strN.split("")).mapToInt(a-> Integer.parseInt(a)).toArray(); // 채널의 각 숫자를 나눈 숫자형 배열로 변환
        Integer N = Integer.parseInt(strN); // 목표 채널의 숫자형
        int result = 0;

        List<Integer> buttons = new ArrayList<>(12);  // 리모콘 숫자키
        for (int i = 0; i < 12; i++) buttons.add(i, i);
        int T = Integer.parseInt(br.readLine());
        if (T!=0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            brokenButtons(T, st, buttons); // 고장난 버튼을 제외시킴

            Integer candidate = checkHead(buttons, arrN); //앞자리가 10 이나 11일 경우. 아닐경우 0으로 반환

            if (candidate == 0) candidate = mathAbs(buttons, arrN);
            String str = "";
            for (int i = buttons.size() - 3; i >= 0; i--) {
                if (buttons.get(i) != null) {
                    int temp = arrN.length;
                    while (temp-- > 0) str += buttons.get(i);
                    break;
                }
            }
            Integer secondCandidate = Integer.valueOf(str);

            if (Math.abs(secondCandidate - N) > Math.abs(candidate - N)) {
                result = Math.abs(candidate - N) + arrN.length;
            } else {
                result = Math.abs(secondCandidate - N) + arrN.length;
            }
        }

        result = N ==100 ? 0 : result;

        System.out.println(result);
    }

    private static void brokenButtons (int T, StringTokenizer st, List<Integer> buttons) {
        for (int i = 0; i <T ; i++) {
            Integer broken = Integer.parseInt(st.nextToken());
            if (buttons.contains(broken)) {
                if(broken.equals(0)) {
                    buttons.set(0, null); buttons.set(10, null);
                } else if (broken.equals(1)) {
                    buttons.set(1, null); buttons.set(10, null); buttons.set(11, null);
                } else {
                    buttons.set(broken, null);
                }
            }
        }
    }


    /**
     * * 6. 주어진 채널의 맨 앞자리를 배열과 산술하여 절대값이 가장 작은 숫자키가 10이나 11일 경우,
     *     *    10이면 뒷자리도 전부 0으로 채운 숫자를 후보에 담음
     *     *    11이면 뒷자리도 전부 1으로 채운 숫자를 후보에 담음
     * @param buttons
     * @param arrN
     * @return
     */
    private static Integer checkHead (List<Integer> buttons, int[] arrN) {
        Integer candidate = 0;
        Integer min = 0;
        Integer minGap = 10;
        int head = arrN[0];
        for(int i = 0 ; i <buttons.size() ; i++) {
             if (buttons.get(i)!=null && minGap>Math.abs(head - buttons.get(i))) {
                 minGap = Math.abs(head - buttons.get(i));
                 min = buttons.get(i);
             }
        }
        if (min.equals(10)) {
            String str = "10";
            for(int i = 1 ; i <arrN.length-1 ; i++) str += 0;
            candidate = Integer.valueOf(str);
        } else if (min.equals(11)) {
            String str = "11";
            for(int i = 1 ; i <arrN.length-1 ; i++) str += 1;
            candidate = Integer.valueOf(str);
        }

        return candidate;
    }


    /**
     * 7. 10이나 11이 아니라면, 모든 자릿수를 배열과 비교하여 산술결과의 절대값이 제일 작은 수로 모아서 후보에 담음
     * 8. 남은 숫자키 중 제일 큰 수로 채널길이-1 사이즈의 채널을 채워 만들고, (목표 채널-만든채널)의 결과와 (후보채널-목표채널)의 절대값을 비교
     * 9. 더 작은 수의 결과를 갖는 채널을 최종 결과로 출력
     */
    private static Integer mathAbs(List<Integer> buttons, int[] arrN) {
        String str = "";
        for(int i = 0; i <arrN.length; i++) {
            Integer min = 0;
            Integer minGap = 10;
            if(i==0||buttons.get(0)!=null) {
                for(int j = 1; j < buttons.size(); j++) {
                    Integer head = arrN[i];
                    Integer button = buttons.get(j);
                    if (button!= null && Math.abs(head-button)<minGap) {
                        minGap = Math.abs(head-button);
                        min = button;
                    }
                }
            }

            for(int j = 0; j <buttons.size(); j++) {
                Integer head = arrN[i];
                Integer button = buttons.get(j);
                if (button!= null && Math.abs(head-button)<minGap) {
                    minGap = Math.abs(head-button);
                    min = button;
                }
            }
            str += min;
        }

        return Integer.valueOf(str);
    }
}

