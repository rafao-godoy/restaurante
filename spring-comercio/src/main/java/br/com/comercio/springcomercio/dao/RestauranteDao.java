package br.com.comercio.springcomercio.dao;

import br.com.comercio.springcomercio.entity.Restaurante;
import java.util.Collection;

public interface RestauranteDao {

    Collection<Restaurante> getAllRestaurantes();

    Restaurante getRestauranteByCodigo_restaurante(int codigo_restaurante);

    void removeRestauranteByCodigo_restaurante(int codigo_restaurante);

    void updateRestaurante(Restaurante restaurante);

    void insertRestauranteToDb(Restaurante restaurante);
}
