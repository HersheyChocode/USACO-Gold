import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.valueOf(st.nextToken());
    int[] arr = new int[n];
    int[] dp = new int[n];

    st = new StringTokenizer(br.readLine());
    for(int i = 0; i<n; i++) {
      arr[i] = Integer.valueOf(st.nextToken());
    }
    dp[1] = Math.abs(arr[1]-arr[0]);
    for(int i = 2; i<n; i++) {
      dp[i] = Math.min(Math.abs(arr[i]-arr[i-1])+dp[i-1], Math.abs(arr[i]-arr[i-2])+dp[i-2]);
    }
    System.out.println(dp[n-1]);
  }
}