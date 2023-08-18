package test.crudoperationapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import test.crudoperationapi.entity.UserDetail;
import test.crudoperationapi.services.EncryptorAndDecryptor;
import test.crudoperationapi.services.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/user")
@Controller
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping(value = "/get")
    public ResponseEntity<List<UserDetail>> fetchUsers() {
        return new ResponseEntity<List<UserDetail>>(userService.fetchUsers(), HttpStatus.OK);
    }

    @GetMapping(value = "/getByName/{name}")
    public ResponseEntity<UserDetail> getUserByName(@PathVariable("name") String name) {


        return new ResponseEntity<UserDetail>(userService.fetchUserByUserName(name), HttpStatus.OK);
    }


    @PostMapping(value = "/post")

    public ResponseEntity<UserDetail> addUsers(@RequestBody UserDetail userDetail) {

        try {

            EncryptorAndDecryptor encryptorAndDecryptor = new EncryptorAndDecryptor();
            String encodedPassword = encryptorAndDecryptor.encode(userDetail.getPassword());
            userDetail.setPassword(encodedPassword);

            return new ResponseEntity<UserDetail>(userService.addUserDetail(userDetail), HttpStatus.OK);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

/*    @DeleteMapping(value = "/delete/{name}")
    public void deleteUser(@PathVariable("name") String name) {
        userService.deleteUserDetailByUserName(name);
//        userService.deleteUserDetailByUserName(name);
    }*/

    @DeleteMapping(value = "/deleteUser/{name}")
    public ResponseEntity<String> deleteUser(@PathVariable("name") String name) {
        try {
            return new ResponseEntity<String>(userService.deleteUserDetailByUserName(name), HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
}

    @PutMapping(value = "/update/{name}")
    public ResponseEntity<UserDetail> updateUser(@RequestBody UserDetail userDetail, @PathVariable String name) {
        try {
            //System.out.println("userRepository.findByUserName(name)");
            return new ResponseEntity<>(userService.updateUserDetailByUserName(userDetail, name), HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

  /*  @PostMapping(value = "/login")
    public ResponseEntity<Boolean> login(@RequestParam(value = "name") String username, @RequestParam(value = "password") String password) {
        UserDetail userDetail = userService.fetchUserByUserName(username);
        if(userDetail != null) {
            EncryptorAndDecryptor encryptorAndDecryptor = new EncryptorAndDecryptor();
            return new ResponseEntity<Boolean>(encryptorAndDecryptor.matches(password, userDetail.getPassword()), HttpStatus.OK);
        } else {
            System.out.println("User doesn't exists");
            return new ResponseEntity<Boolean>(false, HttpStatus.OK);
        }
    }*/


    @PostMapping(value = "/login")
    public ResponseEntity<Boolean> login(@RequestBody UserDetail userDetail) {

        UserDetail chechUser = userService.fetchUserByUserName(userDetail.getUser_name());

        if(chechUser != null) {
            EncryptorAndDecryptor encryptorAndDecryptor = new EncryptorAndDecryptor();
            return new ResponseEntity<Boolean>(encryptorAndDecryptor.matches(userDetail.getPassword(), chechUser.getPassword()), HttpStatus.OK);
        } else {
            System.out.println("User doesn't exists");
            return new ResponseEntity<Boolean>(false, HttpStatus.OK);
        }
    }
}
