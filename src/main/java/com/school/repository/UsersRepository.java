/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.repository;

import com.school.model.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author abbasturki.elias
 */
public interface UsersRepository extends JpaRepository<Users,Integer>{
    
    @Query("select u from Users u where u.nom like :X")
    public Page<Users> findByNom(@Param("X")String mc,Pageable pageable);
    
    @Query("select u from Users u where u.id_user =:X")
    public Users findByIdUser(@Param("X") Integer id);
    
}
