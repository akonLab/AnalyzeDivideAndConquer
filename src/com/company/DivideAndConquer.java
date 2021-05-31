package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Variance {
    public Integer enterId;
    public Integer exitId;
    public Integer countBetween;

    public Variance() {
    }

    public Variance(Integer enterId, Integer exitId, Integer countBetween) {
        this.enterId = enterId;
        this.exitId = exitId;
        this.countBetween = countBetween;
    }

    public Integer getEnterId() {
        return enterId;
    }

    public Integer getExitId() {
        return exitId;
    }

    public Integer getCountBetween() {
        return countBetween;
    }


    public void findMaxSumOfRude() {

    }

    @Override
    public String toString() {
        return "Variance{" +
                "enterId=" + enterId +
                ", exitId=" + exitId +
                ", countBetween=" + countBetween +
                '}';
    }
}

public class DivideAndConquer {
    static int N;
    static int min = 0;
    static int max = 5;
    static int[] arr;
    static ArrayList<Variance> variances = new ArrayList<>();
    static HashMap<Integer, Variance> varianceHashMap = new HashMap<>();

    public static int[] getArr() {
        return arr;
    }

    static public void findMaxSumOfRude() {

        for (Variance variance : variances) {
            int sum = 0;

            Math.max(arr[variance.enterId], arr[variance.exitId]);
            for (int i = variance.enterId; i < variance.exitId; i++) {
                sum += arr[i] - Math.max(arr[variance.enterId], arr[variance.exitId]);
            }

            System.out.println(variance.toString());
            System.out.println("sum: " + sum);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        N = in.nextInt();
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = (int) (min + Math.random() * max);
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        findDistance(0);

//        for (Variance variance : variances) {
//            System.out.println(variance.toString());
//        }

        System.out.println();
        findMaxSumOfRude();
    }

    static boolean findDistance(int fromId) {
        int start = arr[fromId];
        int end;
        int count = 0;

        for (int i = fromId + 1; i < N; i++) {

            if (arr[i] <= start) {
                end = arr[i];
                if (count > 0) {
                    variances.add(new Variance(fromId, i, count));
                    System.out.println("start " + start + " fromId " + fromId);
                    System.out.println("  end " + end + " endId " + i + ", count " + count);
                }

                findDistance(i);
                return false;
            } else {
                if (i == N - 1) {
                    if (count > 0) {
                        variances.add(new Variance(fromId, N - 1, count));
                        System.out.println("start " + start + " fromId " + fromId);
                        System.out.println("  end " + arr[N - 1] + " endId " + (N - 1) + ", count " + count);
                    }
                    break;
                }
                count++;
            }
        }
        return true;
    }
}
