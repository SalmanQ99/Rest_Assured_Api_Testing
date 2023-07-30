package com.sw.api.test.dto;

public class PostActivityDTO {

    private String title;
    private String dueDate;
    private boolean completed;

    public PostActivityDTO(String title, String dueDate, boolean completed) {
        this.title = title;
        this.dueDate = dueDate;
        this.completed = completed;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

}
