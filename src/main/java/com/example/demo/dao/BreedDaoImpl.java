package com.example.demo.dao;

import com.example.demo.model.Breed;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@SuppressWarnings({"SqlNoDataSourceInspection", "ConstantConditions", "SqlDialectInspection"})
@Repository
public class BreedDaoImpl implements BreedDao {

    private final JdbcOperations jdbc;

    public BreedDaoImpl(JdbcOperations jdbcOperations)
    {
        this.jdbc = jdbcOperations;
    }

    @Override
    public void createBreed(Breed breed) {
        jdbc.update("insert into breed (BREED_ID, `NAME_BREED`) values (?, ?)", breed.getBreedId(), breed.getNameBreed());
    }

    @Override
    public Breed getBreedById(long breedId) {
        return jdbc.queryForObject("select * from breed where breed_id = ?", new Object[] {breedId}, new BreedMapper());
    }

    @Override
    public void updateBreedById(long breedId, String name) {
        jdbc.update("update breed set name_breed = ? where breed_id = ?", name, breedId);
    }

    @Override
    public void delete(long id_breed) {
        jdbc.update("delete from breed where breed_id = ?", id_breed);
    }

    @Override
    public int count() {
        return jdbc.queryForObject("select count(*) from breed", Integer.class);
    }

    private static class BreedMapper implements RowMapper<Breed> {

        @Override
        public Breed mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("breed_id");
            String name = resultSet.getString("name_breed");
            return new Breed(id, name);
        }
    }
}
