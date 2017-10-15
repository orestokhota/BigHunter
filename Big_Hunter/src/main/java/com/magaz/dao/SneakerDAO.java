package com.magaz.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.magaz.entity.Brend;
import com.magaz.entity.Sneaker;

public interface SneakerDAO extends JpaRepository<Sneaker, Integer> {
	@Query("select s from Sneaker s left join fetch s.brends where s.id=:id")
	Sneaker sneakerWithBrend(@Param("id") int id);

	@Query("select s from Sneaker s left join fetch s.types where s.id=:id")
	Sneaker sneakerWithType(@Param("id") int id);

	@Query("select s from Sneaker s left join fetch s.size where s.id=:id")
	Sneaker sneakerWithSize(@Param("id") int id);

	@Query("select s from Sneaker s left join fetch s.models where s.id=:id")
	Sneaker findSneakerWithModel(@Param("id") int id);

	@Query("select s from Sneaker s left join fetch s.brends ")
	Set<Sneaker> sneakerWithBrends();

	@Query("select s from Sneaker s left join fetch s.models")
	Set<Sneaker> sneakerWithModels();

	@Query("select s from Sneaker s left join fetch s.types ")
	Set<Sneaker> sneakerWithTypes();

	@Query("select s from Sneaker s left join fetch s.size")
	Set<Sneaker> sneakerWithSizes();

	@Query(value = "select distinct s from Sneaker s left join fetch s.models",
			countQuery = "SELECT count(*) FROM Sneaker s join s.models")
	Page<Sneaker> sneakerWithModelsPages(Pageable pageable);

	@Query("select s from Sneaker s left join fetch s.orderSneakers")
	Set<Sneaker> sneakerWithOrderSneakers();

	@Query("select s from Sneaker s left join fetch s.orderSneakers where s.id=:id")
	Sneaker sneakerWithOrderSneaker(@Param("id") int id);

}
