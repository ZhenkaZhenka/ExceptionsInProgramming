import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Controller {
    private String getString(String message){
        Scanner in = new Scanner(System.in);
        System.out.println(message);
        String string = in.nextLine();
        return string;
    }

    public String[] getArray(){
        return getString("Input data of the person in format:" +
                "Surname Name Patronymic PhoneNumber(without '+')").split(" ");
    }
    public Note getNote(String[] ar){
        if(ar.length != 4){
            throw new RuntimeException("Input data is not correct");
        }
        return new Note(ar[0], ar[1], ar[2], Long.parseLong(ar[3]));
    }

    public static void noteToFile(Note note) throws IOException {
        String file = note.getLastname()+".txt";
        File f = new File(file);
        FileWriter fr = new FileWriter(f, true);
        if(f.exists()) {
            fr.write('<' + note.getLastname() + '>'  + '<' + note.getName() + '>'
                    + '<' + note.getPatronymic() + '>' + '<' +  note.getPhone() + '>' + "\n");
        } else {

            fr.append('<' + note.getLastname() + '>'  + '<' + note.getName() + '>'
                    + '<' + note.getPatronymic() + '>' + '<' +  note.getPhone() + '>' + "\n");
        }
        fr.close();
    }
}
