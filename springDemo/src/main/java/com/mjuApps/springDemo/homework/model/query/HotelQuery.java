package com.mjuApps.springDemo.homework.model.query;

/**
 * @author marek_j on 2018-04-18
 */
public class HotelQuery {

    private Integer minBeds;
    private Integer maxBeds;
    private Integer minExtraBeds;
    private Integer maxExtraBeds;
    private String city;
    private String address;

    public HotelQuery() {}

    public HotelQuery(Integer minBeds, Integer maxBeds, Integer minExtraBeds, Integer maxExtraBeds, String city, String address) {
        this.minBeds = minBeds;
        this.maxBeds = maxBeds;
        this.minExtraBeds = minExtraBeds;
        this.maxExtraBeds = maxExtraBeds;
        this.city = city;
        this.address = address;
    }

    public HotelQuery(HotelQueryBuilder hotelQueryBuilder) {
        this.minBeds = hotelQueryBuilder.minBeds;
        this.maxBeds = hotelQueryBuilder.maxBeds;
        this.minExtraBeds = hotelQueryBuilder.minExtraBeds;
        this.maxExtraBeds = hotelQueryBuilder.maxExtraBeds;
        this.city = city;
        this.address = address;
    }

    public Integer getMinBeds() {return minBeds;}

    public Integer getMaxBeds() {return maxBeds;}

    public Integer getMinExtraBeds() {return minExtraBeds;}

    public Integer getMaxExtraBeds() {return maxExtraBeds;}

    public String getCity() {return city;}

    public String getAddress() {return address;}

    public static class HotelQueryBuilder {
        private Integer minBeds;
        private Integer maxBeds;
        private Integer minExtraBeds;
        private Integer maxExtraBeds;
        private String city;
        private String address;

        public HotelQueryBuilder withMinBedsWithNullOverwrite(Integer minBeds) {
            Integer bedsNumber = minBeds;
            if (bedsNumber==null) {
                bedsNumber=Integer.MIN_VALUE;
            }
            this.minBeds = bedsNumber;
            return this;
        }

        public HotelQueryBuilder withMaxBedsWithNullOverwrite(Integer maxBeds) {
            Integer bedsNumber = maxBeds;
            if (bedsNumber==null) {
                bedsNumber=Integer.MAX_VALUE;
            }
            this.maxBeds = bedsNumber;
            return this;
        }

        public HotelQueryBuilder withMinExtraBedsWithNullOverwrite(Integer minExtraBeds) {
            Integer bedsNumber = minExtraBeds;
            if (bedsNumber==null) {
                bedsNumber=Integer.MIN_VALUE;
            }
            this.minExtraBeds = bedsNumber;
            return this;
        }

        public HotelQueryBuilder withMaxExtraBedsWithNullOverwrite(Integer maxExtraBeds) {
            Integer bedsNumber = maxExtraBeds;
            if (bedsNumber==null) {
                bedsNumber=Integer.MAX_VALUE;
            }
            this.maxExtraBeds = bedsNumber;
            return this;
        }

        public HotelQueryBuilder withCity(String city) {
            this.city = city;
            return this;
        }

        public HotelQueryBuilder withAddress(String address) {
            this.address = address;
            return this;
        }

        public HotelQuery build() {
            return new HotelQuery(this);
        }

    }
}
