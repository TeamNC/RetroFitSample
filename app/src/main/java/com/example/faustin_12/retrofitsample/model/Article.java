package com.example.faustin_12.retrofitsample.model;

import java.util.List;

/**
 * Created by FAUSTIN-12 on 02/07/2016.
 */
public class Article {
    public String title;
    public String link;
    public String guid;
    public String pubDate;
    public List<String> categories;
    public String author;
    public String thumbnail;
    public String description;
    public String content;
    public Enclosure enclosure;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Enclosure getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

