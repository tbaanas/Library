package pl.sda.service;

import pl.sda.entities.Users;
import repository.UsersRepository;

public class UsersService {


    private UsersRepository usersRepository=new UsersRepository();

    public void save(Users user) {
        usersRepository.save(user);
    }


}
