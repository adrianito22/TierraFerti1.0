package com.tiburela.tierrafertil.models;

public class LaboresAgricolsHelper {

    public LaboresAgricolsHelper(String percenttoShow, String keyOFiTEMAndName, String observacionesItem) {
        PercenttoShow = percenttoShow;
        this.keyOFiTEMAndName = keyOFiTEMAndName;
        this.observacionesItem = observacionesItem;
    }

    private String PercenttoShow;

    public String getPercenttoShow() {
        return PercenttoShow;
    }

    public void setPercenttoShow(String percenttoShow) {
        PercenttoShow = percenttoShow;
    }

    public String getKeyOFiTEMAndName() {
        return keyOFiTEMAndName;
    }

    public void setKeyOFiTEMAndName(String keyOFiTEMAndName) {
        this.keyOFiTEMAndName = keyOFiTEMAndName;
    }

    public String getObservacionesItem() {
        return observacionesItem;
    }

    public void setObservacionesItem(String observacionesItem) {
        this.observacionesItem = observacionesItem;
    }

    private String keyOFiTEMAndName;
    private String observacionesItem;





}
