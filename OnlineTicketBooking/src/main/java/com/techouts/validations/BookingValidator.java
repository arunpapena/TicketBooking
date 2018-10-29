package com.techouts.validations;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.techouts.ticketbooking.models.SourceDestination;
@Component
public class BookingValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return SourceDestination.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {

		final String TOADDRESS="toAddress";
		SourceDestination sourceDestination=(SourceDestination) target;
		String from=sourceDestination.getFromAddress();
		String to=sourceDestination.getToAddress();
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fromAddress", "sourceDestination.from.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, TOADDRESS,"sourceDestination.to.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "date","sourceDestination.date.empty");
		if(!from.matches("^[a-zA-Z_ ]*$"))
			{
	            errors.rejectValue("fromAddress", "sourceDestination.from.invalid");
	        }
		if(!to.matches("^[a-zA-Z_ ]*$"))
		{
            errors.rejectValue(TOADDRESS, "sourceDestination.to.invalid");
        }
		if(from.equals(to)){
			errors.rejectValue(TOADDRESS, "sourceDestination.to.same");
		}
	}

}
