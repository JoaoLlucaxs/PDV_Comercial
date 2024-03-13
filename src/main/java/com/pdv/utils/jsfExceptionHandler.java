package com.pdv.utils;

import com.pdv.exceptions.NegocioException;

import javax.faces.FacesException;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;


import java.io.IOException;
import java.util.Iterator;

public class jsfExceptionHandler extends ExceptionHandlerWrapper {
    // JSF já tem um tratador de exceção por padrão
    // esta classe será um tratador de exceções uma cada acima do padrão do jsf onde terá prioridade
    // trato todas as exceções que posso aqui, caso eu não possa tratar o próprio irá jogar para o JSF tratar

    private ExceptionHandler wrapped;

    public jsfExceptionHandler(ExceptionHandler wrapped){
        this.wrapped=wrapped;
    }
    @Override
    public ExceptionHandler getWrapped() { // retorna tratador de exceção empacotado
        return this.wrapped;
    }

    // Este método será chamado quando existir alguma exceção, e responsavél por tratar quando o jsf conseguir capturar
    @Override
    public void handle() throws FacesException {
        Iterator<ExceptionQueuedEvent> events=getHandledExceptionQueuedEvents().iterator();

        // enquanto houver
        while(events.hasNext()){
            ExceptionQueuedEvent event=events.next();
            ExceptionQueuedEventContext context=(ExceptionQueuedEventContext) event.getSource();

          Throwable exception= context.getException();
          NegocioException negocioException=getNegocioException(exception);

          boolean handled=false; //exceção não tratada

            try {
              if (exception instanceof ViewExpiredException) {
                  handled = true;
                  redirect("/");
              }else if(negocioException != null) {
            	  handled=true;
            	  FacesUtil.addErrorMessage(negocioException.getMessage());
              }else{
                  handled=true;
                  redirect("/Erro.xhtml");
              }
          }finally {
              if(handled) {
                  events.remove();
              }
          }
        }
        //após finalizar todo o tratamento
        getWrapped().handle();
    }
    
    private NegocioException getNegocioException(Throwable exception) {
    	if(exception instanceof NegocioException) {
    		return (NegocioException) exception;
    	}else if(exception.getCause() != null){
    		return getNegocioException(exception.getCause());
    	}
    	return null;
    }

    private void redirect(String page){
        // Código para retornar a raiz do contexto da aplicação
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();
            //(/SistemComercial)
            String contextPath = externalContext.getRequestContextPath();

            externalContext.redirect(contextPath + page);
            //Informando que está correto para evitar qualquer outro ciclo de vida do jsf
            facesContext.responseComplete();
        }catch (IOException exception){
            throw new FacesException(exception);
        }
    }
}
