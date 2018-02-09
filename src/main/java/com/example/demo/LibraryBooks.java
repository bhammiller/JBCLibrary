package com.example.demo;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;

@Entity
public class LibraryBooks {

    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Size(min = 1, message = "Please enter book title")
    private String booktitle;

    @NotNull
    @Size(min = 1,message = "Please enter author")
    private String author;

    @NotNull
    @Size(min = 1, max = 4, message = "Please enter publication year(XXXX)")
    private String publicationyear;

    private String isbn;

    private String bookimage;

    private String bookavailability;

    private Date created;
    private Date updated;

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

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
