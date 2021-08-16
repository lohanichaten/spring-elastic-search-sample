package learning.elastic.common.exception.handler;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import learning.elastic.common.exception.IllegalApiParamException;
import learning.elastic.common.model.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(value=IllegalApiParamException.class)
	private ResponseEntity<ErrorResponse> handleIllegalApiParamException(IllegalApiParamException e) {
		var message = "Exception API Param from MyGlobalExceptionHandler, " + e.getMessage();
		LOG.warn(message);

		var errorResponse = new ErrorResponse(message, LocalDateTime.now());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}
}
