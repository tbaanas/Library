package pl.sda.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
public class Borrower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id_borrower")
    private Long id;

    @Column(name="first_name")
    private int firstName;

    @Column(name="last_name")
    private int lastName;

    @Column(name="borrower_detalis_id")
    private Long borrower_detalis_id;


    @OneToOne
    @JoinColumn(name = "borrower")
    private BorrowerDetails borrowerDetails;

    @OneToMany(mappedBy = "borrower")
    private List<Borrow> borrows;
}
