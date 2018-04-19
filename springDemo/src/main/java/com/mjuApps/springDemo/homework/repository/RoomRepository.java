package com.mjuApps.springDemo.homework.repository;

import com.mjuApps.springDemo.homework.model.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author marek_j on 2018-04-18
 */
@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, Integer>{

    Optional<RoomEntity> findByIdAndRoomNumber(Integer hotelId, Integer roomNumber);
}
