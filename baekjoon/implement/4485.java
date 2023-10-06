import java.util.*;
import java.io.*;
class Node implements Comparable<Node>{
  int x;
  int y;
  int w;

  public Node(int x, int y, int w) {
    this.x = x;
    this.y = y;
    this.w = w;
  }

  @Override
  public int compareTo(Node n) {
    return this.w - n.w;
  }
}

class Main {
  static int[][] arr;
  static int[][] dijk;
  static int[] dx = {1, 0, -1, 0};
  static int[] dy = {0, 1, 0, -1};
  static int n;

  public static int solution() {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    Node start = new Node(0,0,arr[0][0]);
    dijk[0][0] = arr[0][0];
    pq.offer(start);

    while(!pq.isEmpty()) {
      Node cur = pq.poll();
      
      for(int i=0; i<4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];
        
        if(0<=nx && nx<n && 0<=ny && ny<n) {
          if(dijk[nx][ny] > dijk[cur.x][cur.y] + arr[nx][ny]) {
            dijk[nx][ny] = dijk[cur.x][cur.y] + arr[nx][ny];
            pq.offer(new Node(nx,ny,dijk[nx][ny]));
          }
        }
      }
    }
    return dijk[n-1][n-1];
  }
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int cnt = 0;

    while(true) {
      n = Integer.parseInt(br.readLine());
      if(n == 0) {
        break;
      }
      arr = new int[n][n];
      dijk = new int[n][n];
      for(int i=0; i<n; i++) {
        st = new StringTokenizer(br.readLine(), " ");
        for(int j=0; j<n; j++) {
          arr[i][j] = Integer.parseInt(st.nextToken());
          dijk[i][j] = Integer.MAX_VALUE;
        }
      }
      cnt++;
      bw.write("Problem " + cnt + ": " + solution() + "\n");
    }
    bw.flush();
    bw.close();
    
  }
}
