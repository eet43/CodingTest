import java.util.*;
import java.io.*;


class Main {
  public static void main(String[] args) throws IOException {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    // StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int n = Integer.parseInt(br.readLine());
    
    if(n%2==1) {
      System.out.print("SK");
    } else {
      System.out.print("CY");
    }
  }
}
