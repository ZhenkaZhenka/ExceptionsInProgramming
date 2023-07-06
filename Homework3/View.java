import java.io.IOException;
import java.util.Scanner;

public class View {
    public static void start(){
        boolean mark = true;
        while(mark){
            process();
            String sign = getString("Would you like to try again? If yes, input '+'." );
            if(sign.equals('+')){
                mark = false;
                System.out.println("Have a good day!");
            }
        }
    }
    private static void process(){
        try{
            Controller c = new Controller();
            c.noteToFile(c.getNote(c.getArray()));
            System.out.println("Input succeed!");
        } catch (IOException e){
            System.out.println("IOException" + e.getMessage());
        } catch (NumberFormatException e){
            System.out.println("NumberFormatException" + e.getMessage());
        } catch (RuntimeException e){
            System.out.println("RuntimeException" + e.getMessage());
        }
    }
    private static String getString(String message){
        Scanner in = new Scanner(System.in);
        System.out.println(message);
        String string = in.nextLine();
        return string;
    }
}
