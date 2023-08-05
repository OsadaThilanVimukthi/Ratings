package com.example.Rating.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "rating")
public class Rating {

    @Id
    private String id;
    private String value;
    private String comment;

    public Rating(String id, String value, String comment) {
        this.id = id;
        this.value = value;
        this.comment = comment;
    }

    public Rating() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}