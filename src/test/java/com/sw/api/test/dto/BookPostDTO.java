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
    /**
     * Gets the title of book
     * @return the title of the book
     */
    public String getTitle() {
        return title;
    }
    /**
     * Sets the title of book
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * Gets the description of the book
     * @return the description of the book
     */
    public String getDescription() {
        return description;
    }
    /**
     * set the book description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Gets the pageCount of the book
     * @return the description of the book
     */
    public int getPagecount() {
        return pageCount;
    }
    /**
     * set the page count
     */
    public void setPagecount(int pageCount) {
        this.pageCount = pageCount;
    }
    /**
     * Gets the excerpt of the book
     * @return the excerpt of the book
     */
    public String getExcerpt() {
        return excerpt;
    }
    /**
     * set the excerpt count
     */
    public void setExcerpt(String except) {
        this.excerpt = excerpt;
    }
    /**
     * Gets the publishDate of the book
     * @return the publishDate of the book
     */
    public String getPublishDate() {
        return publishDate;
    }
    /**
     * set the publishDate count
     */
    public void setPublishDate(String dueDate) {
        this.publishDate = dueDate;
    }
}
