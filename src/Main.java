import java.io.*;

public class Main {
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String in;

        while (true) {

            try {
                in = br.readLine();
                if (in.equals("exit")) return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}