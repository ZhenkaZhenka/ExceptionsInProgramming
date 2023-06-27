import java.util.Scanner;

/*
  Разработайте программу, которая выбросит Exception,
  когда пользователь вводит пустую строку.
  Пользователю должно показаться сообщение, что пустые строки вводить нельзя.*/
public class Task4 {
    public static void main(String[] args) throws Exception {
        String str = getString("Введите сообщение: ");
        if (str == ""){
            throw new Exception("Надо что-нибудь ввести, нельзя оставлять строку пустой.");
        } else{
            System.out.println("Вы ввели: " + str);
        }
    }
    private static String getString(String message){
        Scanner in = new Scanner(System.in);
        System.out.println(message);
        String string = in.nextLine();
        return string;
    }
}
