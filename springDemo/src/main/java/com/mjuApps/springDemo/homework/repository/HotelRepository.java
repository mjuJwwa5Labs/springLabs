package com.mjuApps.springDemo.homework.repository;

import com.mjuApps.springDemo.homework.model.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author marek_j on 2018-04-18
 */
@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Integer> {




}
