import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();
    String t = br.readLine();

    int[][] dp = new int[s.length()+1][t.length()+1];


    for(int i = 0; i<s.length(); i++) {
      for(int j = 0; j<t.length(); j++) {
        if(s.charAt(i)==t.charAt(j)){
          dp[i+1][j+1] = dp[i][j] + 1;
        } else {
          dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
        }
      }
    }

    String word = "";
    int i = s.length();
    int j = t.length();
    while(i>0 && j>0) {
      if(s.charAt(i-1)==t.charAt(j-1)){
        word = s.charAt(i-1)+word;
        i--; j--;
      }
      else if(dp[i-1][j]>dp[i][j-1]){
        i--;
      } else {
        j--;
      } 
    }
    System.out.println(word);
  }
}