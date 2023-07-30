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
    /**
     * Gets the title of activity
     * @return the title of the activity
     */
    public String getTitle() {
        return title;
    }
    /**
     * Sets the title of activity
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * Gets the dueDate of activity
     * @return the dueDate of the activity
     */
    public String getDueDate() {
        return dueDate;
    }
    /**
     * Sets the dueDate of activity
     */
    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
    /**
     * Gets the completed of activity
     * @return the completed of the activity
     */
    public boolean isCompleted() {
        return completed;
    }
    /**
     * Sets the completed of activity
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

}
