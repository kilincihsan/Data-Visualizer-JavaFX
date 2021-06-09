package sample;

import javafx.fxml.FXML;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.io.File;
import java.io.IOException;



public class LineChart extends Chart {

    public LineChart(String title, String xAxisLabel) {
        super(title, xAxisLabel);
    }

    /*
    @FXML
    private static javafx.scene.chart.LineChart<String, Number> lineChart;


    public static void generateLineChart() throws IOException {


        XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
        series.getData().add(new XYChart.Data<String, Number>("Dec",213));
        series.getData().add(new XYChart.Data<String, Number>("jan",214));
        series.getData().add(new XYChart.Data<String, Number>("feb",215));
        series.getData().add(new XYChart.Data<String, Number>("mar",216));
        series.getData().add(new XYChart.Data<String, Number>("jan",217));
        series.setName("No of cases");

        lineChart.getData().add(series);

    }


 */
}