package sample;

import javafx.application.Platform;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Stream;


public class AnimatedBarChart {

    public Button buttonGenerateBarChart;
    public BarChart<String,Number> barChart;
    public Label xAxisLabel;
    public Label yAxisLabel;
    public Button buttonStart;
    public TimerTask timerTask;
    private int count;
    private ArrayList<String> categories;
    private String[][] datalar;
    public Button buttonStop;

    public void generateBarChart(ActionEvent event) throws IOException, SAXException, ParserConfigurationException {

        datalar = DomParser.parseFile();
        count = 0;
        //settitle
        barChart.setTitle(Settings.getBc().getTitle());
        barChart.setAnimated(false);
        barChart.getData().clear();
        xAxisLabel.setText(Settings.getBc().getxAxisLabel());
        yAxisLabel.setText(Settings.getBc().getyAxisLabel());
        //clear chart create xychart
        // lineChart.getData().clear();
        //XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();
        categories = new ArrayList<>();
        for (int i = 0; i < datalar.length; i++) { //this equals to the row in our matrix.
            for (int j = 0; j < 5; j++) { //this equals to the column in each row.

                if(!(datalar[i][0].equals(datalar[i+1][0]))){
                    categories.add(datalar[i][0]);
                    //series.setName(datalar[i][0]);
                    break;
                }
                else{
                    //System.out.print(datalar[i][j]);
                }
            }
            count++;
            if(datalar[i+1][0]==null){
                break;
            }
            //System.out.println(); //change line on console as row comes to end in the matrix.
            //series.getData().add(new XYChart.Data<String,Number>(datalar[i][2],Integer.valueOf(datalar[i][3])));

        }

        //    series.getData().add(new XYChart.Data<String,Number>(datalar[i][2],Integer.valueOf(datalar[i][3])));

        //x years =3 , y pop = 4 [i][3], setname=1-2

        //series.setName("No of cases");
        //lineChart.getData().addAll(series);

        //categories.forEach((n)-> System.out.println(n));


        XYChart.Series<String, Number>[] seriesArray = Stream.<XYChart.Series<String, Number>>generate(XYChart.Series::new).limit(categories.size()).toArray(XYChart.Series[]::new);
        count=count-59;
        int x=0;
        int y=0;
        for (int i = 0; i < categories.size(); i++) { //this equals to the row in our matrix.
            y+=60;
            while(x<=count && x<y) {
                if (datalar[x][2].equals(datalar[count - 1][2])) {
                    seriesArray[i].getData().add(new XYChart.Data<String, Number>(datalar[x][2], Integer.valueOf(datalar[x][3])));
                    //System.out.print("x:"+x+" y:"+y+" ");
                }
                x++;
            }

            System.out.println();

            seriesArray[i].setName(categories.get(i));
            barChart.getData().add(seriesArray[i]);
        }
    }

    public void startAnimatedBarChart(ActionEvent event){
        barChart.setAnimated(false);
        buttonStart.setDisable(false);
        timerTask=new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {

                        XYChart.Series<String, Number>[] seriesArray = Stream.<XYChart.Series<String, Number>>generate(XYChart.Series::new).limit(categories.size()).toArray(XYChart.Series[]::new);
                        int x=0;
                        int y=0;
                        barChart.getData().clear();
                        count++;

                        for (int i = 0; i < categories.size(); i++) { //this equals to the row in our matrix.
                            y+=60;
                            while(x<=count && x<y) {

                                if (datalar[x][2].equals(datalar[count - 1][2])) {
                                    seriesArray[i].getData().add(new XYChart.Data<String, Number>(datalar[x][2], Integer.valueOf(datalar[x][3])));
                                    //System.out.print("x:"+x+" y:"+y+" ");
                                }
                                else if(datalar[count-1][2].equalsIgnoreCase("2019")){
                                    timerTask.cancel();
                                }
                                x++;
                            }

                            System.out.println();

                            seriesArray[i].setName(categories.get(i));
                            barChart.getData().add(seriesArray[i]);
                        }


                    }
                });
            }
        };

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 0, 200);



    }

    public void stop(ActionEvent event){
        timerTask.cancel();
    }
}
