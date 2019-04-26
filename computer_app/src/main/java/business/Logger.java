package business;

import java.io.*;
import java.time.LocalDateTime;

public class Logger {

    private BufferedWriter writer;

    public Logger(String filename){
        try {
            writer = new BufferedWriter(new FileWriter(filename,true));
        } catch(IOException e) {
            System.out.println("File does not exist");
        }
    }

    public void writeToLog(String message){
        try {
            writer.append(LocalDateTime.now().toString()+" - "+message);
        }catch(IOException e){
            e.printStackTrace();
        }
    }


}
