/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.repository;

import com.school.model.Seance;
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
public interface SeanceRepository extends JpaRepository<Seance,Integer>{
    
    @Query("select u from Seance u where u.jour like :X")
    public Page<Seance> search(@Param("X")String mc,Pageable pageable);
    
}
