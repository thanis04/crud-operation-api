package test.crudoperationapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import test.crudoperationapi.entity.UserDetail;
import test.crudoperationapi.repository.UserRepository;

@Service
//@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDetail> fetchUsers() {
        List<UserDetail> userDetails = userRepository.findAll();
        //return userDetails;
        return userDetails;
    }

    public UserDetail fetchUserByUserName(String name) {
        return userRepository.findByUserName(name);
    }
    public UserDetail addUserDetail(UserDetail userDetail) throws DataIntegrityViolationException{
        return userRepository.save(userDetail);
    }

    public String deleteUserDetailByUserName(String name) {
        String res="";
        try {
            userRepository.deleteById(name);
            res="deleted successfully";
        } catch (Exception ex){
            res=ex.getMessage();
        }
       return res;
    }

    public UserDetail updateUserDetailByUserName(UserDetail userDetail, String name) {
        userDetail = userRepository.findByUserName(name);
        return userRepository.save(userDetail);
    }

}
