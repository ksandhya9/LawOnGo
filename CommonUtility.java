package com.example.myprojectui;

import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;

import java.util.Date;

public class CommonUtility {
    public static String firstName,lastName, passPort, phone, email, adrs, dob;
   // public static Date dob;
    public static int id;
    public static String loginName,password;

    public CommonUtility(String first_Name, String last_Name, String login_Name, String pass_word, String passPortNo, String phoneNo, String addrs, String emailId, String dofb, int userid) {
        firstName = first_Name;
        lastName = last_Name;
        loginName = login_Name;
        password = pass_word;
        passPort = passPortNo;
        phone = phoneNo;
        adrs = addrs;
        dob = dofb;
        email = emailId;
        id = userid;
    }
    public static void showOKDialog(Context context, String title, String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton(android.R.string.ok, null);
        builder.show();
    }
}
