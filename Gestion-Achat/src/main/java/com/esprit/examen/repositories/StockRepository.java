package com.esprit.examen.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.esprit.examen.entities.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {

	@Query("SELECT s FROM Stock s where s.qte< s.qteMin")
	List<Stock> retrieveStatusStock();
}
