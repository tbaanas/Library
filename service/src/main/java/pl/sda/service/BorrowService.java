package pl.sda.service;

import pl.sda.entities.Borrow;
import repository.BorrowRepository;

public class BorrowService {
    BorrowRepository borrowRepository=new BorrowRepository();
    public void save(Borrow borrow) {
        borrowRepository.save(borrow);
    }
    public Borrow find(long id) {

        return borrowRepository.find(id);
    }
}
