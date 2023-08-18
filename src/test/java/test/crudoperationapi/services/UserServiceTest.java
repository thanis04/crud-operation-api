package test.crudoperationapi.services;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import test.crudoperationapi.entity.UserDetail;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void testFetchUsers() {
        List<UserDetail> userDetails = userService.fetchUsers();
        System.out.println(userDetails);
    }

    @Test
    void testFetchUserByUserName() {
        UserDetail userDetail = userService.fetchUserByUserName("Ahmed789");
        System.out.println(userDetail);
    }

    @Test
    void testDeleteUserDetailByUserName() {
        userService.deleteUserDetailByUserName("Anushanka11");
    }

    @Test
    void testAddUserDetail() {
        UserDetail userDetail = UserDetail.builder()
                .user_name("David34")
                .password("David34")
                .full_name("Anushanka Barathi")
                .mobile_no("792345556")
                .nic("672345672z")
                .created_date("")
                .updates_date("")
                .build();
        userService.addUserDetail(userDetail);
    }

 /*   @Test
    void testUpdateUserDetailByUserName() {
        userService.updateUserDetailByUserName(
                UserDetail.builder()
                        .user_name("Anushanka11")
                        .password("Anushanka11")
                        .full_name("Pradeep Anushanka")
                        .mobile_no("783456982")
                        .nic("963476123x")
                        .created_date("")
                        .updates_date("")
                        .build()
                , "Anushanka11");*/
    //}
}
