package com.barinov3dgmail.expensesandrevenues.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

public class AddingTaskDialogFragment extends DialogFragment {

    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        return builder
                .setTitle("Сообщение")
            .setIcon(android.R.drawable.ic_dialog_alert)
                .setMessage("Вы хотите начать новый учет и добавить текущие доходы/траты в историю? Внимание! Это действие обнулит текущие доходы/траты. Нажмите ОК для подтверждения")
                .setPositiveButton("OK", null)
                .setNegativeButton("Отмена", null)
                .create();}
}