package edu.awieclawski.jpa.sppt;

import org.springframework.beans.PropertyAccessException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DefaultBindingErrorProcessor;
import org.springframework.validation.FieldError;

public class CustomBindingErrorProcessor extends DefaultBindingErrorProcessor {

    public void processPropertyAccessException(PropertyAccessException accessException, 
                                               BindingResult bindingResult) {

    	// overwrites NumberFormatException error message
        if(accessException.getCause() instanceof NumberFormatException){

            String fieldName = accessException.getPropertyChangeEvent().getPropertyName();
            String exceptionError = accessException.getCause().getMessage();

            FieldError fieldError = new FieldError(fieldName,
                                                   "BINDING_ERROR", 
                                                   fieldName + ": " + exceptionError);

            bindingResult.addError(fieldError);
        }else{
            super.processPropertyAccessException(accessException, bindingResult);
        }

    }

}      
