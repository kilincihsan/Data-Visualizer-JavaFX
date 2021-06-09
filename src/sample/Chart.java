package sample;

public abstract class Chart {
    private String title;
    private String xAxisLabel;
    private String yAxisLabel;
    private int width;
    private int height;

    public Chart(String title, String xAxisLabel){}
    // Sets the caption of this chart.
    public void setCaption(String caption){}
    // Removes all of the records from this chart.
    public void reset(){}
    //Feel free to add other necessary method


    public String getTitle() {
        return title;
    }

    public String getxAxisLabel() {
        return xAxisLabel;
    }

    public String getyAxisLabel() {
        return yAxisLabel;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setxAxisLabel(String xAxisLabel) {
        this.xAxisLabel = xAxisLabel;
    }

    public void setyAxisLabel(String yAxisLabel) {
        this.yAxisLabel = yAxisLabel;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
