package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Controller {

    @FXML
    public Button AnimatedPieChartButton;
    @FXML
    public Button browseTXT;
    @FXML
    private Button browseButton;
    @FXML
    private Button lineChartButton;
    @FXML
    private Button barChartButton;
    @FXML
    private Button pieChartButton;
    @FXML
    private Button settingsButton;
    @FXML
    private ListView listView;
    @FXML
    private LineChart<String,Number> lineChart;
    @FXML
    private Button AnimatedBarChartButton;
    @FXML
    private Button AnimatedLineChartButton;
    private static File selectedFile;

    public void browseButtonAction(ActionEvent event){
        FileChooser fc = new FileChooser();
        selectedFile = fc.showOpenDialog(null);

        if(selectedFile!=null){
            listView.getItems().add(selectedFile.getAbsolutePath());
            System.out.println(selectedFile.getAbsolutePath());
        }
        else {
            System.out.println("File is not valid.");
            //"src/res/country_populations.xml"
        }

    }

    public void browseTXT(ActionEvent event){
        FileChooser fc = new FileChooser();
        selectedFile = fc.showOpenDialog(null);

        if(selectedFile!=null){
            listView.getItems().add(selectedFile.getAbsolutePath());
            System.out.println(selectedFile.getAbsolutePath());
        }
        else {
            System.out.println("File is not valid. txt");
            //"src/res/country_populations.xml"
        }

    }
    public static String getFilePath(){
        return selectedFile.getAbsolutePath();
    }

    public void lineChartButtonAction(ActionEvent event) throws IOException {
        if(selectedFile==null){
            selectedFile=new File("country_populations.xml");
            new Alert(Alert.AlertType.ERROR,"You didnt choose any filepath. Filepath set to default file!").showAndWait();
        }
        else {
            Main n = new Main();
            Stage a = new Stage();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("LineChart.fxml")));
            a.setTitle("Line Chart");
            a.setScene(new Scene(root, 1366, 714));
            a.setResizable(false);
            a.show();
            a.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/res/bird-icon.png"))));
        }
    }
    public void barChartButtonAction(ActionEvent event) throws IOException {
        if(selectedFile==null){
            selectedFile=new File("country_populations.xml");
            new Alert(Alert.AlertType.ERROR,"You didnt choose any filepath. Filepath set to default file!").showAndWait();
        }
        else {
            Main n = new Main();
            Stage a = new Stage();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("BarChart.fxml")));
            a.setTitle("Bar Chart");
            a.setScene(new Scene(root, 1366, 714));
            a.setResizable(false);
            a.show();
            a.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/res/bird-icon.png"))));
        }
    }
    public void pieChartButtonAction(ActionEvent event) throws IOException {
        if(selectedFile==null){
            selectedFile=new File("country_populations.xml");
            new Alert(Alert.AlertType.ERROR,"You didnt choose any filepath. Filepath set to default file!").showAndWait();
        }
        else {
            Main n = new Main();
            Stage a = new Stage();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("PieChart.fxml")));
            a.setTitle("Pie Chart");
            a.setScene(new Scene(root, 881, 774));
            a.setResizable(false);
            a.show();
            a.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/res/bird-icon.png"))));
        }
    }
    public void animatedPieChartButtonAction(ActionEvent event) throws IOException {
        if(selectedFile==null){
            selectedFile=new File("country_populations.xml");
            new Alert(Alert.AlertType.ERROR,"You didnt choose any filepath. Filepath set to default file!").showAndWait();
        }
        else {
            Main n = new Main();
            Stage a = new Stage();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AnimatedPieChart.fxml")));
            a.setTitle("Animated Pie Chart");
            a.setScene(new Scene(root, 881, 774));
            a.setResizable(false);
            a.show();
            a.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/res/bird-icon.png"))));
        }
    }
    public void settingsButtonAction(ActionEvent event) throws IOException {
        Main m = new Main();
        m.newScene("deneme","Settings.fxml");

    }
    public void animatedBarChartButtonAction(ActionEvent event) throws IOException {
        if(selectedFile==null){
            selectedFile=new File("country_populations.xml");
            new Alert(Alert.AlertType.ERROR,"You didnt choose any filepath. Filepath set to default file!").showAndWait();
        }
        else{
            Main n = new Main();
            Stage a = new Stage();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AnimatedBarChart.fxml")));
            a.setTitle("Animated Bar Chart");
            a.setScene(new Scene(root, 1366, 714));
            a.setResizable(false);
            a.show();
            a.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/res/bird-icon.png"))));
        }
    }
    public void animatedLineChartButtonAction(ActionEvent event) throws IOException {
        if(selectedFile==null){
            selectedFile=new File("country_populations.xml");
            new Alert(Alert.AlertType.ERROR,"You didnt choose any filepath. Filepath set to default file!").showAndWait();
        }
        else{
            Main n = new Main();
            Stage a = new Stage();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AnimatedLineChart.fxml")));
            a.setTitle("Animated Line Chart");
            a.setScene(new Scene(root, 1366, 714));
            a.setResizable(false);
            a.show();
            a.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/res/bird-icon.png"))));
        }

    }




}
