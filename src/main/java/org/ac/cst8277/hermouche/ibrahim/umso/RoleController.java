package org.ac.cst8277.hermouche.ibrahim.umso;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @Autowired
    RoleRepository roleRepository;

    @GetMapping("allroles")
    public @ResponseBody Iterable<Role> getAllRoles(){
        return roleRepository.findAll();
    }


}
