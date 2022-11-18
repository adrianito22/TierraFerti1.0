package com.tiburela.tierrafertil.models;

public class AllFormsModel {

   private  String uniqueIDkeyInformAndKeYSharePref;

    public String getUniqueIDkeyInformAndKeYSharePref() {
        return uniqueIDkeyInformAndKeYSharePref;
    }

    public void setUniqueIDkeyInformAndKeYSharePref(String uniqueIDkeyInformAndKeYSharePref) {
        this.uniqueIDkeyInformAndKeYSharePref = uniqueIDkeyInformAndKeYSharePref;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getDatelastModification() {
        return datelastModification;
    }

    public void setDatelastModification(String datelastModification) {
        this.datelastModification = datelastModification;
    }

    public int getTipoFormPertenece() {
        return tipoFormPertenece;
    }

    public void setTipoFormPertenece(int tipoFormPertenece) {
        this.tipoFormPertenece = tipoFormPertenece;
    }

    private String name;
    private String dateCreate;
    private String datelastModification;
    private int tipoFormPertenece;

    public AllFormsModel(String uniqueIDkeyInformAndKeYSharePref, String name, String dateCreate, String datelastModification, int tipoFormPertenece) {
        this.uniqueIDkeyInformAndKeYSharePref = uniqueIDkeyInformAndKeYSharePref;
        this.name = name;
        this.dateCreate = dateCreate;
        this.datelastModification = datelastModification;
        this.tipoFormPertenece = tipoFormPertenece;
    }





}
