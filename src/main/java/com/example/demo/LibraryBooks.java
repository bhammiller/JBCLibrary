package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class LibraryBooks {

    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String booktitle;

    private String author;

    private String publicationyear;

    private String isbn;

    private String bookimage;

    private String bookavailability;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublicationyear() {
        return publicationyear;
    }

    public void setPublicationyear(String publicationyear) {
        this.publicationyear = publicationyear;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getBookimage() {
        return bookimage;
    }

    public void setBookimage(String bookimage) {
        this.bookimage = bookimage;
    }

    public String getBookavailability() {
        return bookavailability;
    }

    public void setBookavailability(String bookavailability) {
        this.bookavailability = bookavailability;
    }
}
