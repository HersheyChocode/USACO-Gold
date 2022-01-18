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

    long[][] dp = new long[n][100001];
    
    for(int i = 0; i<n; i++){
      for(int j = 1; j<100001;j++){
        dp[i][j] = Integer.MAX_VALUE;
      }
    }

    for(int i = 1; i<values[0]+1; i++) {
      dp[0][i] = weights[0];
    }

    for(int i = 1; i<n; i++) {
      for(int j = 1; j<100001; j++) {
        int wi = weights[i];
        int vi = values[i];
        if(j>=vi) {
         dp[i][j]=Math.min(dp[i-1][j], dp[i-1][j-vi]+wi);
        }
        else {
          dp[i][j] = dp[i-1][j];
        }
      }
    }

    boolean foundOne = false;
    long val = -1;
    for(int i = 100000; i>=0 && !foundOne; i--) {
     if(dp[n-1][i]<=w) {
       val = i;
       foundOne = true;
     }
    }

    System.out.println(val);

  }
}