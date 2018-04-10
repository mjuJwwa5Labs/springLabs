package com.mjuApps.springDemo.homework.dto;

import org.springframework.util.StringUtils;

import java.util.function.Function;

public class FindHotelDto {

    private String name;
    private String address;
    private Integer bedsLowerLimit;
    private Integer bedsUpperLimit;
    private Integer extraBedsLowerLimit;
    private Integer extraBedsUpperLimit;

    public FindHotelDto() { }

    public FindHotelDto(FindHotelDtoBuilder findHotelDtoBuilder) {
        name = findHotelDtoBuilder.name;
        address = findHotelDtoBuilder.address;
        bedsLowerLimit = findHotelDtoBuilder.bedsLowerLimit;
        bedsUpperLimit = findHotelDtoBuilder.bedsUpperLimit;
        extraBedsLowerLimit = findHotelDtoBuilder.extraBedsLowerLimit;
        extraBedsUpperLimit = findHotelDtoBuilder.extraBedsUpperLimit;
    }

    public String getName() {  return name; }
    public String getAddress() { return address; }
    public Integer getBedsLowerLimit() { return bedsLowerLimit; }
    public Integer getBedsUpperLimit() { return bedsUpperLimit; }
    public Integer getExtraBedsLowerLimit() { return extraBedsLowerLimit; }
    public Integer getExtraBedsUpperLimit() { return extraBedsUpperLimit; }

    public static class FindHotelDtoBuilder implements Function<String,Integer> {
        private String name;
        private String address;
        private Integer bedsLowerLimit;
        private Integer bedsUpperLimit;
        private Integer extraBedsLowerLimit;
        private Integer extraBedsUpperLimit;

        public FindHotelDtoBuilder withName(String name) {
            if (StringUtils.isEmpty(name)) {
                this.name = null;
            } else {
                this.name = name;
            }
            return this;
        }

        public FindHotelDtoBuilder withAddress(String address) {
            if (StringUtils.isEmpty(address)) {
                this.address = null;
            } else {
                this.address = address;
            }
            return this;
        }

        public FindHotelDtoBuilder withBedsLowerLimitAsString(String bedsLowerLimit) {
            this.bedsLowerLimit = this.apply(bedsLowerLimit);
            return this;
        }

        public FindHotelDtoBuilder withBedsUpperLimitAsString(String bedsUpperLimit) {
            this.bedsUpperLimit = this.apply(bedsUpperLimit);
            return this;
        }

        public FindHotelDtoBuilder withExtraBedsLowerLimitAsString(String extraBedsLowerLimit) {
            this.extraBedsLowerLimit = this.apply(extraBedsLowerLimit);
            return this;
        }

        public FindHotelDtoBuilder withExtraBedsUpperLimitAsString(String extraBedsUpperLimit) {
            this.extraBedsUpperLimit = this.apply(extraBedsUpperLimit);
            return this;
        }

        public FindHotelDto build() {
            return new FindHotelDto(this);
        }

        @Override
        public Integer apply(String s) {
            if (!StringUtils.isEmpty(s)) {
                Integer value = Integer.valueOf(s);
                return value;
            }
            return null;
        }
    }

}
