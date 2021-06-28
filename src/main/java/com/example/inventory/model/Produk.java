package com.example.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="produk")
public class Produk {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   
   @Column(name = "nama")
   private String nama;
   
   @Column(name = "deskripsi")
   private String deskripsi;
   
   @Column(name ="harga_beli")
   private double hargaBeli;
   
   @Column(name ="stock")
   private int stock;

   public Produk() {
   }
	public Produk(long id, String nama, String deskripsi, double hargaBeli, int stock) {
		super();
		this.id = id;
		this.nama = nama;
		this.deskripsi = deskripsi;
		this.hargaBeli = hargaBeli;
		this.stock = stock;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getDeskripsi() {
		return deskripsi;
	}

	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}

	public double getHargaBeli() {
		return hargaBeli;
	}

	public void setHargaBeli(double hargaBeli) {
		this.hargaBeli = hargaBeli;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	 
 
}
