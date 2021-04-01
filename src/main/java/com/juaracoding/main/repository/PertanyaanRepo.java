package com.juaracoding.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juaracoding.main.entity.Pertanyaan;

public interface PertanyaanRepo extends JpaRepository<Pertanyaan, Long> {

}
