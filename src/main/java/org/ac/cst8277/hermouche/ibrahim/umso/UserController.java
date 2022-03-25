package org.ac.cst8277.hermouche.ibrahim.umso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    UserRepository repository;

    @GetMapping("/users")
    public @ResponseBody Iterable<User> getAllUsers(){
        return repository.findAll();
    }

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam String uuid,
                                            @RequestParam String firstname,
                                            @RequestParam String lastname,
                                            @RequestParam String email,
                                            @RequestParam String date,
                                            @RequestParam Integer rolenumber,
                                            @RequestParam Integer seenlastly)
    {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User n = new User();
        n.setUserid(uuid);
        n.setUserfirstname(firstname);
        n.setUserlastname(lastname);
        n.setUseremailaddress(email);
        n.setDateregistered(date);
        n.setUserrole(rolenumber);
        n.setUserlastseen(seenlastly);
        repository.save(n);
        return "Added and Saved";
    }



    @GetMapping("/welcome")
    public String showWelcome(){
        return "Welcome to User Management Service hosted on k8s!";
    }

}
