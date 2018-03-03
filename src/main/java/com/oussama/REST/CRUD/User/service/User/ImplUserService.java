package com.oussama.REST.CRUD.User.service.User;
import com.oussama.REST.CRUD.User.repository.UserRepository;
import com.oussama.REST.CRUD.User.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ImplUserService implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public ImplUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Override
    public List<User> AllUsers() {
      return   userRepository.findAll();

    }

    @Override
    public void addUser(User user) {
           userRepository.save(user);

    }

    @Override
    public void updateUserById(Long id, User userDetails){

             User u  =  userRepository.getOne(id);

        // date de modification
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        userDetails.setModificationDate(date);

        u.setNom(userDetails.getNom());
        u.setPrenom(userDetails.getPrenom());
        u.setAge(userDetails.getAge());
        u.setModificationDate(userDetails.getModificationDate());

             userRepository.save(u);

    }

    @Override
    public void deleteUserById(Long id) {
         userRepository.delete(id);

    }

    @Override
    public User GetUserById(long id){
      return userRepository.findOne(id);

    }

    @Override
    public User GetUserByEmail(String email) {
        return userRepository.findByEmail(email);


    }
}
