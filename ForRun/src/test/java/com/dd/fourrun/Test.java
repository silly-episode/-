package com.dd.fourrun;
import java.util.Random;

public class Test {


    @org.junit.jupiter.api.Test
    public void random() {

        Random random = new Random();
        boolean[] bool = new boolean[14];
        int randInt = 0;
        int[] intArray =new int[9];
        for (int j = 0; j < 9; j++) {
            /**得到9个不同的随机数*/
            do {
                randInt = random.nextInt(14);
            } while (!bool[randInt]);
            bool[randInt] = true;
        }



    }


    @org.junit.jupiter.api.Test
    public void jude() {
        boolean[] bool = new boolean[20];
        for (boolean b : bool) {
            System.out.println(b);
        }


    }
}