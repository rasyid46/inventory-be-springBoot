package com.example.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.inventory.model.Produk;
@Repository
public interface produkRepository  extends JpaRepository<Produk, Long>{

}
