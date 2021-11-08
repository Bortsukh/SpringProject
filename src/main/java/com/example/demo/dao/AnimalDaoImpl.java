package com.example.demo.dao;

import com.example.demo.model.Animal;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class AnimalDaoImpl implements AnimalDao {

    private final JdbcOperations jdbc;
    public AnimalDaoImpl(JdbcOperations jdbcOperations){
        this.jdbc = jdbcOperations;
    };

    @Override
    public void createAnimal(Animal animal) {
        jdbc.update("insert into animal (ANIMAL_ID, `NICK_NAME`, WEIGHT, BREED_ID) values (?, ?, ?, ?)",
                    animal.getAnimalId(),
                    animal.getNickName(),
                    animal.getWeight(),
                    animal.getBreedId());
    }

    @Override
    public Animal getAnimalById(long animalId) {
        return jdbc.queryForObject("select * from animal where animal_id = ?", new Object[] {animalId}, new AnimalDaoImpl.AnimalMapper());
    }

    @Override
    public void updateAnimal(Animal animal) {
        jdbc.update( "update animal set nick_name = ?, weight = ?, breed_id = ? where animal_id = ?",
                     animal.getNickName(),
                     animal.getWeight(),
                     animal.getBreedId(),
                     animal.getAnimalId());
    }

    @Override
    public void deleteAnimalById(long animalId) {
        jdbc.update("delete from animal where animal_id = ?", animalId);
    }

    @Override
    public long count() {
        return jdbc.queryForObject("select count(*) from animal", Integer.class);
    }

    private static class AnimalMapper implements RowMapper<Animal> {
        @Override
        public Animal mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("animal_id");
            String name = resultSet.getString("nick_name");
            double weight = resultSet.getDouble("weight");
            long idBreed = resultSet.getLong("breed_id");
            return new Animal(id, name, weight, idBreed);
        }
    }
}
