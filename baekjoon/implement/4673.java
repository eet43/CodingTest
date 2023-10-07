import java.util.*;
import java.io.*;
  
class Main {
  static boolean[] check;

  public static void d(int n) {
    int sum = 0;
    int dig = (int)(Math.log10(n) + 1);
    
    sum += n;
    if(sum>10000) return;
    for(int j=dig-1; j>0; j--) {
      int v = (int)Math.pow(10,j);
      sum += (n/v);
      if(sum>10000) return;
      n %= v;
    }
    sum += n;
    if(sum>10000) return;
    check[sum] = true;
  }
  
  public static void main(String[] args) throws IOException {
    
    // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    // StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    check = new boolean[10001];
    for(int i=0; i<10001; i++) {
      check[i] = false;
    }

    for(int i=1; i<10001; i++) {
      d(i);
    }
    
    for(int i=1; i<10001; i++) {
      if(check[i] == false) {
        bw.write(i + "\n");
      }
    }

    bw.flush();
    bw.close();
  }
}
