package com.mjuApps.springDemo.homework.repository;

import com.mjuApps.springDemo.homework.model.entity.HotelEntity;

import java.util.List;

/**
 * @author marek_j on 2018-04-20
 */
public interface HotelQueryRepository {

    List<HotelEntity> findHotelByQuery(Integer minBeds, Integer maxBeds, Integer minExtraBeds, Integer maxExtraBeds);

}
