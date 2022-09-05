package com.erygindmitri.springlibrary.spring_app_library.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "description", columnDefinition = "text")
    private String description;


    //связь с таблицей images
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,
    mappedBy = "book")
    private List<Image> images = new ArrayList<>();
    private Integer previewImageId;

    //связь с юзером
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn
    private User user;

    //добовляем image
    public void addImageToBook(Image image){
        image.setBook(this);
        images.add(image);
    }
    //================================================================
    public Book() {
    }

    public Book(Integer id, String title, String author, String description, List<Image> images, Integer previewImageId, User user) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.images = images;
        this.previewImageId = previewImageId;
        this.user = user;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Integer getPreviewImageId() {
        return previewImageId;
    }

    public void setPreviewImageId(Integer previewImageId) {
        this.previewImageId = previewImageId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
