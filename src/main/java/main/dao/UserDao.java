package main.dao;

import main.domain.DbUser;

import java.util.List;

public interface UserDao {
    DbUser findUserById(Integer iduser);
    List<DbUser> findAllUsers();
    void insertUser(DbUser user);
    void deleteUserById(Integer iduser);
    void updateUserPassword(DbUser user);
}
