import java.util.*;
import java.io.*;

class Main {
  static int[] count;
  
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    s = s.toLowerCase();

    count = new int[26];
    int max = -10;
    int maxIdx = 0;
    

    for(char c : s.toCharArray()) {
      int ac = (int)c - 97;
      count[ac] += 1;
    }

    for(int i = 0; i<26; i++) {
      if(count[i]>max) {
        max = count[i];
        maxIdx = i;
      }
    }

    boolean flag = true;
    for(int i = 0; i<26; i++) {
      if(max == count[i] && maxIdx != i) {
        flag = false;
      }
    }
    if(flag) {
       System.out.println((char)(maxIdx+65));
    } else {
      System.out.println("?");
    }
  }
}
