package alex.project.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {
    private int id;
    @NotEmpty(message = "title should not be empty")
    @Size(min = 2, max = 100, message = "title should be higher than 2 until 100")
    private String title;
    @NotEmpty(message = "author should not be empty")
    @Size(min = 2, max = 100, message = "name author should be higher than 2 until 100")
    private String author;
    private int year;

    public Book(){

    }

    public Book(int id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book: " + "id: " + id + ", title: " + title + ", author: " + author + ", year: " + year;
    }
}
