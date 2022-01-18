import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.valueOf(st.nextToken());
    int k = Integer.valueOf(st.nextToken());
        
    int[] arr = new int[n];
    int[] dp = new int[n];

    st = new StringTokenizer(br.readLine());
    for(int i = 0; i<n; i++) {
      arr[i] = Integer.valueOf(st.nextToken());
    }
    for(int i = 1; i<n; i++) {
      int minDp = Integer.MAX_VALUE;
      for(int j = 1; j<=k; j++) {
        if(i-j>=0) {
          minDp = Math.min(Math.abs(arr[i]-arr[i-j])+dp[i-j], minDp);
        }
      }
      dp[i] = minDp;
    }
    System.out.println(dp[n-1]);
  }
}