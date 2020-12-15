package com.episen.docmanagement.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class Document {
    @Id
    private String documentId;

    private Date created;

    private Date upadated;

    private String title;

    private String creator;

    private String editor;

    private String body;

    private Status status;

    public Document(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpadated() {
        return upadated;
    }

    public void setUpadated(Date upadated) {
        this.upadated = upadated;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Document{" +
                "documentId='" + documentId + '\'' +
                ", created=" + created +
                ", upadated=" + upadated +
                ", title='" + title + '\'' +
                ", creator='" + creator + '\'' +
                ", editor='" + editor + '\'' +
                ", body='" + body + '\'' +
                ", status=" + status +
                '}';
    }
}
