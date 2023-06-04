import java.io.*;
import java.time.LocalDateTime;

public class no10768 {

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int month = Integer.parseInt(br.readLine());
//        int day = Integer.parseInt(br.readLine());
//
//        if(month==2) {
//            if(day==18) System.out.println("Special");
//            else if(day>18) System.out.println("After");
//            else System.out.println("Before");
//        }
//        else if (month>2) System.out.println("After");
//        else System.out.println("Before");
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int month = Integer.parseInt(br.readLine());
        int day = Integer.parseInt(br.readLine());
        LocalDateTime base = LocalDateTime.of(2015, 2, 18,0,0,0);
        LocalDateTime input = LocalDateTime.of(2015, month, day,0,0,0);

        if(base.isEqual(input)) System.out.println("Special");
        else if (base.isAfter(input)) System.out.println("Before");
        else System.out.println("After");
    }
}

