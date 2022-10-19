package com.dmdev.dao;

import com.dmdev.util.*;
import java.sql.*;
import java.util.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserDao {

    private static final UserDao INSTANCE = new UserDao();

    private static final String FIND_ALL = "SELECT * FROM users";

    @SneakyThrows
    public List<String> getNames() {
        try (var connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<String> names = new ArrayList<>();
            while (resultSet.next()) {
                names.add(resultSet.getString("name"));
            }
            return names;
        }
    }

    @SneakyThrows
    public List<String> getPassword() {
        try (var connection = ConnectionManager.get();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<String> passwords = new ArrayList<>();
            while (resultSet.next()) {
                passwords.add(resultSet.getString("password"));
            }
            return passwords;
        }
    }

    public static UserDao getInstance() {
        return INSTANCE;
    }
}
