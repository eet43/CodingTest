import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
  int v;
  int c;
  

  public Node(int v, int c) {
    this.v = v;
    this.c = c;
  }
  
  @Override
  public int compareTo(Node n) {
    return this.c - n.c;
  }
}

class Main {
  static int n,m;
  static ArrayList<ArrayList<Node>> arr;
  static int[] dijk;
  
  public static void dijks(int start) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    dijk[start] = 0;
    pq.offer(new Node(start,0));

    while(!pq.isEmpty()) {
      Node cur = pq.poll();
      int now = cur.v;
      int nowCost = cur.c;
      if(dijk[now] < nowCost) continue;
      if(now - 1 <= 100000 && now-1>=0) {
        if(dijk[now-1] > nowCost + 1) {
          dijk[now-1] = nowCost + 1;
          pq.offer(new Node(now-1, nowCost+1));
        }
      }
      if(now + 1 <= 100000) {
        if(dijk[now+1] > nowCost + 1) {
          dijk[now+1] = nowCost + 1;
          pq.offer(new Node(now+1, nowCost+1));
        }
      }
      if(2*now <= 100000) {
        if(dijk[2*now] > nowCost) {
          dijk[2*now] = nowCost;
          pq.offer(new Node(2*now, nowCost));
        }
      }
    }
  }
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new ArrayList<ArrayList<Node>>();
    dijk = new int[100001];
    
    for(int i=0; i<=100000; i++) {
      arr.add(new ArrayList<Node>());
    }

    for(int i=0; i<=100000; i++) {
      dijk[i] = Integer.MAX_VALUE;
    }

    dijks(n);
    System.out.print(dijk[m]);
  }
}
