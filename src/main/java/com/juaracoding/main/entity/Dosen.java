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
@Table(name="dosen")
public class Dosen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_dosen;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="nama_dosen")
	private String nama;
	
//	@OneToMany(cascade=CascadeType.ALL)
//	@JoinColumn(name="id_dosen", referencedColumnName = "id_dosen")
//	Set<PlotMataKuliah> lstPlot ;
	
	@ManyToMany(mappedBy = "dosen", fetch = FetchType.LAZY)
	private List<MataKuliah> matakuliah = new ArrayList<MataKuliah>();
}
