import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class no1931 {

    /**
     * 입력되는 각 회의 : 시작시간 | 종료시간을 가지고 있음
     */
    static class Meeting {
        private int start;
        private int end;
        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
        public int getStart() { return this.start; }
        public int getEnd() { return this.end; }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        List<Meeting>list = new ArrayList<>();  // 각 미팅을 담을 리스트
        for(int i=0; i<T ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            Meeting meeting = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            list.add(meeting);
        }

        /**
         * 미팅을 정렬 : 끝나는 시간을 기준으로 정렬 -> 시작시간이 빠른 순으로 정렬
         */
        Comparator<Meeting> compare = Comparator.comparing(Meeting::getEnd).thenComparing(Meeting::getStart);
        List<Meeting> sortedList = list.stream().sorted(compare).collect(Collectors.toList());

        /**
         * 끝나는 시간은 0시부터 다음 회의가 배정될때마다 해당 회의의 끝나는 시간으로 갱신될 것임
         */
        int count = 0;
        int endTime = 0;
        for(int i = 0 ; i < sortedList.size() ; i++) {
            if(endTime<=sortedList.get(i).getStart()) {
                endTime = sortedList.get(i).getEnd();
                count++;
            }
        }

        System.out.println(count);
    }
}