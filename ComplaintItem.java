package com.example.myprojectui;

public class ComplaintItem {
    String subject, type, complaint_Id;

    public ComplaintItem(String subject, String type, String complaint_Id) {
        this.subject = subject;
        this.type = type;
        this.complaint_Id = complaint_Id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getComplaint_Id() {
        return complaint_Id;
    }

    public void setComplaint_Id(String complaint_Id) {
        this.complaint_Id = complaint_Id;
    }

    @Override
    public String toString() {
        return "ComplaintItem{" +
                "subject='" + subject + '\'' +
                ", type='" + type + '\'' +
                ", complaint_Id='" + complaint_Id + '\'' +
                '}';
    }
}
