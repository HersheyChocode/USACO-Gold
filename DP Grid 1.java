import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int h = Integer.valueOf(st.nextToken());
    int w = Integer.valueOf(st.nextToken());

    char[][] grid = new char[h][w];
    
   // br = new BufferedReader(new InputStreamReader(System.in));
    for(int i = 0; i<h; i++) {
      //"." = 0
      //"#" = 1
      String line = br.readLine();
      for(int j = 0; j<w; j++) {
        grid[i][j]=line.charAt(j);
      }
    }

    int[][] dp = new int[h][w];
    dp[0][0] = 1;
    for(int i = 0; i<h; i++) {
      for(int j = 0; j<w; j++) {
        int sum = 0;
        if(grid[i][j]=='.') {
          if(i-1>=0) {
            sum+= dp[i-1][j];
          }
          if(j-1>=0) {
            sum+= dp[i][j-1];
          }
        }
        if(!(i==0&&j==0)) dp[i][j] = sum%((int)(Math.pow(10,9))+7);
      }
    }

    System.out.println((int) dp[h-1][w-1]);

  }
}