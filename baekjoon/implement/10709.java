import java.util.*;
import java.io.*;
class Cloud {
  int x;
  int y;

  public Cloud(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

class Main {
  static int[][] check;
  static int[][] arr;
  static Queue<Cloud> queue = new LinkedList<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int h = Integer.parseInt(st.nextToken());
    int w = Integer.parseInt(st.nextToken());

    check = new int[h+1][w+1];
    arr = new int[h+1][w+1];
    

    for(int i = 1; i<=h; i++) {
      String s = br.readLine();
      for(int j=1; j<=w; j++) {
        char c = s.charAt(j-1);
        if(c == 'c') {
          check[i][j] = 1;
          queue.offer(new Cloud(i, j));
        }
      }
    }

    while(!queue.isEmpty()) {
      Cloud c = queue.poll();
      int nx = c.x;
      int ny = c.y + 1;

      if(ny <= w && check[nx][ny] == 0) {
        check[nx][ny] = 1;
        arr[nx][ny] = arr[c.x][c.y] + 1;
        queue.offer(new Cloud(nx, ny));
      }
    }

    for(int i = 1; i<=h; i++) {
      for(int j=1; j<=w; j++) {
        if(check[i][j] == 0) {
          arr[i][j] = -1;
        }
        bw.write(arr[i][j] + " ");
      }
      bw.write("\n");
    }

    bw.flush();
    bw.close();
  }
}
