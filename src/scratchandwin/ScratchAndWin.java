/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scratchandwin;

import java.util.Scanner;

/**
 *
 * @author zhuan
 */
public class ScratchAndWin {

    static Scanner sc = new Scanner(System.in);
    static int[] scratchedCount = new int[10];
    static int[] amounts = {1, 2, 5, 10, 50, 100, 1000, 10000, 500000, 1000000};

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        for (int i = 0; i < 2; i++) {
            playOneCard();
        }
    }

    private static void playOneCard() {
        for (int i=0;i<10;i++) scratchedCount[i]=0;
        int unscratchedCount = 0;
        for (int i = 0; i < 9; i++) {
            String line = sc.nextLine();
            if (!line.equals("?")) {
                int amount=Integer.parseInt(line.substring(1));
                scratchedCount[fromAmount2Index(amount)]++;
            } else {
                unscratchedCount++;
            }
        }

        for (int i = 0; i < 10; i++) {
            if (scratchedCount[i] >= 3) {
                System.out.println("$"+fromIndex2Amount(i));
                return;
            }
        }
        if (unscratchedCount >= 3) {
            printAllAmounts();
            return;
        }
        boolean first = true;
        boolean hasPossiblePrizes = false;
        for (int i = 0; i < 10; i++) {
            if (scratchedCount[i] == 1 && unscratchedCount >= 2
                    || scratchedCount[i] == 2 && unscratchedCount >= 1) {
                hasPossiblePrizes = true;
                if (first) {
                    first = false;
                } else {
                    System.out.print(" ");
                }
                System.out.print("$"+fromIndex2Amount(i));
            }
        }
        if (!hasPossiblePrizes) {
            System.out.print("No Prizes Possible");
        }
        System.out.println();
    }

    private static int fromAmount2Index(int amount) {
        for (int i = 0; i < 10; i++) {
            if (amount==amounts[i]) {
                return i;
            }
        }
        return -1;
    }

    private static void printAllAmounts() {
        for (int i = 0; i < 10; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print("$"+amounts[i]);
        }
        System.out.println();
    }

    private static int fromIndex2Amount(int i) {
        return amounts[i];
    }

}
