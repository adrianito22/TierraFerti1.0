package com.tiburela.tierrafertil.models;

import java.util.ArrayList;

public class ProductoresTierraFertil {

    private String nombre;
    private String finca;
    private String ubicacion;

    public String getCertificadora() {
        return certificadora;
    }

    private String certificadora;

    public String getNombre() {
        return nombre;
    }

    public String getFinca() {
        return finca;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public float getArea() {
        return area;
    }

    public int getCajasSemanles() {
        return cajasSemanles;
    }

    public String getGgn() {
        return ggn;
    }

    public String getCodigoMagap() {
        return codigoMagap;
    }

    public String getGrupCertificadora() {
        return grupCertificadora;
    }

    private float area;
    private int  cajasSemanles;
    private String ggn;
    private String codigoMagap;
    private String grupCertificadora;




    public ProductoresTierraFertil(){


    }

    public ProductoresTierraFertil(String nombre, String finca, String ubicacion, float area, int cajasSemanles, String ggn, String codigoMagap,String certificadora, String grupCertificadora) {
        this.nombre = nombre;
        this.finca = finca;
        this.ubicacion = ubicacion;
        this.area = area;
        this.cajasSemanles = cajasSemanles;
        this.ggn = ggn;
        this.codigoMagap = codigoMagap;
        this.grupCertificadora = grupCertificadora;
        this.certificadora=certificadora;
    }



    void createobejt(){
        ArrayList<ProductoresTierraFertil>lis= new ArrayList<>();

       // lis.add(new ProductoresTierraFertil("Aguirre caripio","lalucera,chiquita,lorena","pasaje",231321,5454,"sfgdf","codigogg","fhfg")     );
       // lis.add(new ProductoresTierraFertil("Aguirre caripio","lalucera,chiquita,lorena","pasaje",231321,5454,"sfgdf","codigogg","fhfg")     );

        lis.add(new ProductoresTierraFertil("Aguirre Carpio Carlos Alberto","Santa Cecilia,Cerrito,La Chiquita","El Mango-Progreso-Pasaje,Puerto Garzon,CañaQuemada,Pasaje,Pasaje",1000,43200,"Mayacert","4056186938749","N21389,SN,SN","E")     );


    }


}
