import java.util.*;
import java.io.*;

class Node {
  int v;

  public Node(int v) {
    this.v = v;
  }
}
class Main {
  public static void main(String[] args) throws IOException {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    // StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(br.readLine());
 
		int count = 1;
    int sum = 0;
 
		while (true) {
			if (n <= count + sum) {	
				
				if (count % 2 == 1) {
					System.out.print((count - (n - sum - 1)) + "/" + (n - sum));
					break;
				} 
				
				else {
					System.out.print((n - sum) + "/" + (count - (n - sum - 1)));
					break;
				}
 
			} else {
				sum += count;
				count++;
			}
		}

  }
}
