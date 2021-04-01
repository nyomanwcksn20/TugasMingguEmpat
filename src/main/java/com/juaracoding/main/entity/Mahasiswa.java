package com.juaracoding.main.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name="mahasiswa")
public class Mahasiswa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long nim;
	@Column(name="nama_mahasiswa")
	private String nama;
	@Column(name="jenis_kelamin")
	private String jk;
	@Column(name="password")
	private String password;
	
//	@OneToMany(cascade=CascadeType.ALL)
//	@JoinColumn(name="nim", referencedColumnName = "nim")
//	Set<PlotMataKuliah> lstPlot ;
	
	
	@ManyToMany(mappedBy = "mahasiswa", fetch = FetchType.LAZY)
	private List<MataKuliah> matakuliah = new ArrayList<MataKuliah>();
	
	@ManyToMany(mappedBy = "mahasiswa", fetch = FetchType.LAZY)
	private List<Soal> matakuliahh = new ArrayList<Soal>();
}
