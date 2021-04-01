package com.juaracoding.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juaracoding.main.entity.Mahasiswa;

public interface MahasiswaRepo extends JpaRepository<Mahasiswa, Long> {

}
