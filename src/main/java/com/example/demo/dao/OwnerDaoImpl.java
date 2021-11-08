package com.example.demo.dao;

import com.example.demo.model.Animal;
import com.example.demo.model.Owner;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OwnerDaoImpl implements OwnerDao {

    private final JdbcOperations jdbc;
    public OwnerDaoImpl(JdbcOperations jdbcOperations){
        this.jdbc = jdbcOperations;
    };

    @Override
    public void createOwner(Owner owner) {
        jdbc.update("insert into owner (OWNER_ID, `NICK_OWNER`, ANIMAL_ID) values (?, ?, ?)",
                    owner.getOwnerId(),
                    owner.getNickOwner(),
                    owner.getAnimalId());
    }

    @Override
    public Owner getOwnerById(long ownerId) {
        return jdbc.queryForObject("select * from owner where owner_id = ?", new Object[] {ownerId}, new OwnerDaoImpl.OwnerMapper());
    }

    @Override
    public Owner getOwnerByName(String ownerNick) {
        return jdbc.queryForObject("select * from owner where NICK_OWNER = ?", new Object[] {ownerNick}, new OwnerDaoImpl.OwnerMapper());
    }

    @Override
    public void updateOwnerById(Owner owner) {
        jdbc.update("update animal set nick_owner = ?, animal_id = ? where owner_id = ?",
                    owner.getNickOwner(),
                    owner.getAnimalId(),
                    owner.getOwnerId());
    }

    @Override
    public void delete(long ownerId) {
        jdbc.update("delete from owner where owner_id = ?", ownerId);
    }

    @Override
    public long count() {
        return jdbc.queryForObject("select count(*) from owner", Integer.class);
    }

    @Override
    public List<Animal> getAllAnimals(String nickOwner) {
        return jdbc.query("select * from animal where animal_id IN (select animal_id from owner where nick_owner = ?)",
                          new AnimalDaoImpl.AnimalMapper(), nickOwner);
    }

    private static class OwnerMapper implements RowMapper<Owner> {
        @Override
        public Owner mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("owner_id");
            String name = resultSet.getString("nick_owner");
            long idAnimal = resultSet.getLong("animal_id");
            return new Owner(id, name, idAnimal);
        }
    }
}
