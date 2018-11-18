package org.avlasov.messenger;

import java.util.Arrays;

/**
 * Created By artemvlasov on 30/07/2017
 **/
public class Test {

    public static void main(String[] args) {
        String[][] arr = {{"1","2"}, {"2","1"}};
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println(arr[i][j] + " ");
            }

        }
        System.out.printf(arr[0][0] + arr[0][1] + arr[1][0] + arr[1][1]);
    }

}
