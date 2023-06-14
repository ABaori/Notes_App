package com.example.notes_app;

public class NoteModel {
    private String notes;
    private String title;
    private int id;
    public NoteModel(String notes, String title , int id){
        this.notes = notes;
        this.title = title;
        this.id = id;

    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
