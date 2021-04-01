package com.juaracoding.main.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="pertanyaan")
public class Pertanyaan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_pertanyaan;
	private String pertanyaan;
	private String jawaban_1;
	private String jawaban_2;
	private String jawaban_3;
	private String jawaban_4;
	private String jawaban_benar;
	private int status_gambar;
}
