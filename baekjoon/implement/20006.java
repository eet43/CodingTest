import java.util.*;
import java.io.*;

class Player implements Comparable<Player>{
  int level;
  String name;

  public Player(int l, String n) {
    this.level = l;
    this.name = n;
  }

  @Override
  public int compareTo(Player p) {
    return this.name.compareTo(p.name);
  }
}

class Room {
  int level;
  ArrayList<Player> players;
  boolean isFull;

  public Room(int l) {
    this.level = l;
    this.isFull = false;
    this.players = new ArrayList<>();
  }

  public void addPlayer(Player p) {
    this.players.add(p);
  }

  public void check(int m) {
    if(this.players.size() == m) {
      this.isFull = true;
    }
  }
}

class Main {
  static ArrayList<Room> rooms = new ArrayList<>();
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    
    int p = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    for(int i=0; i<p; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int l = Integer.parseInt(st.nextToken());
      String s = st.nextToken(); //닉네임 하나가 아님
      Player player = new Player(l, s);
      
      if(rooms.isEmpty()) {
        Room newRoom = new Room(l);
        newRoom.addPlayer(player);
        rooms.add(newRoom);
      } else {
        boolean flag = false;
        for(int j=0; j<rooms.size(); j++) {
          Room findRoom = rooms.get(j);
          if(findRoom.level-10<= l && findRoom.level+10 >= l && !findRoom.isFull) {
            flag = true;
            findRoom.players.add(player);
            findRoom.check(m); //가득찼는지 확인
            break;
          }
        }
        if(flag == false) {
          Room newRoom = new Room(l);
            newRoom.addPlayer(player);
            rooms.add(newRoom);
        }
      }
    }

    
    
    
    for(int i=0; i<rooms.size(); i++) { //사이즈 1일때 예외처리 필요
      Room findRoom = rooms.get(i);
      Collections.sort(findRoom.players);
      if(findRoom.isFull) {
        bw.write("Started!\n");
      } else {
        bw.write("Waiting!\n");
      }

      for(int j=0; j<findRoom.players.size(); j++) {
        Player findP = findRoom.players.get(j);
        bw.write(findP.level + " ");
        bw.write(findP.name + "\n");
      }
    }
    bw.flush();
    bw.close();
  }
}
