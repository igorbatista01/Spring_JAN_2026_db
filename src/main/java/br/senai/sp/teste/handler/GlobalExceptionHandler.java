package br.senai.sp.teste.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import br.senai.sp.teste.exception.EntityInUseException;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(EntityInUseException.class)
    public ModelAndView handleEntityInUseException(EntityInUseException ex) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("status", 409);
        modelAndView.addObject("error", "Operação Não Permitida");
        modelAndView.addObject("message", ex.getMessage());
        return modelAndView;
    }
    
    @ExceptionHandler(Exception.class)
    public ModelAndView handleGenericException(Exception ex) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("status", 500);
        modelAndView.addObject("error", "Erro Interno do Servidor");
        modelAndView.addObject("message", "Ocorreu um erro inesperado. Por favor, tente novamente.");
        modelAndView.addObject("exception", ex.getMessage());
        return modelAndView;
    }
}
