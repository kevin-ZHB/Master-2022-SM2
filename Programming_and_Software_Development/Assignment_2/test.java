

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class test {

    public static void main(String[] args) {
        Scanner inputStream = null;

        try{
            inputStream = new Scanner(new FileInputStream("player.dat"));
        } catch (FileNotFoundException e){
            System.err.println("Can not found");
        }
       

        

    }
}
