package com.example.android.learning;

import android.content.Context;
import android.os.Message;
import android.widget.Toast;

public class ToastMessage {
    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
