package com.tiburela.tierrafertil.models;

public class ResultCaldLabAgricls {


    public String getItemCalificadoName() {
        return itemCalificadoName;
    }

    public void setItemCalificadoName(String itemCalificadoName) {
        this.itemCalificadoName = itemCalificadoName;
    }

    public int getUnmPlantasCalificadas() {
        return unmPlantasCalificadas;
    }

    public void setUnmPlantasCalificadas(int unmPlantasCalificadas) {
        this.unmPlantasCalificadas = unmPlantasCalificadas;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    private String itemCalificadoName;
    private int unmPlantasCalificadas;
    private float promedio ;

    public boolean isTitle() {
        return isTitle;
    }

    public void setTitle(boolean title) {
        isTitle = title;
    }

    private  boolean isTitle;




    public ResultCaldLabAgricls(String itemCalificadoName, int unmPlantasCalificadas, float promedio,boolean isTitle) {
        this.itemCalificadoName = itemCalificadoName;
        this.unmPlantasCalificadas = unmPlantasCalificadas;
        this.promedio = promedio;
        this. isTitle=isTitle;
    }



}
