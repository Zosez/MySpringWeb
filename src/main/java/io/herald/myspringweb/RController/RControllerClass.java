package io.herald.myspringweb.RController;


import io.herald.myspringweb.Model.UserTable;
import io.herald.myspringweb.Repository.ImageRepository;
import io.herald.myspringweb.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RControllerClass {


    @Autowired
    private UserRepository uRepo;

    @Autowired
    private ImageRepository imgRepo;

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/getAllUsers")
    public List<UserTable> getAllUsers(){
        return uRepo.findAll();
    }

    @PostMapping("/saveUser")
    public String saveUser(@RequestBody UserTable user){
        String password = user.getPassword();

//        String passwordHash = password.

        uRepo.save(user);
        return "Saved Successfully";
    }

    @GetMapping("/getOne/{id}")
    public UserTable getOne(@PathVariable int id){
        UserTable user = uRepo.findById(id).get();
        return user;
    }

    @GetMapping("/getId/{id}")
    public ResponseEntity<?> getId(@PathVariable int id){

        if(uRepo.findById(id).isPresent()){
            return ResponseEntity.ok(uRepo.findById(id).get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id Not Found");
    }
}
