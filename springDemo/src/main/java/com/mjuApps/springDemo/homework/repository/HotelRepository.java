package com.mjuApps.springDemo.homework.repository;

import com.mjuApps.springDemo.homework.model.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author marek_j on 2018-04-18
 */
@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Integer> {

//    @Query("select h from HotelEntity h join RoomEntity r on h = r.hotelEntity where (r.beds between :minBeds and :maxBeds) or (r.extraBeds between :minExtraBeds and :maxExtraBeds)")
//    List<HotelEntity> findHotelByQuery(@Param("minBeds") Integer minBeds,
//                                       @Param("maxBeds") Integer maxBeds,
//                                       @Param("minExtraBeds") Integer minExtraBeds,
//                                       @Param("maxExtraBeds") Integer maxExtraBeds);

    //find by template
    //


}
