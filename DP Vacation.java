import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.valueOf(st.nextToken());
    int[][] arr = new int[n][3];
    int[][] dp = new int[n][3];

    for(int i = 0; i<n; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j<3; j++){
        arr[i][j] = Integer.valueOf(st.nextToken());
      }
    }
    for(int i = 0; i<3; i++) dp[0][i] = arr[0][i];
    for(int i = 1; i<n; i++) {
      dp[i][0] = Math.max(dp[i-1][1],dp[i-1][2]) + arr[i][0];
      dp[i][1] = Math.max(dp[i-1][0],dp[i-1][2]) + arr[i][1];
      dp[i][2] = Math.max(dp[i-1][1],dp[i-1][0]) + arr[i][2];
    }
    System.out.println(Math.max(Math.max(dp[n-1][0], dp[n-1][1]), dp[n-1][2]));
  }
}