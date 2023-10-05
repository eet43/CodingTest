import java.util.*;
import java.io.*;

class Main {
  static int[] arr;
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    StringTokenizer st;
    int n = Integer.parseInt(br.readLine());
    arr = new int[n+1];
    
    st = new StringTokenizer(br.readLine(), " ");
    for(int i=1; i<=n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int p = Integer.parseInt(br.readLine());
    for(int i=0; i<p; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int sex = Integer.parseInt(st.nextToken());
      int number = Integer.parseInt(st.nextToken());

      if(sex == 1) {
        for(int j=number; j<=n; j+=number) {
          if(arr[j]==1) {
            arr[j] = 0;
          } else {
            arr[j] = 1;
          }
        }
      } else {
        int j = 1;
        while(true) {
          int ns = number - j;
          int ne = number + j;
          if(ns>=1 && ne<=n && arr[ns] == arr[ne]) {
            j++;
          } else {
            int start = ns+1;
            int end = ne-1;
            for(int k = start; k<=end; k++) {
              if(arr[k]==1) arr[k]=0;
              else arr[k]=1;
            }
            break;
          }
        }
      }
    }

    int idx = 0;
    for(int i=1; i<=n; i++) {
      if(idx == 19) {
        bw.write(arr[i] + "\n");
        idx = 0;
      } else {
        bw.write(arr[i] + " ");
        idx++;
      }
    }
    bw.flush();
    bw.close();
  }
}
