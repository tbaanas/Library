package pl.sda.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Book{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id_bookALong;

    @Column(name="borrow")
    private int borrow;

    @Column(name="category")
    private String category;

    @Column(name="isbn")
    private String isbn;

    @Column(name="pages")
    private int pages;

    @Column(name="release_date")
    private Date date;

    @Column(name="summary")
    private String summary;

    @Column(name="title")
    private String title;

    @Column(name="author_id")
    private Long author_id;


    @ManyToOne()
    @JoinColumn(name = "id_author")
    private Author author;



    @OneToMany(mappedBy = "book")
    private List<Borrow> borrowList;


}
