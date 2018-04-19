package com.mjuApps.springDemo.homework.model.query;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * @author marek_j on 2018-04-18
 */
public class HotelQuery {

    private Integer minBeds;
    private Integer maxBeds;
    private Integer minExtraBeds;
    private Integer maxExtrsBeds;
    private String city;
    private String address;

    public HotelQuery() {}

    public HotelQuery(Integer minBeds, Integer maxBeds, Integer minExtraBeds, Integer maxExtrsBeds, String city, String address) {
        this.minBeds = minBeds;
        this.maxBeds = maxBeds;
        this.minExtraBeds = minExtraBeds;
        this.maxExtrsBeds = maxExtrsBeds;
        this.city = city;
        this.address = address;
    }

    public Integer getMinBeds() {
        return minBeds;
    }

    public Integer getMaxBeds() {
        return maxBeds;
    }

    public Integer getMinExtraBeds() {
        return minExtraBeds;
    }

    public Integer getMaxExtrsBeds() {
        return maxExtrsBeds;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }
}
