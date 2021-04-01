package com.juaracoding.main.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
@Table(name="mata_kuliah")
public class MataKuliah {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nama_mata_kuliah;
	
//	@OneToMany(cascade=CascadeType.ALL)
//	@JoinColumn(name="id_mata_kuliah", referencedColumnName = "id")
//	Set <PlotMataKuliah> lstPlot ;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name= "plot_mata_kuliah",
		joinColumns = {
			@JoinColumn(name= "id_mata_kuliah", referencedColumnName = "id",
					nullable = false, updatable = false)},
		inverseJoinColumns = {
			@JoinColumn(name="id_dosen", referencedColumnName = "id_dosen", 
					nullable = false, updatable = false )})
	private List<Dosen> dosen = new ArrayList<Dosen>();
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name= "plot_mata_kuliah",
		joinColumns = {
			@JoinColumn(name= "id_mata_kuliah", referencedColumnName = "id",
					nullable = false, updatable = false)},
		inverseJoinColumns = {
		@JoinColumn(name="nim", referencedColumnName = "nim", 
					nullable = false, updatable = false )})
	private List<Mahasiswa> mahasiswa = new ArrayList<Mahasiswa>();
	
	
}
