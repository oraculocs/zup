package com.orangetalents.zup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orangetalents.zup.entities.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{
	

}
