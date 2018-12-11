/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.controller;

import com.school.model.Role;
import com.school.model.Users;
import com.school.service.UsersService;
import com.school.vo.UsersVo;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
@RequestMapping(path = "/users")
@CrossOrigin("*")
public class UserController {
    
    @Autowired
    private UsersService usersService;
    
    @GetMapping
    public List<Users> getUsers() {
        return usersService.getAllUsers();
    }
    
    @GetMapping("/{id}")
    public Optional<Users> getUser(@PathVariable Integer id) {
        return usersService.findUserById(id);
    }
    
    @PostMapping
    public Object save(@RequestBody UsersVo user) throws ParseException {
        return usersService.create(user);
    }
    
    @DeleteMapping("delete/{id}")
    public Object delete(@PathVariable Integer id) {
        return usersService.delete(id);
    }

    //@PutMapping("/update")
    @PatchMapping("/update")
    public Object update(@RequestBody Users user) {
        return usersService.update(user);
    }
    
    @GetMapping("/search")
    public Page<Users> search(@RequestParam(name = "mc", defaultValue = "") String mc,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) {
        return usersService.searchByNom("%" + mc + "%", page, size);
    }
}
