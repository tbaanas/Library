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


    private Long id;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name="BORROWER_DETAILS_ID")
    private Long borrower_detalis_id;


    @OneToOne
    @JoinColumn(name = "id_details")
    private BorrowerDetails details;


    @OneToMany(mappedBy = "borrower")
    private List<Borrow> borrows;
}
