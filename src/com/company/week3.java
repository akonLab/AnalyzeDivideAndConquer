package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Coordinates {
    int x;
    int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}

public class week3 {
    static HashMap<Integer, Coordinates> meteors;
    static Coordinates finishPoint;
    static Integer N = 5;//end point xy
    static Integer K = 3;//meteor count

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);//O(1)
        System.out.println("meteores count");//O(1)
        K = in.nextInt();//O(1)
        System.out.println("end point x and y");//O(1)
        N = in.nextInt();//O(1)

        finishPoint = new Coordinates(N, N);//O(1)

        meteors = createMeteorsSquad(K);//O(n)
        System.out.println();//O(1)

        countWay();
    }
    static void countWay() {
        String[][] arr = new String[N][N];

//fill empty arr
        for (int i = 0; i < N; i++) {//O(n)
            for (int j = 0; j < N; j++) {
                arr[i][j] = "0";
            }
        }
        for (Integer key : meteors.keySet()) {//O(n)
            arr[meteors.get(key).x][meteors.get(key).y] = "m";
        }
        arr[0][0] = "1";

        System.out.println("before");
        for (int i = 0; i < N; i++) {//O(n)
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < N; i++) {//O(n)
            for (int j = 0; j < N; j++) {

                if (!arr[i][j].equals("m")) {
                    if (i == 0 && j == 0) {
                        arr[i][j] = "1";
                    } else if (i - 1 < 0 && j - 1 >= 0) {
                        if (!arr[i][j - 1].equals("m")) {
                            arr[i][j] = arr[i][j - 1];
                        } else {
                            arr[i][j] = "0";
                        }
                    } else if (j - 1 < 0 && i - 1 >= 0) {
                        if (!arr[i - 1][j].equals("m")) {
                            arr[i][j] = arr[i - 1][j];
                        } else {
                            arr[i][j] = "0";
                        }
                    } else if (arr[i - 1][j].equals("m") && arr[i][j - 1].equals("m")) {
                        arr[i][j] = "0";
                    } else if (arr[i - 1][j].equals("m") && (j - 1) < 0) {
                        arr[i][j] = "0";
                    } else if (arr[i][j - 1].equals("m") && (i - 1) < 0) {
                        arr[i][j] = "0";
                    } else if (arr[i - 1][j].equals("m")) {
                        if (j - 1 >= 0) {
                            arr[i][j] = arr[i][j - 1];
                        } else {
                            arr[i][j] = "0";
                        }
                    } else if (arr[i][j - 1].equals("m")) {
                        if (i - 1 >= 0) {
                            arr[i][j] = arr[i - 1][j];
                        } else {
                            arr[i][j] = "0";
                        }
                    } else {
                        arr[i][j] = String.valueOf(Integer.parseInt(arr[i - 1][j]) + Integer.parseInt(arr[i][j - 1]));
//                        System.out.print(arr[i][j] + " ");
                    }
                }

            }
        }

        System.out.println("after");
        for (int i = 0; i < N; i++) {//O(n)
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(arr[N-1][N-1] + " ways");
    }

    public static HashMap<Integer, Coordinates> createMeteorsSquad(Integer count) {//O(n)
        HashMap<Integer, Coordinates> meteors = new HashMap<>();//O(1)

        for (int i = 0; i < count; i++) {//O(n)
            //x and y range{1;10}
            int x = (int) Math.floor(Math.random() * (4));//O(1)
            int y = (int) Math.floor(Math.random() * (4));//O(1)//3
            Coordinates coordinates = new Coordinates(x, y);//O(1)

            meteors.put(i, coordinates);//O(1)
            System.out.println("meteor " + (i + 1) + " on (" + meteors.get(i).getX() + ";" + meteors.get(i).getY() + ")");//O(1)
        }
        return meteors;//O(1)
    }

}
