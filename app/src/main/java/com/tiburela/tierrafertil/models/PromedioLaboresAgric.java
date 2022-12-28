package com.tiburela.tierrafertil.models;

public class PromedioLaboresAgric {


    public float getEnfundeProm() {
        return enfundeProm;
    }

    public float getDeshojeProm() {
        return deshojeProm;
    }

    public float getApuntalamientoProm() {
        return apuntalamientoProm;
    }

    public float getDeshijeProm() {
        return deshijeProm;
    }

    public float getOtrasLaboresProm() {
        return otrasLaboresProm;
    }


    public PromedioLaboresAgric(){

        deshojeProm=0;
        apuntalamientoProm=0;
        deshijeProm=0;
        otrasLaboresProm=0;

    }



    private float deshojeProm;
    private float apuntalamientoProm;

    public void setDeshojeProm(float deshojeProm) {
        this.deshojeProm = deshojeProm;
    }

    public void setApuntalamientoProm(float apuntalamientoProm) {
        this.apuntalamientoProm = apuntalamientoProm;
    }

    public void setDeshijeProm(float deshijeProm) {
        this.deshijeProm = deshijeProm;
    }

    public void setOtrasLaboresProm(float otrasLaboresProm) {
        this.otrasLaboresProm = otrasLaboresProm;
    }

    public void setEnfundeProm(float enfundeProm) {
        this.enfundeProm = enfundeProm;
    }

    private float deshijeProm;
    private float otrasLaboresProm;

    private float enfundeProm;


}
