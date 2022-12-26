import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class no1152 {
    // 풀이: 문자열 분리 후 빈 문자열 제거
    public static void main(String[] args) throws IOException {

        // 방법 1: for문 + count를 이용한 빈문자열 필터링 (제일 빠름)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int count = 0;
        for(int i = 0; i < arr.length ; i++) if(!arr[i].equals("")) count++;
        System.out.println(count);


        // 방법 2: Stream을 이용한 빈문자열 필터링
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String[] arr = br.readLine().split(" ");
//        List<String> list = Arrays.stream(arr).filter(a->a.length()>0).collect(Collectors.toList());
//        System.out.println(list.size());


        // 방법 3: buffer writer사용
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        String[] arr = br.readLine().split(" ");
//        int count = 0;
//        for(int i = 0; i < arr.length ; i++) if(!arr[i].equals("")) count++;
//
//        bw.write(""+count);
//        bw.close();
    }
}

