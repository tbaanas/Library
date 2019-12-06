package pl.sda.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_book;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "BORROW")
    private boolean borrow;

    @Column(name = "ISBN")
    private String isbn;

    @Column(name = "PAGES")
    private int pages;

    @Column(name = "RELEASE_DATE")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "SUMMARY", length = 550)
    private String summary;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "AUTHOR_ID")
    private Long author_id;

    @Column(name = "setCurrentBorrowerName")
    private String setCurrentBorrowerName;

    @ManyToOne()
    @JoinColumn(name = "id_author")
    private Author author;


    @OneToMany(mappedBy = "book")
    private List<Borrow> borrowList;


}
