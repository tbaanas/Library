package pl.sda.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id_borrow")
    private Long id;

    @Column(name="book_id")
    private Long bookId;

    @Column(name="borower_id")
    private Long borowerId;

    @Column(name="rental_date")
    private Date date;


    @ManyToOne()
    @JoinColumn(name = "borrowList")
    private Book book;


    @ManyToOne()
    @JoinColumn(name="borrows")
    private Borrower borrower;

}
