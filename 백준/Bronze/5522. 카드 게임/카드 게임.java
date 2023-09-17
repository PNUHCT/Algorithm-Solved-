    import java.io.*;
    import java.util.StringTokenizer;
    
    public class Main {
        private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        public static void main(String[] args) throws IOException {
            
            int cycle = 5;
            int result = 0;
            while(cycle-->0) result += Integer.parseInt(br.readLine());
    
            System.out.println(result);
        }
    }