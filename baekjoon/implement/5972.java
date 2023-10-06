import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
  int v;
  int w;

  public Node(int v, int w) {
    this.v = v;
    this.w = w;
  }
  
  @Override
  public int compareTo(Node n) {
    return this.w - n.w;
  }
}

class Main {
  static ArrayList<ArrayList<Node>> arr;
  static int[] dijk;
  public static void solution(int s) {
    Node nd = new Node(s,0);
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(nd);

    while(!pq.isEmpty()) {
      Node cur = pq.poll();
      int now = cur.v;
      int nowCost = cur.w;
      if(nowCost > dijk[now]) continue;
      for(Node n : arr.get(now)) {
        if(dijk[n.v] > nowCost + n.w) {
          dijk[n.v] = nowCost + n.w;
          pq.offer(new Node(n.v, nowCost + n.w));
        }
      }
    }
    
  }
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    arr = new ArrayList<ArrayList<Node>>();
    dijk = new int[n+1];
    
    for(int i=0; i<=n; i++) {
      arr.add(new ArrayList<Node>());
      dijk[i] = Integer.MAX_VALUE;
    }

    for(int i=0; i<m; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      arr.get(s).add(new Node(e,w));
      arr.get(e).add(new Node(s,w));
    }

    solution(1);
    System.out.println(dijk[n]);
  }
}
