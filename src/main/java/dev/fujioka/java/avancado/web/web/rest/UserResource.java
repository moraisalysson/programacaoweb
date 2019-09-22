package dev.fujioka.java.avancado.web.web.rest;

import dev.fujioka.java.avancado.web.domain.User;
import dev.fujioka.java.avancado.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @PostMapping("/user")
    public ResponseEntity<User>
    save(@Valid @RequestBody User user) {
        userService.save(user);
        return ResponseEntity.ok(user);
    }


    @PutMapping("/user")
    public ResponseEntity update(@Valid @RequestBody User user) {
        userService.save(user);
        return ResponseEntity.ok().body(user);
    }


    @DeleteMapping("/user")
    public ResponseEntity<String> delete(@Valid @RequestBody User user) {
        userService.delete(user);
       return  ResponseEntity.ok().body("User excluded ID: " + user.getId());
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok().body("User excluded ID: " + id);
    }

    @GetMapping("/user/firstname/{firstName}")
    public List<User> getUserByName(@PathVariable String firstName) {
        return userService.getUserByFirstName(firstName);
    }

    @GetMapping("/user/lastname/{lastName}")
    public List<User> getUserByLastName(@PathVariable String lastName) {
        return userService.getUserByLastName(lastName);
    }

    @GetMapping("/user/login/{login}")
    public List<User> getUserByLogin(@PathVariable String login) {
        return userService.getUserByLogin(login);
    }

    @GetMapping("/user/name/{firstName}/{lastName}")
    public List<User> getUserByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName) {
        return userService.getUserByFirstNameAndLastName(firstName, lastName);
    }

    @GetMapping("/user/id/{id}")
    public List<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/user/loginfirstname/{login}/{firstName}")
    public List<User> getUserbyLoginAndFirstName(@PathVariable String login, @PathVariable  String firstName) {
        return userService.getUserbyLoginAndFirstName(login, firstName);
    }

}