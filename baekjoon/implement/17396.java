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
  static long[] dijk;
  static boolean[] imp;
  
  public static void solution(int s) {
    Node nd = new Node(s,0);
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(nd);

    while(!pq.isEmpty()) {
      Node cur = pq.poll();
      int now = cur.v;
      int nowCost = cur.w;
      for(Node cd : arr.get(now)) {
        if(nowCost > dijk[cd.v]) continue;
        if(!imp[cd.v]) continue;
          if(dijk[cd.v] > nowCost + cd.w) {
            dijk[cd.v] = nowCost + cd.w;
            pq.offer(new Node(cd.v, nowCost + cd.w));
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
    imp = new boolean[n];
    dijk = new int[n];
    
    for(int i=0; i<n; i++) {
      arr.add(new ArrayList<Node>());
      dijk[i] = Integer.MAX_VALUE;
    }

    st = new StringTokenizer(br.readLine(), " ");
    for(int i=0; i<n; i++) {
      int ward = Integer.parseInt(st.nextToken());
      if(i == 0 || i==n-1) {
        imp[i] = true;
      } else if(ward == 1) {
        imp[i] = false;
      } else {
        imp[i] = true;
      }
    }


    for(int i=0; i<m; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      arr.get(s).add(new Node(e,w));
      arr.get(e).add(new Node(s,w));
    }

    solution(0);
    if(dijk[n-1] == Integer.MAX_VALUE) {
      System.out.print(-1);
    } else {
      System.out.print(dijk[n-1]); 
    }
  }
}
