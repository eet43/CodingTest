import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    int[] dp = new int[n];
    
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for(int i=0; i<n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    dp[0] = arr[0];
    int max = dp[0];

    for(int i=1; i<n; i++) {
      for(int j=0; j<i; j++) {
        if(arr[j] < arr[i]) {
          dp[i] = Math.max(dp[i], dp[j]);
        }
      }
      dp[i] += arr[i];
      max = Math.max(max, dp[i]);
    }
    System.out.println(max);
  }
}
