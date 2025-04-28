package Module3;

import java.io.*;

public class MyIOFile {

    public void inputFile() throws IOException{

        try(FileWriter writer = new FileWriter("notes3.txt", false))
        {
            // запись всей строки
            String text = "Hello Gold!";
            writer.write(text);
            // запись по символам
            writer.append('\n');
            writer.append('E');

            writer.flush();
        }
        catch(MyException myException){

            System.out.println(myException.getMessage());
        }
    }

    public void outputFile() throws IOException {
        try(FileReader reader = new FileReader("notes3.txt"))
        {
            // читаем посимвольно
            int c;
            while((c=reader.read())!=-1){

                System.out.print((char)c);
            }
        }
        catch(MyException | FileNotFoundException myException){

            System.out.println(myException.getMessage());
        }
    }
}