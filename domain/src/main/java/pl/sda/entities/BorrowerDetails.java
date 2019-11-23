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

    @Column(name="address")
    private String address;

    @Column(name="email")
    private String email;

    @Column(name="phone")
    private String phone;


    @OneToOne(mappedBy = "details")
    private Borrower borrower;
}
