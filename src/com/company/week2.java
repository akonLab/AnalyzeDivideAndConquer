package com.company;

import java.util.*;

public class week2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);//O(1)
        int numInLine = in.nextInt();//O(1)
        HashMap<List<Integer>, Boolean> line = new HashMap<>();//O(1)

        //count permutation {numInLine!}
        int permutationNum = 1;//O(1)
        for (int i = 1; i <= numInLine; i++) {//O(n)
            permutationNum *= i;
        }

        //fill hashamp with int arr and boolean that will said is line in asc order
        List<Integer> lineNum = new ArrayList<>();//O(1)
        for (int i = 0; i < permutationNum; i++) {//O(2n)
            for (int j = 0; j < numInLine; j++) {//O(n)
                lineNum.add((int) (0 + Math.random() * 10));//O(1)
            }
            line.put(lineNum, isAscendingOrder(lineNum, numInLine));//O(n)
            lineNum = new ArrayList<>();//O(1)
        }

        ArrayList<List<Integer>> trueArr = isBoolean(line, true);
        ArrayList<List<Integer>> falseArr = isBoolean(line, false);
        int count = 1;//line counter

        for (List<Integer> nums : line.keySet()) {//O(n)
            if (trueArr.size() > 0 && count % 2 != 0) {//O(1)
                System.out.println(trueArr.get(0) + " " + true);//O(1)
                trueArr.remove(0);//O(1)
            } else if (falseArr.isEmpty()) {//O(1)
                System.out.println(trueArr.get(0) + " " + true);//O(1)
                trueArr.remove(0);//O(1)
            } else {//O(1)
                System.out.println(falseArr.get(0) + " " + false);//O(1)
                falseArr.remove(0);//O(1)
            }
            count++;//O(1)
        }

    }

    static ArrayList<List<Integer>> isBoolean(HashMap<List<Integer>, Boolean> nums, Boolean type) {//O(n)
        ArrayList<List<Integer>> arr = new ArrayList<>();//O(1)

        for (List<Integer> num : nums.keySet()) {//O(n)
            if (nums.get(num) == type) {//O(1)
                arr.add(num);
            }
        }

        return arr;
    }

    static Boolean isAscendingOrder(List<Integer> line, Integer size) {//O(n)
        int count = 0;//O(1)
        while (count < size - 1) {//O(n)
            Integer previous = line.get(count);//O(1)

            if (previous > line.get(count + 1)) {//O(1)
                return false;
            }
            count++;//O(1)
        }
        return true;
    }
}
