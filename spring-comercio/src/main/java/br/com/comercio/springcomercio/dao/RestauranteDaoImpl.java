package br.com.comercio.springcomercio.dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("restauranteDao")
public class RestauranteDaoImpl implements RestauranteDao{

    private static Map<Integer, br.com.comercio.springcomercio.entity.Restaurante> restaurantes;

    static {

        restaurantes = new HashMap<Integer, br.com.comercio.springcomercio.entity.Restaurante>(){

            {
                put(1, new br.com.comercio.springcomercio.entity.Restaurante(1, "ara", "rebaba", "boliboli", "lala"));
                put(2, new br.com.comercio.springcomercio.entity.Restaurante(2, "italian", "italiana", "sp", "lolo"));
                put(3, new br.com.comercio.springcomercio.entity.Restaurante(3, "brasilian", "brasileira", "ba", "lili"));
            }
        };
    }

    @Override
    public Collection<br.com.comercio.springcomercio.entity.Restaurante> getAllRestaurantes(){
        return this.restaurantes.values();
    }


    @Override
    public br.com.comercio.springcomercio.entity.Restaurante getRestauranteByCodigo_restaurante(int codigo_restaurante){
        return this.restaurantes.get(codigo_restaurante);
    }

   @Override
    public void removeRestauranteByCodigo_restaurante(int codigo_restaurante) {
        this.restaurantes.remove(codigo_restaurante);
    }



    @Override
    public void updateRestaurante(br.com.comercio.springcomercio.entity.Restaurante restaurante){
        br.com.comercio.springcomercio.entity.Restaurante s = restaurantes.get(restaurante.getCodigo_restaurante());
        s.setNome_restaurante(restaurante.getNome_restaurante());
        s.setTipo_comida(restaurante.getTipo_comida());
        s.setEstado(restaurante.getEstado());
        s.setCidade(restaurante.getCidade());
        restaurantes.put(restaurante.getCodigo_restaurante(), restaurante);
    }


    @Override
    public void insertRestauranteToDb(br.com.comercio.springcomercio.entity.Restaurante restaurante) {
        this.restaurantes.put(restaurante.getCodigo_restaurante(), restaurante);
    }



}
