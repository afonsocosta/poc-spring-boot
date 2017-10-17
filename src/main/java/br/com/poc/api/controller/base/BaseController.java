package br.com.poc.api.controller.base;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {

      @Autowired
      protected ModelMapper modelMapper;

      protected List<?> convertListDTO(List<?> list, Class<?> clazz){
            return StreamSupport.stream(list.spliterator(), false)
                    .map(programacao -> modelMapper.map(programacao, clazz))
                    .collect(Collectors.toList());
      }
      
      protected Object buildDTO(Object object, Class<?> clazz){
    	  
    	  if(object != null){
    		return modelMapper.map(object, clazz);
    	  }
    	   
    	  return null;
      }

}