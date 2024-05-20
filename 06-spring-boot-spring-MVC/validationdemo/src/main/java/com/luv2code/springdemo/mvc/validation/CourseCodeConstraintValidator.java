package com.luv2code.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode,String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode theCourseCode) {
        //Assign the value passed in from our annotation
        coursePrefix = theCourseCode.value();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
        boolean result;
        if (theCode != null) {
            result = theCode.startsWith(coursePrefix);
        }
        else {
            result = true;
        }
        return  result;
    }
}
