package com.juaracoding.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juaracoding.main.entity.Admin;

public interface AdminRepo extends JpaRepository<Admin, Long>{

}
