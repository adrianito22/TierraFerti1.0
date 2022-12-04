package com.tiburela.tierrafertil.Calendario;

import java.util.UUID;

public class CalendarioEnf {

    private  int semanaNum;
    private  int colorCinta;
    private String date;
    private String uniqueId;

    private int vuelta1;
    private int vuelta2;


    //cintas cortadas
    private int sem9;
    private int sem10;
    private int sem11;
    private int sem12;
    private int sem13;
    private int enfuTotalSemnas;


    //otros datos

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public int getVuelta1() {
        return vuelta1;
    }

    public void setVuelta1(int vuelta1) {
        this.vuelta1 = vuelta1;
    }

    public int getVuelta2() {
        return vuelta2;
    }

    public void setVuelta2(int vuelta2) {
        this.vuelta2 = vuelta2;
    }

    public int getSem9() {
        return sem9;
    }

    public void setSem9(int sem9) {
        this.sem9 = sem9;
    }

    public int getSem10() {
        return sem10;
    }

    public void setSem10(int sem10) {
        this.sem10 = sem10;
    }

    public int getSem11() {
        return sem11;
    }

    public void setSem11(int sem11) {
        this.sem11 = sem11;
    }

    public int getSem12() {
        return sem12;
    }

    public void setSem12(int sem12) {
        this.sem12 = sem12;
    }

    public int getSem13() {
        return sem13;
    }

    public void setSem13(int sem13) {
        this.sem13 = sem13;
    }

    public int getEnfuTotalSemnas() {
        return enfuTotalSemnas;
    }

    public void setEnfuTotalSemnas(int enfuTotalSemnas) {
        this.enfuTotalSemnas = enfuTotalSemnas;
    }

    public int getRacimosCortados() {
        return racimosCortados;
    }

    public void setRacimosCortados(int racimosCortados) {
        this.racimosCortados = racimosCortados;
    }

    public int getRacimosRechazados() {
        return racimosRechazados;
    }

    public void setRacimosRechazados(int racimosRechazados) {
        this.racimosRechazados = racimosRechazados;
    }

    public int getTotalCajas() {
        return totalCajas;
    }

    public void setTotalCajas(int totalCajas) {
        this.totalCajas = totalCajas;
    }

    public int getPerctenMerma() {
        return perctenMerma;
    }

    public void setPerctenMerma(int perctenMerma) {
        this.perctenMerma = perctenMerma;
    }

    public float getRatio() {
        return ratio;
    }

    public void setRatio(float ratio) {
        this.ratio = ratio;
    }

    private int racimosCortados;
    private int racimosRechazados;
    private int totalCajas;
    private int perctenMerma;
    private float ratio;








    public String getColorCintaString() {
        return colorCintaString;
    }

    public void setColorCintaString(String colorCintaString) {
        this.colorCintaString = colorCintaString;
    }

    private String colorCintaString;

    public int getSemanaNum() {
        return semanaNum;
    }

    public void setSemanaNum(int semanaNum) {
        this.semanaNum = semanaNum;
    }

    public int getColorCinta() {
        return colorCinta;
    }

    public void setColorCinta(int colorCinta) {
        this.colorCinta = colorCinta;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



    /**rivate int sem9;
     private int sem10;
     private int sem11;
     private int sem12;
     private int sem13;
     private int enfuTotalSemnas;


     //otros datos

     private int racimosCortados;
     private int racimosRechazados;
     private int totalCajas;
     private int perctenMerma;
     private float ratio;**/



    public CalendarioEnf(int semanaNum, int colorCinta, String date,String colorCintaString) {
        this.semanaNum = semanaNum;
        this.colorCinta = colorCinta;
        this.date = date;
        this.colorCintaString=colorCintaString;
        uniqueId= UUID.randomUUID().toString();

           sem9=0;
           sem10=0;
           sem11=0;
           sem12=0;
           sem13=0;
           enfuTotalSemnas=0;

           racimosCortados=0;
           racimosRechazados=0;
           totalCajas=0;
           perctenMerma=0;
           ratio=0;


    }



}
