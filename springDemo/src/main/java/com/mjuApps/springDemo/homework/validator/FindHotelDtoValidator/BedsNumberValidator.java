package com.mjuApps.springDemo.homework.validator.FindHotelDtoValidator;

import com.mjuApps.springDemo.homework.dto.FindHotelDto;
import com.mjuApps.springDemo.homework.validator.Errors;
import com.mjuApps.springDemo.homework.validator.Validator;

public class BedsNumberValidator implements Validator{

    @Override
    public void validate(Object object, Errors errors) {
        FindHotelDto findHotelDto = (FindHotelDto) object;
        Integer bedsLowerLimit = findHotelDto.getBedsLowerLimit();
        Integer bedsUpperLimit = findHotelDto.getBedsUpperLimit();

        if (bedsLowerLimit!=null && bedsLowerLimit<1) {
            errors.addError("bedsLowerLimit","Lower limit can't be less then 0");
        }

        if (bedsUpperLimit!=null && bedsUpperLimit<1) {
            errors.addError("bedsUpperLimit","Upper limit can't be less then 0");
        }

        if (bedsLowerLimit!=null && bedsUpperLimit!=null && bedsLowerLimit>bedsUpperLimit) {
            errors.addError("bedsUpperLimit","Upper limit of beds (" + bedsUpperLimit + ") can't be less then lower limit (" + bedsLowerLimit + ")");
        }

    }
}
