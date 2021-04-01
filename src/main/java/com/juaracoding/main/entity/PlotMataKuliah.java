package com.juaracoding.main.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="plot_mata_kuliah")
public class PlotMataKuliah {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_plot_mk;

//	@ManyToOne
//	@JoinColumn(name="nim")
//	Mahasiswa mahasiswa;
//	
//	@ManyToOne
//	@JoinColumn(name="id_dosen")
//	Dosen dosen;
//	
//	@ManyToOne
//	@JoinColumn(name="id_mata_kuliah")
//	MataKuliah mataKuliah;
//	
}
