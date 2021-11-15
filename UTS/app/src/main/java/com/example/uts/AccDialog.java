package com.example.uts;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

public class AccDialog {
    private Activity activity;
    private AlertDialog alertDialog;

    AccDialog(Activity MyActivity){
        activity=MyActivity;
    }
    void startAcc(){
        AlertDialog.Builder acc=new AlertDialog.Builder(activity);
        LayoutInflater AccLay=activity.getLayoutInflater();
        acc.setView(AccLay.inflate(R.layout.acc,null));
        acc.setCancelable(false);
        alertDialog = acc.create();
        alertDialog.show();
    }
}
