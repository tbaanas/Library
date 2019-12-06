package pl.sda.service;

import pl.sda.entities.Users;
import repository.UsersRepository;

import java.util.List;

public class UsersService {


    private UsersRepository usersRepository = new UsersRepository();

    public void save(Users user) {
        usersRepository.save(user);
    }


    public List<Users> uid(String login, String password) {
        return usersRepository.uid(login, password);
    }

    public Users login(Long id) {
        return usersRepository.login(id);
    }
}
