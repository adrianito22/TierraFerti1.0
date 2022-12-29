package com.tiburela.tierrafertil.utils;

import com.tiburela.tierrafertil.calendario.CalendarioEnf;
import com.tiburela.tierrafertil.models.ProductorTierraFertil;

import java.util.HashMap;
import java.util.Map;

public class Variables {

 public static ProductorTierraFertil currentProductorBJECt;



 public static CalendarioEnf currentCalEnfundeoBJECt;
public static Map<String, CalendarioEnf> miMap= new HashMap<>();



   public static  String [] arrayWhitkeysMapCategories ={"Enfunde","Deshoje","Apuntalamiento","Deshije","Otras labores"};

    public static  final int ENFUNDE=2;
    public static  final int DESHOJE=3;
    public static  final int APUNTALAMIENTO=4;
    public static  final int DESHIJE=5;
    public static  final int OTRAS_LABORES=6;

    public static  final int ALL_CATEGORIES=7;


}
