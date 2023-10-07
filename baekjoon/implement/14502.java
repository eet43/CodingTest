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
  static int[][] map;
  static int max;
  static int n,m;
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, 1, 0, -1};
  
  public static void dfs(int L) {
    if(L==3) {
      bfs();
      return;
    } else {
      for(int i=0; i<n; i++) {
        for(int j=0; j<m; j++) {
          if(map[i][j] == 0) {
            map[i][j] = 1;
            dfs(L+1);
            map[i][j] = 0;
          }
        }
      }
    }
  }

  public static void bfs() {
    int sum = 0;
    Queue<Node> queue = new LinkedList<>();
    int[][] testMap = new int[n][m];

    for(int g=0; g<n; g++) {
      for(int h=0; h<m; h++) {
        testMap[g][h] = map[g][h];
        if(map[g][h] == 2) {
          queue.add(new Node(g,h));
        }
      }
    }

    while(!queue.isEmpty()) {
      Node cur = queue.poll();
      for(int z = 0; z<4; z++) {
        int nx = cur.x + dx[z];
        int ny = cur.y + dy[z];
        if(nx>=0 && nx<n && ny>=0 && ny<m && testMap[nx][ny] == 0) {
          testMap[nx][ny] = 2;
          queue.add(new Node(nx,ny));
        }
      }
    }

    for(int g=0; g<n; g++) {
      for(int h=0; h<m; h++) {
        if(testMap[g][h] == 0) {
          sum++;
        }
      }
    }
    max = Math.max(max, sum);
  }
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    max = 0;

    map = new int[n][m];
    
    //초기화
    for(int i=0; i<n; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for(int j=0; j<m; j++) {
        int v = Integer.parseInt(st.nextToken());
        map[i][j] = v;
      }
    }

    //벽 세우기
    dfs(0);
    System.out.println(max);

  }
}
