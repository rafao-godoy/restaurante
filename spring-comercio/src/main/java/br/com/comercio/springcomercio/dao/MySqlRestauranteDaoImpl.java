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

    private static class RestauranteRowMapper implements RowMapper<Restaurante>{

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
    }

    @Override
    public Collection<Restaurante> getAllRestaurantes() {
 //       SELECT column_name(s) FROM table_name
        final String sql = "SELECT codigo_restaurante, nome_restaurante, tipo_comida, estado, cidade FROM RESTAURANTE";
        List<Restaurante> restaurantes = jdbcTemplate.query(sql, new RestauranteRowMapper());
        return restaurantes;
    }

    @Override
    public Restaurante getRestauranteByCodigo_restaurante(int codigo_restaurante) {
 //       SELECT column_name(s) FROM table_name where column = value
        final String sql = "SELECT codigo_restaurante, nome_restaurante, tipo_comida, estado, cidade FROM RESTAURANTE WHERE codigo_restaurante = ?";
        Restaurante restaurante = jdbcTemplate.queryForObject(sql, new RestauranteRowMapper(), codigo_restaurante);
        return restaurante;
    }

    @Override
    public void removeRestauranteByCodigo_restaurante(int codigo_restaurante) {
 //      DELETE FROM table_name WHERE some_column = some_value
        final String sql = "DELETE FROM RESTAURANTE WHERE codigo_restaurante = ?";
        jdbcTemplate.update(sql, codigo_restaurante);
    }

    @Override
    public void updateRestaurante(Restaurante restaurante) {
 //     UPDATE table_name SET some_column = some_value, some_column = some_value WHERE some_column = some_value
        final String sql = "UPDATE RESTAURANTE SET nome_restaurante = ?, tipo_comida = ?, estado = ?, cidade = ? WHERE codigo_restaurante = ?";
        final int codigo_restaurante = restaurante.getCodigo_restaurante();
        final String nome_restaurante = restaurante.getNome_restaurante();
        final String tipo_comida = restaurante.getTipo_comida();
        final String estado = restaurante.getEstado();
        final String cidade = restaurante.getCidade();
        jdbcTemplate.update(sql, new Object[] {nome_restaurante, tipo_comida, estado, cidade, codigo_restaurante});
    }

    @Override
    public void insertRestauranteToDb(Restaurante restaurante) {
 //     INSERT INTO table_name (column1, column2, column3) VALUES (value1, value2, value3)
        final String sql = "INSERT INTO RESTAURANTE (codigo_restaurante, nome_restaurante, tipo_comida, estado, cidade) VALUES ( ?, ?, ?, ?, ? )";
        final int codigo_restaurante = restaurante.getCodigo_restaurante();
        final String nome_restaurante = restaurante.getNome_restaurante();
        final String tipo_comida = restaurante.getTipo_comida();
        final String estado = restaurante.getEstado();
        final String cidade = restaurante.getCidade();
        jdbcTemplate.update(sql, new Object[] {codigo_restaurante, nome_restaurante, tipo_comida, estado, cidade});
    }
}
