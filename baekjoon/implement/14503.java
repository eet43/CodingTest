import java.util.*;
import java.io.*;


class Main {
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, 1, 0, -1};
  static int n,m;
  static int[][] map;
  static int count;
  static BufferedWriter bw;

  public static void clean(int x, int y, int d) throws IOException {
    map[x][y] = 2;
    
    for(int i=0; i<4; i++) {
      int tmp_d = (d+3-i) % 4;
      int nx = x + dx[tmp_d];
      int ny = y + dy[tmp_d];
      if(nx >=0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0) {
        count++;
        clean(nx, ny, tmp_d);
        return;
      }
    }
    int tmp_d = (d+2) % 4;
    int nx = x + dx[tmp_d];
    int ny = y + dy[tmp_d];
    if(nx >=0 && nx < n && ny >= 0 && ny < m && map[nx][ny] != 1) {
      clean(nx, ny, d);
    }
  }
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine(), " ");
    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());

    map = new int[n][m];
    count = 1;

    for(int i=0; i<n; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for(int j=0; j<m; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    clean(x,y,d);
    System.out.print(count);

    bw.flush();
    bw.close();

  }
}
