package com.sw.api.test.dto;

public class BookPostDTO {
    private String title;
    private String description;
    private int pageCount;
    private String excerpt;
    private String publishDate;


    public BookPostDTO(String title, String description, int pageCount, String excerpt, String publishDate) {
        this.title = title;
        this.description = description;
        this.pageCount = pageCount;
        this.excerpt = excerpt;
        this.publishDate = publishDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPagecount() {
        return pageCount;
    }

    public void setPagecount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String except) {
        this.excerpt = excerpt;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String dueDate) {
        this.publishDate = dueDate;
    }


}
