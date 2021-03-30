package repository.Impl;

import model.User;
import repository.UserRepository;

import javax.jws.soap.SOAPBinding;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private BaseRepository baseRepository = new BaseRepository();

    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "(`name`, email, city) VALUES " +
            " (?, ?, ?);";

    private static final String SELECT_USER_BY_ID = "select id,`name`,email,city " +
            "from users " +
            "where id =?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users " +
            "where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users " +
            "set name = ?,email= ?, city =? " +
            "where id = ?;";
    private static final String SELECT_USER_BY_CITY = "select id,`name`, email, city " +
            "from users " +
            "where city = ?";

    @Override
    public void insertUser(User user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try ( PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCity());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public  User selectUser(int id) {
        User user = new User();

        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCity(resultSet.getString("city"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> selectUserByCity(String city) {
        List<User> users = new ArrayList<>();
        User user = null;
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(SELECT_USER_BY_CITY);
            preparedStatement.setString(1,city);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                user = new User();
                user.setId(Integer.parseInt(resultSet.getString("id")));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCity(resultSet.getString("city"));

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(SELECT_ALL_USERS);

            ResultSet resultSet = preparedStatement.executeQuery();

            User user = null;
            while (resultSet.next()){
                user = new User();
                user.setId(Integer.parseInt(resultSet.getString("id")));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCity(resultSet.getString("city"));

                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (
                PreparedStatement statement = this.baseRepository.getConnection().prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (
                PreparedStatement statement = this.baseRepository.getConnection().prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCity());
            statement.setInt(4, user.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
