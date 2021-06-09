package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class AnimatedPieChart {
    public Button buttonGeneratePieChart;
    public PieChart pieChart;

    public String[][] datalar;
    public int count;
    public ArrayList<String> categories;
    public Button buttonStart;
    public TimerTask timerTask;
    public Button buttonStop;

    public void generatePieChartLoad(ActionEvent event) throws IOException, SAXException, ParserConfigurationException {
        buttonStart.setDisable(false);
        ObservableList<PieChart.Data> list = FXCollections.observableArrayList();
        pieChart.getData().clear();
        datalar = DomParser.parseFile();
        count = 0;
        categories = new ArrayList<>();
        for (int i = 0; i < datalar.length; i++) { //this equals to the row in our matrix.
            for (int j = 0; j < 5; j++) { //this equals to the column in each row.
                if(!(datalar[i][0].equals(datalar[i+1][0]))){
                    categories.add(datalar[i][0]);
                    break;
                }
            }
            count++;
            if(datalar[i+1][0]==null){
                break;
            }
        }


        int x=0;
        int y=0;
        count=count-59;
        for (int i = 0; i < categories.size(); i++) { //this equals to the row in our matrix.
            y+=60;
            while(x<=count && x<y) {
                if(datalar[x][2].equals(datalar[count-1][2])) {
                    list.add(new PieChart.Data(datalar[x][0]+" > "+datalar[x][3], Integer.valueOf(datalar[x][3])));
                    pieChart.setTitle(datalar[count-1][2]);
                }
                //System.out.print("x:"+x+" y:"+y+" ");
                x++;
            }
            System.out.println();
        }

        pieChart.setData(list);
    }

    public void generatePieChartStart(ActionEvent event) throws IOException, SAXException, ParserConfigurationException {
        pieChart.setAnimated(false);
        buttonStart.setDisable(false);
        timerTask=new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {

                        ObservableList<PieChart.Data> list = FXCollections.observableArrayList();
                        pieChart.getData().clear();
                        count++;
                        int x = 0;
                        int y = 0;

                        for (int i = 0; i < categories.size(); i++) { //this equals to the row in our matrix.
                            y += 60;
                            while (x <= count && x < y) {
                                if (datalar[x][2].equals(datalar[count - 1][2])) {
                                    list.add(new PieChart.Data(datalar[x][0] + " > " + datalar[x][3], Integer.valueOf(datalar[x][3])));
                                    pieChart.setTitle(datalar[count - 1][2]);
                                }
                                else if(datalar[count-1][2].equalsIgnoreCase("2019")){
                                    timerTask.cancel();
                                }
                                System.out.print("x:"+x+" y:"+y+" ");
                                x++;
                            }
                        }
                        pieChart.setData(list);


                    }
                });
            }
        };

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 0, 200);

    }

    public void stop(ActionEvent event) throws IOException, SAXException, ParserConfigurationException {
        timerTask.cancel();
    }

}
