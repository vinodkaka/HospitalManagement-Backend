
  package com.spring.exception;
  
  import java.util.Date;
  
  import org.springframework.http.HttpStatus; import
  org.springframework.http.ResponseEntity; import
  org.springframework.web.bind.annotation.ControllerAdvice; import
  org.springframework.web.bind.annotation.ExceptionHandler; import
  org.springframework.web.context.request.WebRequest;
  
  @ControllerAdvice 
  
  public class GlobalExceptionHandler {

		@ExceptionHandler(DataNotFoundException.class)
	    public ResponseEntity<?> resourceNotFoundException(DataNotFoundException ex,WebRequest request)
	    {      
			ErrorDetails errorDetails=new ErrorDetails(ex.getMessage(),HttpStatus.NOT_FOUND.value());
	    return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
	    }
  
  }
 