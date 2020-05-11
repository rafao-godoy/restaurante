package br.com.comercio.springcomercio.service;

import br.com.comercio.springcomercio.dao.MySqlRestauranteDaoImpl;
import br.com.comercio.springcomercio.dao.RestauranteDao;
import br.com.comercio.springcomercio.dao.RestauranteDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class RestauranteService {

    @Autowired
    @Qualifier("mysql")
    private MySqlRestauranteDaoImpl mySqlRestauranteDao;

    public Collection<br.com.comercio.springcomercio.entity.Restaurante> getAllRestaurantes(){
        return this.mySqlRestauranteDao.getAllRestaurantes();
    }


    public br.com.comercio.springcomercio.entity.Restaurante getRestauranteByCodigo_restaurante(int codigo_restaurante){
        return this.mySqlRestauranteDao.getRestauranteByCodigo_restaurante(codigo_restaurante);
    }


    public void removeRestauranteByCodigo_restaurante(int codigo_restaurante) {
        this.mySqlRestauranteDao.removeRestauranteByCodigo_restaurante(codigo_restaurante);
    }


    public void updateRestaurante(br.com.comercio.springcomercio.entity.Restaurante restaurante){
        this.mySqlRestauranteDao.updateRestaurante(restaurante);
    }


    public void insertRestaurante(br.com.comercio.springcomercio.entity.Restaurante restaurante) {
        this.mySqlRestauranteDao.insertRestauranteToDb(restaurante);

    }


}
