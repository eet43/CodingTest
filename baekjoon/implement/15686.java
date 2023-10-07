import java.util.*;
import java.io.*;

class Node {
  int x;
  int y;
  public Node(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

class Main {

  static int n,m,len;
  static int min = Integer.MAX_VALUE;
  static int[] combi;
  static ArrayList<Node> home = new ArrayList<>();
  static ArrayList<Node> chicken = new ArrayList<>();

  public static void DFS(int L, int s) {
    if(L == m) {
      int sum = 0;
      for(Node nd : home) {
        int min_d = Integer.MAX_VALUE;
        for(int j : combi) {
          int d = Math.abs(nd.x - chicken.get(j).x) + Math.abs(nd.y - chicken.get(j).y);
          min_d = Math.min(min_d, d);
        }
        sum += min_d;
      }
      min = Math.min(min, sum);
    } else {
      for(int i=s; i<len; i++) {
        combi[L] = i;
        DFS(L+1, i+1);
      }
    }
  }
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    combi = new int[m];

    for(int i=1; i<=n; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for(int j=1; j<=n; j++) {
        int v = Integer.parseInt(st.nextToken());
        if(v==1) {
          home.add(new Node(i,j));
        } else if(v==2) {
          chicken.add(new Node(i,j));
        }
      }
    }
    
    len = chicken.size();
    DFS(0,0);
    System.out.println(min);

  }
}
