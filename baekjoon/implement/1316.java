import java.util.*;
import java.io.*;
  
class Main {
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    // StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int n = Integer.parseInt(br.readLine());
    int cnt = 0;

    for(int i=0; i<n; i++) {
      boolean[] check = new boolean[26];
      String s = br.readLine();
      char[] arr = s.toCharArray();
      check[(int)arr[0] - 97] = true;

      boolean flag = true;
      for(int j=1; j<arr.length; j++) {
        if(arr[j] != arr[j-1]) {
          int idx = (int)arr[j] - 97;
          if(check[idx] == true) {
            flag = false;
            break;
          }
          check[(int)arr[j] - 97] = true;
        }
      }
      if(flag == true) cnt++;
    }
    System.out.println(cnt);
  }
}
