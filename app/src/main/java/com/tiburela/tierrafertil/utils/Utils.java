package com.tiburela.tierrafertil.utils;

import android.widget.EditText;

public class Utils {

   public static  String [] arrayWhitkeysMapCategories ={"Enfunde","Deshoje","Apuntalamiento","Deshije","Otras labores"};


   public static  String keyIntentXtraAllinforms ="KEY EXTRASS";

   public static  String keyDialogBundle ="diaslogBundleKey";


   public static final int DATE_ESPECIFIC =11;
   public static final int RANGE_DATE =12;
   public static final int TYPE_FORM =13;

   public static  String currentInformSelectedId ="";

   public static final String KEY_INTEN_LABORES_AGROICOLAS ="LASNDFNFDNF";

   public static  EditText returnEditextBykey(String keyItem, EditText [] arrayEditext){
      EditText currenEditextx=null;
      for(EditText currenEditext : arrayEditext){ //buscamos el key en el tag

         if(currenEditext.getTag().equals(keyItem)){

            currenEditextx=currenEditext ;
      }


   }
   return currenEditextx;

}}

