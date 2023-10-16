import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        String ss = br.readLine();
        String[] xs = ss.split("\\.");
        StringBuilder sb = new StringBuilder();
 
        for (int i = 0; i < xs.length; i++) {
            String x = xs[i];
 
            if (x.length() % 2 != 0) {
                sb = new StringBuilder("-1");
                break;
            } else if (x.length() % 4 == 0) {
                sb.append("AAAA".repeat(x.length() / 4));
            } else {
                sb.append("AAAA".repeat(x.length() / 4));
                sb.append("BB");
            }
 
            if (i != xs.length - 1) {
                sb.append(".");
            }
        }
 
        String ans = sb.toString();
        if (!ans.equals("-1")) {
            sb.append(".".repeat(ss.length() - sb.toString().length()));
        }
 
        bw.write(sb + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
