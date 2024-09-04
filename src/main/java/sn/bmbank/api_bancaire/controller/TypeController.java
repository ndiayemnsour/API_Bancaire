package sn.bmbank.api_bancaire.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sn.bmbank.api_bancaire.model.Type;
import sn.bmbank.api_bancaire.service.TypeService;

@RestController
@RequestMapping("/type/")
public class TypeController {
    
   @Autowired
    private TypeService typeService;
    
    //Endpoint pour recuperer tous les types
    @GetMapping("all")
    public List<Type> getAllType() {
        return typeService.getAllType();
    }

    //Endpoint pour recuperer un Type par son ID
    @GetMapping("{id_type}")
        public Type getTypeById(@PathVariable String id_type){
            return typeService.getTypeById(id_type);
        }
    
    //Endpoint pour  ajouter un Type
    @PostMapping("add")
    public Type addType(@RequestBody Type type){
        return typeService.addType(type);
    }

}
