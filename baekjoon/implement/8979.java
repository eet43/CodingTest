import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int gold;
    int silver;
    int bronze;
    int num;
    int rank;

    public Node(int num, int gold, int silver, int bronze, int rank) {
      this.num = num;
      this.gold = gold;
      this.silver = silver;
      this.bronze = bronze;
      this.rank = rank;
    }

  @Override
    public int compareTo(Node other) {
      if(this.gold == other.gold) {
        if(this.silver == other.silver) {
          return other.bronze - this.bronze;
        } else {
          return other.silver - this.silver;
        }
      } else {
        return other.gold - this.gold;
      }
    }
  }

class Main {

  static int[] count;
  static ArrayList<Node> list = new ArrayList<>();
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int idx = 0;
    int n = Integer.parseInt(st.nextToken()); // 국가의수
    int k = Integer.parseInt(st.nextToken()); // 등수를 알고 싶은 국가
        for(int i=0; i<n; i++) {
        st = new StringTokenizer(br.readLine(), " ");
        int num = Integer.parseInt(st.nextToken());      //국가의 번호
        if(k == num) {
          
        }
        int gold = Integer.parseInt(st.nextToken());
        int silver = Integer.parseInt(st.nextToken());
        int bronze = Integer.parseInt(st.nextToken());
        list.add(new Node(num,gold,silver,bronze,0));
      }
    Collections.sort(list);
    list.get(0).rank = 1;

    for(int i=1; i<n; i++) {
      Node nd = list.get(i);
      int tg = list.get(i-1).gold;
      int ts = list.get(i-1).silver;
      int tb = list.get(i-1).bronze;
      int tr = list.get(i-1).rank;

      if(nd.num == k) {
        idx = i;
      }

      if(nd.gold == tg && nd.silver == ts && nd.bronze == tb) {
        nd.rank = tr;
      } else {
        nd.rank = tr + 1;
      }
    }

    System.out.println(list.get(idx).rank);
  }
}
