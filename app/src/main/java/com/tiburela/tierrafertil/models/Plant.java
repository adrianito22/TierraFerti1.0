package com.tiburela.tierrafertil.models;

import java.util.HashMap;

public class Plant {

    private String uniqueIdPlantAndKeyShare;
    private String idIinformFatherRelacionado;
    boolean itemLayoutIsVisible;


    public boolean isItemLayoutIsVisible() {
        return itemLayoutIsVisible;
    }

    public void setItemLayoutIsVisible(boolean itemLayoutIsVisible) {
        this.itemLayoutIsVisible = itemLayoutIsVisible;
    }

    public Plant(String idIinformFatherRelacionado, String nameItem, HashMap<String, String> hashMapCategiresMapsEvaluadas, boolean itemLayoutIsVisible) {

        uniqueIdPlantAndKeyShare = java.util.UUID.randomUUID().toString();
        this.idIinformFatherRelacionado = idIinformFatherRelacionado;
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




    public String getUniqueIdPlantAndKeyShare() {
        return uniqueIdPlantAndKeyShare;
    }

    public void setUniqueIdPlantAndKeyShare(String uniqueIdPlantAndKeyShare) {
        this.uniqueIdPlantAndKeyShare = uniqueIdPlantAndKeyShare;
    }

    public String getIdIinformFatherRelacionado() {
        return idIinformFatherRelacionado;
    }

    public void setIdIinformFatherRelacionado(String idIinformFatherRelacionado) {
        this.idIinformFatherRelacionado = idIinformFatherRelacionado;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }



}
