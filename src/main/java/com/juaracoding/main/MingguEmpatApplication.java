package com.juaracoding.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.juaracoding.main.entity.Admin;
import com.juaracoding.main.entity.Dosen;
import com.juaracoding.main.entity.Mahasiswa;
import com.juaracoding.main.entity.MataKuliah;
import com.juaracoding.main.entity.Nilai;
import com.juaracoding.main.entity.Pertanyaan;
import com.juaracoding.main.entity.Soal;
import com.juaracoding.main.repository.AdminRepo;
import com.juaracoding.main.repository.DosenRepo;
import com.juaracoding.main.repository.MahasiswaRepo;
import com.juaracoding.main.repository.MataKuliahRepo;
import com.juaracoding.main.repository.NilaiRepo;
import com.juaracoding.main.repository.PertanyaanRepo;
import com.juaracoding.main.repository.PlotMataKuliahRepo;
import com.juaracoding.main.repository.SoalRepo;

@SpringBootApplication
public class MingguEmpatApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(MingguEmpatApplication.class, args);
	}
	
	@Autowired
	AdminRepo adminRepo;
	@Autowired
	MataKuliahRepo matakuliahRepo;
	@Autowired
	DosenRepo dosenRepo;
	@Autowired
	MahasiswaRepo mahasiswaRepo;
	@Autowired
	NilaiRepo nilaiRepo;
	@Autowired
	SoalRepo soalRepo;
	@Autowired
	PertanyaanRepo pertanyaanRepo;
	@Autowired
	PlotMataKuliahRepo plotMatakuliahRepo;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//  -------------------------ONE TO MANY-------------------------------------------------
		Soal soal = new Soal();
		soal.setNama_soal("Matematika");
		soal.setStatus(1);
		
		Pertanyaan pertanyaan1 = new Pertanyaan();
		pertanyaan1.setPertanyaan("1+1=");
		pertanyaan1.setJawaban_1("1");
		pertanyaan1.setJawaban_2("2");
		pertanyaan1.setJawaban_3("3");
		pertanyaan1.setJawaban_4("4");
		pertanyaan1.setJawaban_benar("2");
		pertanyaan1.setStatus_gambar(1);
		
		Pertanyaan pertanyaan2 = new Pertanyaan();
		pertanyaan2.setPertanyaan("1-1=");
		pertanyaan2.setJawaban_1("0");
		pertanyaan2.setJawaban_2("1");
		pertanyaan2.setJawaban_3("2");
		pertanyaan2.setJawaban_4("3");
		pertanyaan2.setJawaban_benar("0");
		pertanyaan2.setStatus_gambar(2);
		
		Pertanyaan pertanyaan3 = new Pertanyaan();
		pertanyaan3.setPertanyaan("5+5=");
		pertanyaan3.setJawaban_1("10");
		pertanyaan3.setJawaban_2("11");
		pertanyaan3.setJawaban_3("12");
		pertanyaan3.setJawaban_4("13");
		pertanyaan3.setJawaban_benar("10");
		pertanyaan3.setStatus_gambar(3);
		
		List<Pertanyaan> lstPertanyaan = new ArrayList<Pertanyaan>();
		lstPertanyaan.add(pertanyaan1);
		lstPertanyaan.add(pertanyaan2);
		lstPertanyaan.add(pertanyaan3);
		soal.setLstPertanyaan(lstPertanyaan);
		
		this.soalRepo.save(soal);
		this.pertanyaanRepo.saveAll(lstPertanyaan);
		
//  -------------------------MANY TO MANY------------------------------------------------
		
		Admin admin1 = new Admin();
		admin1.setUsername("Dahyun");
		admin1.setPassword("twice");
		
		Admin admin2 = new Admin();
		admin2.setUsername("Lisa");
		admin2.setPassword("blackpink");
		
		MataKuliah matakuliah1 = new MataKuliah();
		matakuliah1.setNama_mata_kuliah("Pemrograman Berbasis Objek");
		
		MataKuliah matakuliah2 = new MataKuliah();
		matakuliah2.setNama_mata_kuliah("Pemrograman Berbasis Web");
		
		Dosen dosen1 = new Dosen();
		dosen1.setNama("Budi");
		dosen1.setUsername("BudiOke");
		dosen1.setPassword("BudiGanteng");
		
		Dosen dosen2 = new Dosen();
		dosen2.setNama("Udin");
		dosen2.setUsername("UdinSedunia");
		dosen2.setPassword("Udin123");
		
		Mahasiswa mahasiswa1 = new Mahasiswa();
		mahasiswa1.setNama("Nyoman");
		mahasiswa1.setJk("Laki-Laki");
		mahasiswa1.setPassword("apahayo");
		
		Mahasiswa mahasiswa2 = new Mahasiswa();
		mahasiswa2.setNama("Wicaksana");
		mahasiswa2.setJk("Laki-Laki");
		mahasiswa2.setPassword("apaajaboleh");
		
//		Nilai nilai1 = new Nilai();
//		nilai1.setNilai(99);
//		
//		Nilai nilai2 = new Nilai();
//		nilai2.setNilai(99);
//		
//		List<Nilai> lstNilai = new ArrayList<Nilai>();
//		lstNilai.add(nilai1);
//		lstNilai.add(nilai2);
//		this.nilaiRepo.saveAll(lstNilai);
		
		List<Admin> lstAdmin = new ArrayList<Admin>();
		lstAdmin.add(admin1);
		lstAdmin.add(admin2);
		this.adminRepo.saveAll(lstAdmin);
		
		List<Mahasiswa> lstMahasiswa1 = new ArrayList<Mahasiswa>();
		lstMahasiswa1.add(mahasiswa1);
		matakuliah1.setMahasiswa(lstMahasiswa1);
		
		List<Mahasiswa> lstMahasiswa2 = new ArrayList<Mahasiswa>();
		lstMahasiswa2.add(mahasiswa2);
		matakuliah2.setMahasiswa(lstMahasiswa2);
		
		List<Dosen> lstDosen1 = new ArrayList<Dosen>();
		lstDosen1.add(dosen1);
		matakuliah1.setDosen(lstDosen1);
		
		List<Dosen> lstDosen2 = new ArrayList<Dosen>();
		lstDosen2.add(dosen2);
		matakuliah2.setDosen(lstDosen2);
		
		List<MataKuliah> lstMatakuliah = new ArrayList<MataKuliah>();
		lstMatakuliah.add(matakuliah2);
		lstMatakuliah.add(matakuliah1);
		this.matakuliahRepo.saveAll(lstMatakuliah);
		
//		List<Nilai> lstNilai1 = new ArrayList<Nilai>();
//		lstNilai1.add(nilai1);
//		lstNilai1.add(nilai2);
//		this.nilaiRepo.saveAll(lstNilai1);
	}

}
