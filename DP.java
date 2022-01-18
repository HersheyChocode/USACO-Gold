import java.io.*;
import java.util.*;


class Main {

  static int[] arr;

  public static void main(String[] args) {
    System.out.println("Hello world!");

    arr = new int[n];
    Arrays.fill(arr,-1);

    int first = 0;
    int second = 1;
    for(int i = 2; i<n; i++){
      int temp = first + second;
      first = second;
      second = temp;
    }

  }

  public static int fib(int n) {
    if(n==0) return 0;
    if(n==1) return 1;

    if(arr[n]!=-1) return arr[n];
    else {
      arr[n] = fib(n-1) + fib(n-2);
    }

    return arr[n];
  }
}