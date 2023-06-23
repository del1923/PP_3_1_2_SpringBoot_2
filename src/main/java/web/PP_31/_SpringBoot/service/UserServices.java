package web.PP_31._SpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.PP_31._SpringBoot.model.User;
import web.PP_31._SpringBoot.repositiries.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserServices {

    private final UserRepository userRepository;

    @Autowired
    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User show(int id) {
        Optional<User> showPerson = userRepository.findById(id);
        return showPerson.orElse(null);
    }

    public List<User> showByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Transactional
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void update(int id, User userUpdate) {
        userUpdate.setId(id);
        userRepository.save(userUpdate);
    }

    @Transactional
    public void delete(int id) {
        userRepository.deleteById(id);
    }
}
