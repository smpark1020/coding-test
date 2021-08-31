package com.smpaaark.leetcode.recursion;

public class Q50 {

    public static void main(String[] args) {
        Q50 q = new Q50();
        q.myPow(2.00000, -2);
//        System.out.println(q.myPow(0.00001, 2147483647));
    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        double returnNum = myPow(x,n / 2);
        double temp = returnNum * returnNum;
        if (n % 2 == 0) {
            return temp;
        } else {
            if (n > 0) {
                return x * temp;
            } else {
                return temp / x;
            }
        }
    }

}