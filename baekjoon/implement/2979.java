import java.util.*;
import java.io.*;

class Main {
  static int a,b,c;
  static int[] arr;
  
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    
    a = Integer.parseInt(st.nextToken());
    b = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());

    arr = new int[101];
    int min = 200;
    int max = -10;
    int sum = 0;
    

    for(int i=0; i<3; i++) {
      
      st = new StringTokenizer(br.readLine(), " ");
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());

      if(start<min) {
        min = start;
      }
      if(end>max) {
        max = end;
      }

      for(int j=start; j<end; j++) {
        arr[j] += 1;
      }
    }

    for(int i=min; i<max; i++) {
      if(arr[i] == 1) {
        sum+=a;
      } else if(arr[i]==2) {
        sum+=2*b;
      } else if(arr[i]==3) {
        sum+=3*c;
      }
    }

    
    // StringBuilder sb = new StringBuilder();
    // sb.append("answer").append('\n');
    
    // for(int i=1; i<n+1; i++) {
    //   for(int j=1; j<n+1; j++) {
    //     sb.append(answer[i][j] + " ");
    //   }
    //   sb.append('\n');
    // }
    System.out.println(sum);
    
  }
}
