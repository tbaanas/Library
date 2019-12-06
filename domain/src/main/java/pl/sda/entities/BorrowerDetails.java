package pl.sda.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class BorrowerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBorrower;

    @Column(name="ADDRESS")
    private String address;

    @Column(name="PHONE")
    private String phone;

    @Column(name="EMAIL")
    private String email;




    @OneToOne(mappedBy = "details")
    private Borrower borrower;
}
