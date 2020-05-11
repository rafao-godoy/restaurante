package br.com.comercio.springcomercio.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/restaurante")
public class RestauranteController {

    @Autowired
    private br.com.comercio.springcomercio.service.RestauranteService restauranteService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<br.com.comercio.springcomercio.entity.Restaurante> getAllRestaurantes(){
        return restauranteService.getAllRestaurantes();
    }

    @RequestMapping(value = "/{codigo_restaurante}", method = RequestMethod.GET)
    public br.com.comercio.springcomercio.entity.Restaurante getRestauranteByCodigo_restaurante(@PathVariable("codigo_restaurante") int codigo_restaurante){
        return restauranteService.getRestauranteByCodigo_restaurante(codigo_restaurante);
    }



    @RequestMapping(value = "/{codigo_restaurante}", method = RequestMethod.DELETE)
    public void deleteRestauranteByCodigoId(@PathVariable("codigo_restaurante") int codigo_restaurante){
        restauranteService.removeRestauranteByCodigo_restaurante(codigo_restaurante);
    }


    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateRestaurante(@RequestBody br.com.comercio.springcomercio.entity.Restaurante codigo_restaurante){
        restauranteService.updateRestaurante(codigo_restaurante);
    }


    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertRestaurante(@RequestBody br.com.comercio.springcomercio.entity.Restaurante codigo_restaurante){
        restauranteService.insertRestaurante(codigo_restaurante);
    }


}
