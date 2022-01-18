import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.valueOf(st.nextToken());
    int k = Integer.valueOf(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i<n; i++) {
      a[i] = Integer.valueOf(st.nextToken());
    }

    String[] dp = new String[k+1];
    for(int i = 0; i<k+1; i++){
      dp[i] = "Second";
      for(int j = 0; j<n; j++) {
        if(i>=a[j]){
          if(dp[i-a[j]].equals("Second")) dp[i] = "First";
        }
      }
    }
    System.out.println(dp[k]);
  }
}