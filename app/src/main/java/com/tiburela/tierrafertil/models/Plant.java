package com.tiburela.tierrafertil.models;

import java.util.HashMap;

public class Plant {

    private String uniqueIdPlant;
    private String  informeRelacionado;
    boolean itemLayoutIsVisible;


    public boolean isItemLayoutIsVisible() {
        return itemLayoutIsVisible;
    }

    public void setItemLayoutIsVisible(boolean itemLayoutIsVisible) {
        this.itemLayoutIsVisible = itemLayoutIsVisible;
    }

    public Plant(String uniqueIdPlant, String informeRelacionado, String nameItem, HashMap<String, String> hashMapCategiresMapsEvaluadas, boolean itemLayoutIsVisible) {
        this.uniqueIdPlant = uniqueIdPlant;
        this.informeRelacionado = informeRelacionado;
        this.nameItem = nameItem;
        this.hashMapCategiresMapsEvaluadas = hashMapCategiresMapsEvaluadas;
        this.itemLayoutIsVisible=itemLayoutIsVisible;
    }



    private String nameItem;
    private HashMap<String,String > hashMapCategiresMapsEvaluadas= new HashMap<>();


    public HashMap<String, String> getHashMapCategiresMapsEvaluadas() {
        return hashMapCategiresMapsEvaluadas;
    }

    public void setHashMapCategiresMapsEvaluadas(HashMap<String, String> hashMapCategiresMapsEvaluadas) {
        this.hashMapCategiresMapsEvaluadas = hashMapCategiresMapsEvaluadas;
    }




    public String getUniqueIdPlant() {
        return uniqueIdPlant;
    }

    public void setUniqueIdPlant(String uniqueIdPlant) {
        this.uniqueIdPlant = uniqueIdPlant;
    }

    public String getInformeRelacionado() {
        return informeRelacionado;
    }

    public void setInformeRelacionado(String informeRelacionado) {
        this.informeRelacionado = informeRelacionado;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }



}
