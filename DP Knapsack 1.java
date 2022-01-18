import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.valueOf(st.nextToken());
    int w = Integer.valueOf(st.nextToken());
    
    int[] weights = new int[n];
    int[] values = new int[n];
    for(int i = 0; i<n; i++) {
      st = new StringTokenizer(br.readLine());
      weights[i] = Integer.valueOf(st.nextToken());
      values[i] = Integer.valueOf(st.nextToken());
    }

    long[][] dp = new long[n][w+1];
    for(int i = weights[0]; i<w+1; i++) {
      dp[0][i] = values[0];
    }

    for(int i = 1; i<n; i++) {
      for(int j = 0; j<w+1; j++) {
        int wi = weights[i];
        int vi = values[i];
        if(j>=wi) {
          dp[i][j] = Math.max(vi+dp[i-1][j-wi], dp[i-1][j]);
        }
        else {
          dp[i][j] = dp[i-1][j];
        }
      }
    }

    System.out.println(dp[n-1][w]);

  }
}