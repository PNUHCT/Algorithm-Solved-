import java.io.*;

public class no5358 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    public static void main(String[] args) throws IOException {

        while (true){
            try {
                String[] str = br.readLine().split("");
                String result = "";
                for(String st : str) {
                    if(st.equals("i")) result += "e";
                    else if (st.equals("e")) result += "i";
                    else if (st.equals("I")) result += "E";
                    else if (st.equals("E")) result += "I";
                    else result += st;
                }
                System.out.println(result);
            } catch (Exception e) {
                break;
            }

        }
    }
}