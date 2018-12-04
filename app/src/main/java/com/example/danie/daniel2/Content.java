package com.example.danie.daniel2;

import java.util.ArrayList;

/**
 * Created by danie on 26/11/2018.
 */

public class Content {

    private String Title;
    private String Category;
    private String Description;
    private String Serving;
    private String Prep;
    private String Difficulty;

    private int Thumbnail;

    public Content() {
    }

    public Content(String title, String category, String description,String serving,String difficulty,String prep ,int thumbnail) {
        this.Thumbnail = thumbnail;
        this.Description = description;
        this.Category = category;
        this.Title = title;
        this.Prep = prep;
        this.Serving = serving;
        this.Difficulty = difficulty;

    }

    public String getTitle() {
        return Title;
    }

    public String getCategory() {
        return Category;
    }

    public String getDescription() {
        return Description;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public void setCategory(String category) {
        this.Category = category;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public void setThumbnail(int thumbnail) {
        this.Thumbnail = thumbnail;
    }

    public String getServing() {
        return Serving;
    }

    public void setServing(String serving) {
        this.Serving = serving;
    }

    public String getDifficulty() {
        return Difficulty;
    }

    public void setDifficulty(String dificulty) {
        Difficulty = dificulty;
    }

    public String getPrep() {
        return Prep;
    }

    public void setPrep(String prep) {
        this.Prep = prep;
    }
}
