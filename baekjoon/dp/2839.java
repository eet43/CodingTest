import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    // StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    
    int n = Integer.parseInt(br.readLine());
    int [] dp = new int[n+1];
    dp[1] = -1;
    dp[2] = -1;

    if(n%5==0) {
      dp[n] = n/5;
    } else if(n%5==1 && n>=6) {
      dp[n] = n/5 + 1;
    } else if(n%5==2 && n>=12) {
      dp[n] = n/5 + 2;
    } else if(n%5==3 && n>=3) {
      dp[n] = n/5 + 1;
    } else if(n%5==4 && n>=9) {
      dp[n] = n/5 + 2;
    } else {
      dp[n] = -1;
    }

    System.out.print(dp[n]);

  }
}
