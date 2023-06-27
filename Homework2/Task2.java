/*
Если необходимо, исправьте данный код:

try {
   int d = 0;
   double catchedRes1 = intArray[8] / d;
   System.out.println("catchedRes1 = " + catchedRes1);
} catch (ArithmeticException e) {
   System.out.println("Catching exception: " + e);
}

Концепция такая:
    1) мы создаем массив случайных целых чисел;
    2) Делим каждый элемент массива на случайное число в диапозоне от 0 до 2 и
    выводим результат деления.
    ! Если происходит деление на 0, вылетает ArithmeticException, но программа продолжает работу.

*/

import java.util.Random;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args){
        Random r = new Random();
        int[] intArray = fillingArray("Введите размер массива: ");
        for(int i = 0; i < intArray.length; i++) {
            try {
                int d = r.nextInt(0,2);
                double catchedRes = intArray[i] / d;
                System.out.println("catchedRes " + (i+1) + " = " + catchedRes);
            } catch (ArithmeticException e) {
                System.out.println("Catching exception: " + e);
            }
        }
    }

    public static int[] fillingArray(String message) {
        Random rand = new Random();
        int[] array = new int[getInteger(message)];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(0, 50);
        }
        return array;
    }

    private static int getInteger(String message){
        boolean mark = true;
        System.out.println(message);
        Scanner in = new Scanner(System.in);
        while(mark) {
            try {
                int number = in.nextInt();

                return number;
            } catch(Exception e){
                System.out.println("Вы ввели не число, попробуйте еще");
                return getInteger(message);
            }
        }
        return 0;
    }
}
