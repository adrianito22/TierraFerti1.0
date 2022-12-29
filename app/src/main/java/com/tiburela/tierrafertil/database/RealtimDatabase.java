package com.tiburela.tierrafertil.database;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RealtimDatabase {

    static  public DatabaseReference rootDatabaseReference ;


    public static  void initDatabasesRootOnly(){

        rootDatabaseReference = FirebaseDatabase.getInstance().getReference();




    }

}
