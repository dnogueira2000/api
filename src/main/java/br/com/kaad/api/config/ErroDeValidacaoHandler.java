/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.kaad.api.config;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import br.com.kaad.api.dto.ErroDeFormularioDto;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * @author diego.nogueira
 */
@RestControllerAdvice
public class ErroDeValidacaoHandler {
    
    @Autowired
    private MessageSource messageSource;
    
    //faz devolver erro 400
    @ExceptionHandler(MethodArgumentNotValidException.class)
    // paramentro usado para validacao de formulario
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public List<ErroDeFormularioDto> handle(MethodArgumentNotValidException exception) {
        List<ErroDeFormularioDto> dto = new ArrayList<>();
        
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        
        for(FieldError f : fieldErrors) {
            //pega msg no idioma correto
            String mensagem = messageSource.getMessage(f, LocaleContextHolder.getLocale());
            
            ErroDeFormularioDto erro = new ErroDeFormularioDto(f.getField(), mensagem);
            dto.add(erro);
        }
        
       return dto;
    }
}
