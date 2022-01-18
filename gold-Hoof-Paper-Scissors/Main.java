import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("hps.in"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.valueOf(st.nextToken());
    int k = Integer.valueOf(st.nextToken())+1;
    
    //p = 0 || needs 2 to win
    //h = 1 || needs 0 to win
    //s = 2 || needs 1 to win

    int[] moves = new int[n];
    for (int i = 0; i<n; i++) {
      String move = br.readLine();
      //System.out.println(move);
      if(move.equals("P")) { 
        moves[i] = 0;
      } else if(move.equals("H")) {
        moves[i] = 1;
      } else {
        moves[i] = 2;
      }
    }
    
    //System.out.println(Arrays.toString(moves));

    int[][][] dp = new int[n][3][k];
    if(moves[0]==0){
      dp[0][2][0] = 1;
    } else if(moves[0]==1) {
      dp[0][0][0] = 1;
    } else {
      dp[0][1][0] = 1;
    }

    for(int i = 0; i<n-1; i++) {
      for(int j = 0; j<3; j++) {
        for(int h = 0; h<k; h++) {
          int x = dp[i][j][h];
          for(int j2 = 0; j2<3; j2++) {
            if(j2!=j) {
              if(h+1<k){
                if((moves[i+1]+2)%3==j2) dp[i+1][j2][h+1] = Math.max(dp[i+1][j2][h+1], 1+x);
                else dp[i+1][j2][h+1] = Math.max(dp[i+1][j2][h+1], x);
              }
            } else {
              if(h<k){
                if((moves[i+1]+2)%3==j2) dp[i+1][j2][h] = Math.max(dp[i+1][j2][h], 1+x);
                else dp[i+1][j2][h] = Math.max(dp[i+1][j2][h],x);
              }
            }
          }
        }
      }
    }
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
    int maxNum = 0;
    for(int i = 0; i<n; i++) {
      for(int j = 0; j<3; j++) {
        for(int h = 0; h<k; h++) {
          maxNum = Math.max(maxNum, dp[i][j][h]);
        }
      }
    }
    pw.print(String.valueOf(maxNum));
    pw.close();
  }
}