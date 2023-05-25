package edu.bilkent.bilbilet.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.bilkent.bilbilet.enums.UserType;
import edu.bilkent.bilbilet.model.Traveler;
import edu.bilkent.bilbilet.model.User;

@Qualifier("account_repo")
@Repository
public class AccountRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private RowMapper<User> userRowMapper = (rs, rowNum) -> {
        User user = new User();
        user.setUserId(rs.getInt("user_id"));
        user.setName(rs.getString("name"));
        user.setSurname(rs.getString("surname"));
        user.setEmail(rs.getString("email"));
        user.setTelephone(rs.getString("telephone"));
        user.setPassword(rs.getString("password"));
        user.setUserType(UserType.valueOf(rs.getString("user_type")));
        return user;
    };
    
    private RowMapper<Traveler> travelerRowMapper = (rs, rowNum) -> {
        Traveler traveler = new Traveler();
        traveler.setUser_id(rs.getInt("user_id"));
        traveler.setNationality(rs.getString("nationality"));
        traveler.setPassport_number(rs.getString("passport_number"));
        traveler.setBalance(rs.getBigDecimal("balance"));
        traveler.setTCK(rs.getString("TCK"));
        return traveler;
    };
    
    public User findUserByMail(String mail) {
        String sql = "SELECT * FROM User WHERE email = ?";

        try {
            return jdbcTemplate.queryForObject(sql, userRowMapper, mail);
        } catch (EmptyResultDataAccessException e) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Traveler findTravelerByUserId(int id) {
        String sql = "SELECT * FROM Traveler WHERE user_id = ?";

        try {
            return jdbcTemplate.queryForObject(sql, travelerRowMapper, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public User save(User user) { //check if exist????????????
        String sql = "INSERT INTO User (name, surname, email, telephone, password, user_type) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";
        
        jdbcTemplate.update(
            sql,
            user.getName(),
            user.getSurname(),
            user.getEmail(),
            user.getTelephone(),
            user.getPassword(),
            user.getUserType().toString()
        );
        
        User new_user = findUserByMail(user.getEmail());
        new_user.setPassword(null);
        return new_user;
    }

    public Traveler save(Traveler traveler) { //check if exist????????????
        String sql = "INSERT INTO Traveler (user_id, nationality, passport_number, balance, TCK) " +
                     "VALUES (?, ?, ?, ?, ?)";
        
        jdbcTemplate.update(
            sql,
            traveler.getUser_id(),
            traveler.getNationality(),
            traveler.getPassport_number(),
            new BigDecimal(0),
            traveler.getTCK()
        );
        
        Traveler newTraveler = findTravelerByUserId(traveler.getUser_id());
        return newTraveler;
    }

    // public User save(User user) {
    //     users.add(user);
    //     return user;
    // }

    public boolean existsByEmail(String mail) {
        User user = findUserByMail(mail);

        return user != null;
    }
}
