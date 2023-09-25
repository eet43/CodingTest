import java.util.*;
import java.io.*;

class Person{
  int weight;
  int height;
  int rank;

  public Person(int w, int h) {
    this.weight = w;
    this.height = h;
    this.rank = 1;
  }
  public void compare(Person p) {
    if(this.weight > p.weight && this.height > p.height) {
      p.rank += 1;
    }
  }
}

class Main {

  static ArrayList<Person> list = new ArrayList<>();
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
    
    StringTokenizer st;
    int n = Integer.parseInt(br.readLine());

    for(int i=0; i<n; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int w = Integer.parseInt(st.nextToken());
      int h = Integer.parseInt(st.nextToken());
      list.add(new Person(w, h));
    }

    for(int i=0; i<n; i++) {
      Person cur = list.get(i);
      for(int j=0; j<n; j++) {
        if(i==j) {
          continue;
        } else {
          Person p = list.get(j);
          cur.compare(p);
        }
      }
    }

    for(int i=0; i<n; i++) {
      wr.write(list.get(i).rank + " ");
    }
    wr.flush();
    wr.close();
  }
}
