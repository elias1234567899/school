/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.service;

import com.school.commun.Message;
import com.school.model.Role;
import com.school.repository.RoleRepository;
import java.text.DateFormat;
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
 */
@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;
    private DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Transactional
    public Message create(Role role) {
        Message r;
        try {
            roleRepository.save(role);
        } catch (Exception e) {

            if (e.getMessage() != null) {
                r = new Message(e.getMessage(), "error", 500);
            } else {
                r = new Message("Unknow error....", "error", 500);
            }
            return r;
        }
        r = new Message("Role created with sucessful ....", "success", 200);
        return r;
    }

    @Transactional
    public Message update(Role role) {
        Message r;
        System.out.println("role == "+role.toString());
        if (!roleRepository.existsById(role.getId_role())) {
            r = new Message("Role Not found", "error", 500);
            return r;
        }
        try {
            roleRepository.save(role);
            r = new Message("Role updated with sucessful ....", "success", 200);
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
        Optional<Role> role = roleRepository.findById(id);
        if (role.get() == null) {
            r = new Message("Role Not found", "error", 500);
            return r;
        }
        try {
            roleRepository.delete(role.get());
            r = new Message("Role deleted with sucessful ....", "success", 200);
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
    
    public Page<Role> searchBy(String mc,int page,int size){
        return roleRepository.findByIntitule(mc,PageRequest.of(page, size));
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Optional<Role> findRoleById(Integer id) {
        return roleRepository.findById(id);
    }
}
