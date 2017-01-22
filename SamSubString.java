package com.keerthi.hackerearth.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SamSubString {

  private final static int NUM = 1000000007;

  public static void main(String[] args) throws IOException {
    int[] balls = strNumToArray((new BufferedReader(new InputStreamReader(System.in))).readLine());

    int n = balls.length;
    for (int i = n - 2; i >= 0; --i) {
      balls[i] = (int)((balls[i + 1] + (((long)balls[i]) * (n - i)) % NUM) % NUM);
    }
    int power = 1;
    int total = 0;
    for (int i = 0; i < n; ++i) {
      total = (int)((total + (((long)balls[i]) * power) % NUM) % NUM);
      power = (int)((power * 10L) % NUM);
    }

    System.out.print(total);

  }

  private static int[] strNumToArray(String numberStr) {
    int len = numberStr.length();
    int[] numArray = new int[len];
    for (char c : numberStr.toCharArray()) {
      numArray[--len] = c - '0';
    }
    return numArray;
  }

}
