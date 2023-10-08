import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    // StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    String s = br.readLine();
    String[] arr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    for(String alph : arr) {
      if(s.contains(alph)) {
        s = s.replace(alph, "1");
      }
    }
    System.out.println(s.length());

  }
}
