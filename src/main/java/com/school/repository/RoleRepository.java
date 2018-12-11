/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.repository;

import com.school.model.Role;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author abbasturki.elias
 */
public interface RoleRepository extends JpaRepository<Role,Integer>{
    
    @Query("select u from Role u where u.intitule like :X")
    public Page<Role> findByIntitule(@Param("X")String mc,Pageable pageable);
   
    
    
    
}
