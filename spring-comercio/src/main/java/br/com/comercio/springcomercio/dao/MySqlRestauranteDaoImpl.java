package br.com.comercio.springcomercio.dao;

import br.com.comercio.springcomercio.entity.Restaurante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Repository
@Qualifier("mysql")
public class MySqlRestauranteDaoImpl implements RestauranteDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Collection<Restaurante> getAllRestaurantes() {
 //       SELECT column_name(s) FROM table_name
        final String sql = "SELECT codigo_restaurante, nome_restaurante, tipo_comida, estado, cidade FROM RESTAURANTE";
        List<Restaurante> restaurantes = jdbcTemplate.query(sql, new RowMapper<Restaurante>() {
            @Override
            public Restaurante mapRow(ResultSet resultSet, int i) throws SQLException {
                Restaurante restaurante = new Restaurante();
                restaurante.setCodigo_restaurante(resultSet.getInt("codigo_restaurante"));
                restaurante.setNome_restaurante(resultSet.getString("nome_restaurante"));
                restaurante.setTipo_comida(resultSet.getString("tipo_comida"));
                restaurante.setEstado(resultSet.getString("estado"));
                restaurante.setCidade(resultSet.getString("cidade"));
                return restaurante;
            }
        });
        return restaurantes;
    }

    @Override
    public Restaurante getRestauranteByCodigo_restaurante(int codigo_restaurante) {
        return null;
    }

    @Override
    public void removeRestauranteByCodigo_restaurante(int codigo_restaurante) {

    }

    @Override
    public void updateRestaurante(Restaurante restaurante) {

    }

    @Override
    public void insertRestauranteToDb(Restaurante restaurante) {

    }
}
