import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
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

  public static void dijks(int s) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    dijk[s] = 0;
    pq.offer(new Node(s, 0));

    while(!pq.isEmpty()) {
      Node cur = pq.poll();
      int now = cur.v;
      int nowCost = cur.w;
      for(Node nd : arr.get(now)) {
        if(dijk[nd.v] < nowCost) continue;
        if(dijk[nd.v] > nowCost + nd.w) {
          dijk[nd.v] = nowCost + nd.w;
          pq.offer(new Node(nd.v, nowCost + nd.w));
        }
      }
    }
  }

  
  public static void main(String[] args) throws IOException {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int v = Integer.parseInt(st.nextToken());
    int e = Integer.parseInt(st.nextToken());
    int s = Integer.parseInt(br.readLine());

    arr = new ArrayList<ArrayList<Node>>();
    dijk = new int[v+1];

    for(int i=1; i<=v; i++) {
      dijk[i] = Integer.MAX_VALUE;
    }
    
    for(int i=0; i<=v; i++) {
      arr.add(new ArrayList<>());
    }
    
    for(int i=0; i<e; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int cv = Integer.parseInt(st.nextToken());
      int ce = Integer.parseInt(st.nextToken());
      int cw = Integer.parseInt(st.nextToken());

      arr.get(cv).add(new Node(ce, cw));
    }
    
    dijks(s);
    for(int i=1; i<=v; i++) {
      if(dijk[i] == Integer.MAX_VALUE) {
        System.out.println("INF");
      } else {
        System.out.println(dijk[i]);
      }
    }
  }
}
