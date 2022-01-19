package com.example.uts;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

class LoadingDialog {
    private Activity activity,AccActivity;
    private AlertDialog dialog,accDialog;

    LoadingDialog(Activity myActivity){
        activity=myActivity;
    }

    void startLoadingDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.loading,null));
        builder.setCancelable(false);
        dialog = builder.create();;
        dialog.show();
    }
    void dismiss(){
        dialog.dismiss();
    }
}
