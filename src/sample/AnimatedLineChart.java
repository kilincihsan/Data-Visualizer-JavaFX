package sample;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Stream;


public class AnimatedLineChart {

    public Button buttonGenerateLineChart;
    public LineChart<String,Number> lineChart;
    public Label xAxisLabel;
    public Label yAxisLabel;
    public String[][] datalar;
    public int count;
    public ArrayList<String> categories;
    public int d=0;
    public TimerTask timerTask;
    public Button buttonClearLineChart;
    public Button stopButton;

    public void generateLineChart(ActionEvent event) throws IOException, SAXException, ParserConfigurationException {
        buttonClearLineChart.setDisable(false);

        datalar = DomParser.parseFile();
        count = 0;
        //settitle
        lineChart.setTitle("Country Populations");
        xAxisLabel.setText(Settings.getLc().getxAxisLabel());
        yAxisLabel.setText(Settings.getLc().getyAxisLabel());
        //clear chart create xychart
        lineChart.getData().clear();
        //XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();
        ArrayList<String> categories = new ArrayList<>();
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
        int x=0;
        int y=0;
        count=count-59;
        for (int i = 0; i < categories.size(); i++) { //this equals to the row in our matrix.
            y+=60;
            while(x<=count && x<y) {
                seriesArray[i].getData().add(new XYChart.Data<String, Number>(datalar[x][2], Integer.valueOf(datalar[x][3])));
                System.out.print("x:"+x+" y:"+y+" ");
                x++;
            }

            System.out.println();

            seriesArray[i].setName(categories.get(i));

        }


        //runnable
        lineChart.setAnimated(false);

        timerTask=new TimerTask() {
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {

                        if(lineChart.getTitle().equalsIgnoreCase("1990")){
                            lineChart.setTitle("2019");
                            timerTask.cancel();
                        }else {
                            XYChart.Series<String, Number>[] seriesArray = Stream.<XYChart.Series<String, Number>>generate(XYChart.Series::new).limit(categories.size()).toArray(XYChart.Series[]::new);
                            int x=0;
                            int y=0;
                            count++;
                            d++;
                            lineChart.getData().clear();
                        for (int i = 0; i < categories.size(); i++) { //this equals to the size
                            y+=60;
                            while(x<=count && x<y) {
                                //if equal 1960,1961+....
                                if (datalar[x][2].equals(datalar[count - 1][2])) {
                                    //year + population
                                    int c=0;
                                    while(c<d) {
                                        seriesArray[i].getData().add(new XYChart.Data<String, Number>(datalar[x+c][2], Integer.valueOf(datalar[x+c][3])));
                                        c++;
                                    }
                                    lineChart.setTitle(datalar[x][2]);

                                }
                                //System.out.print("x:"+x+" y:"+y+" ");
                                x++;
                            }
                            seriesArray[i].setName(categories.get(i));
                            lineChart.getData().add(seriesArray[i]);
                        }
                        }
                    }
                });
            }
        };

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 0, 100);
    }

    public void clearLineChart(ActionEvent event) throws IOException, SAXException, ParserConfigurationException {
        lineChart.getData().clear();
        lineChart.setAnimated(false);
        buttonClearLineChart.setDisable(true);
    }

    public void stop(ActionEvent event) throws IOException, SAXException, ParserConfigurationException {
        timerTask.cancel();
    }
}
