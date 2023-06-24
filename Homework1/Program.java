import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws FileNotFoundException {
        task1();
        task2();
    }
    //  "Раскомментируейте" строки, чтобы увидеть результат
    static void task1(){
        //fileNotFound();
        //System.out.println("результат: " + numberFormatException());
        //nullPointerException();
    }
/*
    В данном методе при вводе названия файла вылетит FileNotFoundException
 */
    static void fileNotFound() throws FileNotFoundException {
        String file = getString("Введите название файла для обработки");
        FileReader fr = new FileReader(file);
    }
/*
    В этом методе выходит NumberFormatException или ArithmeticException.
    В предложенном варианте можно получить 3 варианта:
    1) NumberFormatException - если ввести строку или символ при вводе второго числа
    2) ArithmeticException - если ввести 0 при вводе второго числа
    3) Нормальную работу программы, если при вводе второго числа вы введете целое число >0

 */
    static int numberFormatException(){
        int num1 = getInteger("Введите число 1: ");
        int num2 = Integer.parseInt(getString("Введите текст или целое число: "));
        return num1 / num2;
    }
// Здесь появится NullPointerException
    static void nullPointerException(){
        String str = null;
        System.out.println(str.substring(2));
    }
/*
    2) Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
    и возвращающий новый массив, каждый элемент которого равен
    разности элементов двух входящих массивов в той же ячейке.
    Если длины массивов не равны, необходимо как-то оповестить пользователя.
*/
    static void task2(){
        boolean marker = true;
        while(marker) {
            marker = false;
            int[] ar1 = fillingArray("Введите размер массива 1: ");
            int[] ar2 = fillingArray("Введите размер массива 2: ");
            int[] result = subtractionArrays(ar1, ar2);
            if(result(ar1, ar2, result)){
                marker = true;
            }
        }
    }
/*
    Вывод результата
 */
    private static boolean result(int[] ar1, int[] ar2, int[] res){
        if(res != null) {
            System.out.println("Массив 1: ");
            printArray(ar1);
            System.out.println("Массив 2: ");
            printArray(ar2);
            System.out.println("Результат вычислений: ");
            printArray(res);
        }
        System.out.println("Длины массивов разные");
        System.out.print("Хотите повторить? Введите " + "stop" + ", чтобы остановить работу этой процедуры");
        String mes = getString("");
        if (mes.equals("stop")) {
            return false;
        }
        else{
            return true;
        }
    }
/*
    Операция поэлементного вычитания массивов
*/
    private static int[] subtractionArrays(int[] ar1, int[] ar2){
        if(ar1.length == ar2.length) {
            int[] ar = new int[ar1.length];
            for (int i = 0; i < ar.length; i++) {
                ar[i] = ar1[i] - ar2[i];
            }
            return ar;
        }
        else{
            return null;
        }
    }
/*
    Заполнение случайными числами
*/
    public static int[] fillingArray(String message) {
        Random rand = new Random();
        int[] array = new int[getInteger(message)];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(0, 100);
        }
        return array;
    }
/*
        Печать массива
*/
    public static void printArray(int[] array) {
        for (int item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
    private static String getString(String message){
        Scanner in = new Scanner(System.in);
        System.out.println(message);
        String string = in.nextLine();
        return string;
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