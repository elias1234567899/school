/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.service;

import com.school.commun.Message;
import com.school.model.Role;
import com.school.model.Users;
import com.school.repository.RoleRepository;
import com.school.repository.UsersRepository;
import com.school.vo.UsersVo;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 *
 * @author abbasturki.elias
 *
 */
@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private RoleRepository roleRepository;

    public SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    @Transactional
    public Message create(UsersVo userVo) {
        Message r;
        try {
            Optional<Role> role = roleRepository.findById(userVo.getRole());
            if (!role.isPresent()) {
                r = new Message("Role not found ....", "error", 500);
                return r;
            }
            Users t = new Users();
            t.setNom(userVo.getNom());
            t.setPrenom(userVo.getPrenom());
            t.setAdresse(userVo.getAdresse());
            t.setSexe(userVo.getSexe());
            t.setDateNaiss(df.parse(userVo.getDate_naiss()));
            System.out.println("date : " + userVo.getDate_naiss());
            System.out.println("date nais : " + df.parse(userVo.getDate_naiss()));
            t.setTele1(userVo.getTele1());
            t.setTele2(userVo.getTele2());
            t.setEmail(userVo.getEmail());
            t.setRole(role.get());
            usersRepository.save(t);
        } catch (Exception e) {
            if (e.getMessage() != null) {
                r = new Message(e.getMessage(), "error", 500);
            } else {
                r = new Message("Unknow error....", "error", 500);
            }
            return r;
        }
        r = new Message("User created with sucessful ....", "success", 200);
        return r;
    }

    @Transactional
    public Message update(Users user) {
        Message r;
        if (!usersRepository.existsById(user.getId_user())) {
            r = new Message("User Not found", "error", 500);
            return r;
        }
        try {
            usersRepository.save(user);
            r = new Message("User updated with sucessful ....", "success", 200);
            return r;
        } catch (Exception e) {
            if (e.getMessage() != null) {
                r = new Message(e.getMessage(), "error", 500);
            } else {
                r = new Message("Unknow error....", "error", 500);
            }
            return r;
        }
    }
    
     @Transactional
    public Message delete(Integer id){
        Message r;
        Optional<Users> user = usersRepository.findById(id);
        if (user.get() == null) {
            r = new Message("User Not found", "error", 500);
            return r;
        }
        try {
            usersRepository.delete(user.get());
            r = new Message("er deleted with sucessful ....", "success", 200);
            return r;
        } catch (Exception e) {

            if (e.getMessage() != null) {
                r = new Message(e.getMessage(), "error", 500);
            } else {
                r = new Message("Unknow error....", "error", 500);
            }
            return r;
        } 
    }
    
    public Page<Users> searchByNom(String mc,int page,int size){
        return usersRepository.findByNom(mc,PageRequest.of(page, size));
    }

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }
    
     public Optional<Users> findUserById(Integer id) {
        return usersRepository.findById(id);
    }
}
