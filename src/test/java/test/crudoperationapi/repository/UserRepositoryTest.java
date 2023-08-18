package test.crudoperationapi.repository;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import test.crudoperationapi.entity.UserDetail;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void feychUser() {

        List<UserDetail> result=userRepository.findAll();
        System.out.println(result);
    }

    @Test
    public void addUser() {

        UserDetail userDetail=UserDetail.builder()
                .user_name("Ahmed789")
                .password("Ahmed789")
                .full_name("Ahmed Bilal")
                .mobile_no("783493423")
                .nic("91212389v")
                .created_date("")
                .updates_date("")
                .build();
        userRepository.save(userDetail);
    }

    @Test
    public void getByUsername() {
        UserDetail result = userRepository.findByUserName("Ahmed789");
        System.out.printf(String.valueOf(result));
    }

    @Test
    public void deleteUserName() {
        userRepository.deleteById("Billa");
    }

    @Test
    public void updateUser() {

        UserDetail userDetail = userRepository.findByUserName("Anushanka11").builder()
                .user_name("Anushanka11")
                .password("Anushanka11")
                .full_name("Anushanka Billa")
                .mobile_no("782345678")
                .nic("336790242v")
                .created_date("")
                .updates_date("")
                .build();
        userRepository.save(userDetail);
    }
    
}
