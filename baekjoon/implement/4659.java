import java.util.*;
import java.io.*;


class Main {
  public static void main(String[] args) throws IOException {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    char[] checkList = {'a', 'e', 'i', 'o', 'u'};
    String check = "a,e,i,o,u";
    
    while(true) {
      String s = br.readLine();
      if(s.equals("end")) break;
      boolean flag = true;
      boolean checkFlag = false;
      char[] cArray = s.toCharArray();
      int n = cArray.length;

      for(char c : checkList) {
        if(s.indexOf(c) >= 0) {
          checkFlag = true;
        }
      }
      if(checkFlag) {
        for(int i=0; i<cArray.length-1; i++) {
        if(i+2<n && check.indexOf(cArray[i])>=0 && check.indexOf(cArray[i+1])>=0 && check.indexOf(cArray[i+2])>=0) {
          flag = false;
          break;
        } 
        if(i+2<n && check.indexOf(cArray[i])<0 && check.indexOf(cArray[i+1])<0 && check.indexOf(cArray[i+2])<0) {
          flag = false;
          break;
        }
        if(i+1<n && cArray[i] == cArray[i+1] && cArray[i] != 'e' && cArray[i] != 'o') {
          flag = false;
          break;
        }
      }
      } else {
        flag = false;
      }
      if(flag==true) {
        bw.write("<" + s + "> is acceptable." + "\n");
      } else {
        bw.write("<" + s + "> is not acceptable." + "\n");
      }
    }

    bw.flush();
    bw.close();

  }
}
