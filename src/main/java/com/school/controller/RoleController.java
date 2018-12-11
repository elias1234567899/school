/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.controller;

import com.school.model.Role;
import com.school.service.RoleService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author abbasturki.elias
 */
@RestController
@RequestMapping(path = "/roles")
@CrossOrigin("*")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<Role> getRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/{id}")
    public Optional<Role> getRole(@PathVariable Integer id) {
        return roleService.findRoleById(id);
    }

    @PostMapping
    public Object save(@RequestBody Role t) {
        return roleService.create(t);
    }

    @DeleteMapping("delete/{id}")
    public Object delete(@PathVariable Integer id) {
        return roleService.delete(id);
    }

    @PutMapping("/update")
    public Object update(@RequestBody Role c) {
        return roleService.update(c);
    }

//    @RequestMapping(value = "/contacts/search", method = RequestMethod.GET)
//    public Page<Role> search(@RequestParam(name = "mc", defaultValue = "") String mc,
//            @RequestParam(name = "page", defaultValue = "0") int page,
//            @RequestParam(name = "size", defaultValue = "5") int size) {
//        return roleService.search("%" + mc + "%", new PageRequest(page, size));
//    }
    
    @GetMapping("/search")
    public Page<Role> search(@RequestParam(name = "mc", defaultValue = "") String mc,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {
        return roleService.searchBy("%" + mc + "%", page, size);
    }
}
