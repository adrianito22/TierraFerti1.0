package com.tiburela.tierrafertil.models;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class AllFormsModel {

   private  String uniqueIDkeyInformAndKeYSharePref;
    private String name;
    private String dateCreate;
    private String categoryText;

    public String getCodigoProductor() {
        return codigoProductor;
    }

    private String codigoProductor;


    public String getExtraDataAllFormUniqIdKey() {
        return extraDataAllFormUniqIdKey;
    }

    private String extraDataAllFormUniqIdKey;


    private String datelastModification;
    private int tipoFormPertenece;
    boolean  formIsUploaded;

    public boolean isFormIsUploaded() {
        return formIsUploaded;
    }

    public void setFormIsUploaded(boolean formIsUploaded) {
        this.formIsUploaded = formIsUploaded;
    }

    public String getNotaInform() {
        return notaInform;
    }

    public void setNotaInform(String notaInform) {
        this.notaInform = notaInform;
    }

    private String notaInform;






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


    public String getCategoryText() {
        return categoryText;
    }

    public void setCategoryText(String categoryText) {
        this.categoryText = categoryText;
    }

    public AllFormsModel(String name, int tipoFormPertenec, String notaInform, String categoryText,String codigoProductor) {
        uniqueIDkeyInformAndKeYSharePref = UUID.randomUUID().toString();
        this.name = name;
        Format formatter = new SimpleDateFormat("dd-MM-yyyy");
        dateCreate = formatter.format(new Date().getTime());
        datelastModification = dateCreate;
        this.tipoFormPertenece = tipoFormPertenec;
        formIsUploaded=false;
        this.notaInform=notaInform;
        this.categoryText =categoryText;
        extraDataAllFormUniqIdKey=UUID.randomUUID().toString();
        this.codigoProductor=codigoProductor;

    }





}
