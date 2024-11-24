package com.example.recyclerview;

public class DataClass {

    private String dataTitle;
    private int dataDesc;
    private String dataDescription;
    private int dataImage;


    public String getDataTitle() {
        return dataTitle;
    }

    public int getDataDesc() {
        return dataDesc;
    }

    public String getDataDescription() {
        return dataDescription;
    }

    public int getDataImage() {
        return dataImage;
    }

    public DataClass(String dataTitle, int dataDesc, String dataDescription, int dataImage) {
        this.dataTitle = dataTitle;
        this.dataDesc = dataDesc;
        this.dataDescription = dataDescription;
        this.dataImage = dataImage;
    }
}
