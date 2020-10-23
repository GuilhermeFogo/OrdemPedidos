package PedidoPJa.APIOrder.exeptionhandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import PedidoPJa.APIOrder.dominio.exeption.BussinesExeption;

@ControllerAdvice
public class ApiExeptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private MessageSource messageSource;
	
	@ExceptionHandler(BussinesExeption.class)
	public ResponseEntity<Object> handleBussiness(BussinesExeption ex, WebRequest request) {
		var status = HttpStatus.BAD_REQUEST;
		var problema= new Problem();
		problema.setStatus(status.value());
		problema.setTitle(ex.getMessage());
		problema.setDateHour(OffsetDateTime.now());
		
		return handleExceptionInternal(ex, problema, new HttpHeaders(), status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		var campos = new ArrayList<Problem.Campo>();
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			
			String nome = ((FieldError) error).getObjectName();
			String msg = messageSource.getMessage(error, LocaleContextHolder.getLocale());
			
			campos.add(new Problem.Campo(nome, msg));
		}
		
		var problema  = new Problem();
		problema.setStatus(status.value());
		problema.setTitle("Um ou mais campos estão invalidos");
		problema.setDateHour(OffsetDateTime.now());
		problema.setCampos(campos);
		
		return super.handleExceptionInternal(ex, problema, headers, status, request);
	}
}
