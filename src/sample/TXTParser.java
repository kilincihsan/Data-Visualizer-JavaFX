package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TXTParser {
    public static int count;

    @FXML
    public TextArea txtArea;
    @FXML
    public Button generateButton;

    public static String[][] parsedData;

    public static String[][] parseTXT(String file) {

        count=0;

        try {
            Scanner scanner = new Scanner(new File(file));
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine()+count);
                count++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //System.out.println(count);

        String[][] arrayTXT = new String[count][5];
        //arrayTXT[count-1][4]="s";
        //System.out.println(arrayTXT[count-1][4]);
        try {
            Scanner scanner = new Scanner(new File(file));
            while (scanner.hasNextLine()) {
                //System.out.println(scanner.nextLine());
                for(int i=0;i<count;i++){
                    String[] line = scanner.nextLine().trim().split(",|\\n");
                    for(int j=0;j<line.length;j++){
                        arrayTXT[i][j]=line[j];
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        parsedData= new String[count][5];

        for(int i=0;i<count;i++) {
            for(int j=0;j<5;j++){
                if (arrayTXT[i][1]==null){
                    continue;
                }
                else{
                    //System.out.println(arrayTXT[i][j]);
                    parsedData[i][j]=arrayTXT[i][j];
                }
            }
        }

        return parsedData;
    }

    public void generateButtonAction(ActionEvent event) {
        String datalar[][] = parsedData;
        for(int i=0;i<count;i++){
            for(int j=0;j<5;j++){
                if(datalar[i][2]=="Tokyo"){
                    System.out.println(datalar[i][1]);
                }

            }
        }
    }
}
