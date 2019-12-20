package com.example.myprojectui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ComplaintItemView extends LinearLayout {
    TextView complaint_id, subject, type;
    Context complaintListContext;
    public ComplaintItemView(Context context, Context c) {
        super(context);
        init(context);
        complaintListContext = c;

    }

    public ComplaintItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.complaint_item,this,true);

        complaint_id = (TextView)findViewById(R.id.complaintID);
        subject = (TextView)findViewById(R.id.subject);
        type = (TextView)findViewById(R.id.typeofCase);
        complaint_id.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
             CommonUtility.showOKDialog(complaintListContext,"Complaint Status","The Complaint "+complaint_id.getText()+" is still in progress.");
            }
        });
    }
    public  void setComplaint_id(String complaint_id1){
        complaint_id.setText(complaint_id1);
    }
    public  void setSubject(String sub){
        subject.setText(sub);
    }
    public  void setType(String typeOfCase){
        type.setText(typeOfCase);
    }
}
