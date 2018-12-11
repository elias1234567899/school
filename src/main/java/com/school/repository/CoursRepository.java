/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.repository;

import com.school.model.Cours;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author abbasturki.elias
 */
public interface CoursRepository extends JpaRepository<Cours,Integer>{
    
    @Query("select u from Cours u where u.id_groupe=:X")
    public Page<Cours> search(@Param("X")String mc,Pageable pageable);
    
    
    
}
