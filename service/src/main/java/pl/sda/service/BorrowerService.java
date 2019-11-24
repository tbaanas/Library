package pl.sda.service;

import pl.sda.entities.Borrower;
import repository.BorrowerRepository;

import java.util.List;

public class BorrowerService {
    private BorrowerRepository borrower=new BorrowerRepository();
    public Borrower find(long id) {

        return borrower.find(id);
    }

    public Borrower findBorrow(long id) {

        return borrower.findBorrow(id);
    }

    public List<Borrower> findAll() {

        return borrower.findAll();
    }
}
