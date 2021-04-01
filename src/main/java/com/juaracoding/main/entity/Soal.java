package com.juaracoding.main.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="soal")
public class Soal {

	@Id
	@GeneratedValue
	private long id_soal;
	private String nama_soal;
	private int status;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="id_soal", referencedColumnName = "id_soal")
	private List<Pertanyaan> lstPertanyaan = new ArrayList<Pertanyaan>();
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name= "nilai",
		joinColumns = {
			@JoinColumn(name= "id_soal", referencedColumnName = "id_soal",
					nullable = false, updatable = false)},
		inverseJoinColumns = {
			@JoinColumn(name="nim", referencedColumnName = "nim", 
					nullable = false, updatable = false )})
	private List<Mahasiswa> mahasiswa = new ArrayList<Mahasiswa>();
}
