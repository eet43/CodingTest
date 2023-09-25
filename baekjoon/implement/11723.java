import java.util.*;
import java.io.*;

class Main {
  
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int c = Integer.parseInt(br.readLine());

    HashSet<Integer> hs = new HashSet<>();

    for(int i=0; i<c; i++) {
      st = new StringTokenizer(br.readLine());
      String op = st.nextToken();
      if("all".equals(op)) {
        hs = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20));
      } else if("empty".equals(op)) {
        hs.clear();
      } else {
        int x = Integer.parseInt(st.nextToken());
        if("add".equals(op)) {
          hs.add(x);
        } else if("remove".equals(op)) {
          hs.remove(x);
        } else if("check".equals(op)) {
          if(hs.contains(x)) {
            bw.write("1\n");
          } else {
            bw.write("0\n");
          }
        } else if("toggle".equals(op)) {
          if(hs.contains(x)) {
            hs.remove(x);
          } else {
            hs.add(x);
          }
        }
      }
    }
    bw.flush();
    bw.close();
    
  }
}
