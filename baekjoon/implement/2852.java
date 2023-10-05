import java.util.*;
import java.io.*;

class Winner {
  int total;
  int team;

  public Winner() {
    total = 0;
    team = 0;
  }
  
}
class Main {
  static int[] score = new int[3];
  static int[] time = new int[3];
  static Winner winner = new Winner();
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int n = Integer.parseInt(br.readLine());
    // for(int i=0; i<2; i++) {
    //   time.add(new Time());
    // }
    
    for(int i=0; i<n; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int team = Integer.parseInt(st.nextToken());
      String str = st.nextToken();
      String[] arr = str.split(":");
      int tm = Integer.parseInt(arr[0], 10) * 60;
      int ts = Integer.parseInt(arr[1], 10);

      score[team] += 1;
      if(score[1] > score[2]) {
        if(winner.team == 0) {
          winner.team = 1;
          winner.total = tm + ts; 
        }
      } else if(score[1] < score[2]) {
        if(winner.team == 0) {
          winner.team = 2;
          winner.total = tm + ts; 
        }
      } else {
        // 1. 누가 이기고 있었는지 정보 필요.
        time[winner.team] += (tm + ts) - winner.total;
        // 2. 언제부터 이기고 있었는지에 대한 정보 필요.
        winner.team = 0;
        winner.total = 0;
      }
    }

    if(winner.team != 0) {
      time[winner.team] += 48*60 - winner.total;
    }

    
    for(int i=1; i<3; i++) {
      int h = time[i]/60;
      int m = time[i]%60;
      if(h < 10) {
        bw.write("0" + h + ":");
      } else {
        bw.write(h + ":");
      }

      if(m < 10) {
        bw.write("0" + m + "\n");
      } else {
        bw.write(m + "\n");
      }
    }
    bw.flush();
    bw.close();
  }
}
