import java.util.Scanner;

/*
    Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
    и возвращает введенное значение.
    Ввод текста вместо числа не должно приводить к падению приложения, вместо этого,
    необходимо повторно запросить у пользователя ввод данных.
 */
public class Task1 {
    public static void main(String[] args){
        System.out.println("Вы ввели число: " + getFloat("Введите дробное число(через ','): "));
    }

    static float getFloat(String message){
        System.out.println(message);
        while(true){
            try{
                Scanner s = new Scanner(System.in);
                float num = s.nextFloat();
                s.close();
                return num;
            }
            catch(Exception e){
                System.out.println("Вы некорректно ввели данные, попробуйте еще раз");
            }
        }
    }
}
