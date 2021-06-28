package com.example.inventory.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventory.repository.produkRepository;
import com.example.inventory.exception.ResourceNotFoundException;
import com.example.inventory.model.Produk;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class produkController {
	@Autowired
	private produkRepository ProdukRepository;
	
	//mengambil data
	@GetMapping("/produks")
	public List <Produk> getAllProduks(){
		return ProdukRepository.findAll();
	}
	
	//menambah data
	@PostMapping("/produks")
	public Produk createProduk(@RequestBody Produk produk) {
		return ProdukRepository.save(produk);
	}
	
	// mengambil berdasrakan id
	@GetMapping("/produks/{id}")
	public ResponseEntity <Produk> getProdukById(@PathVariable Long id){
		Produk produk = ProdukRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Produk tidak di temukan dengan ID :"+id)); 
		return ResponseEntity.ok(produk); 
	}
	//mengedit data atau update data
	@PutMapping("/produks/{id}")
	public ResponseEntity<Produk> updateProduk(@PathVariable Long id,@RequestBody Produk produkDetails){
		Produk produk = ProdukRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Produk tidak di temukan dengan ID :"+id));
		produk.setNama(produkDetails.getNama());
		produk.setDeskripsi(produkDetails.getDeskripsi());
		produk.setHargaBeli(produkDetails.getHargaBeli());
		produk.setStock(produkDetails.getStock());
		
		Produk updateProduk = ProdukRepository.save(produk);
		
		return ResponseEntity.ok(produk);
		
	}
	//  menghapus data
	@DeleteMapping("/produks/{id}")
	public ResponseEntity<Map <String, Boolean>>
	deleteProduk(@PathVariable Long id){
		 Produk produk = ProdukRepository.findById(id)
				 .orElseThrow(()-> new ResourceNotFoundException("Produk tidak di temukan dengan ID :"+id));
		 ProdukRepository.delete(produk);
		 Map <String , Boolean > response = new HashMap<>();
		 response.put("deleted", Boolean.TRUE);
		 return ResponseEntity.ok(response);
	}
}
