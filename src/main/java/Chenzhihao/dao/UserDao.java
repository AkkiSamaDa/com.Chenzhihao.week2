package Chenzhihao.dao;

import Chenzhihao.model.User;

import java.sql.*;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao{
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        String username = user.getUsername();
        String password = user.getPassword();
        String email = user.getEmail();
        String in = "insert into usertable values ('"+username+"','"+password+"','"+email+"')";
        PreparedStatement ps = null;
        ps = con.prepareStatement(in);
        ps.executeUpdate();
        return true;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        return 0;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        String username = user.getUsername();
        String password = user.getPassword();
        String email = user.getEmail();
        String sql = "update usertable set password = '"+password+"',email = '"+email
                +"' where username = '"+username+"'";
        try {
            PreparedStatement ps = null;
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("TWILIGHT");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        return null;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {

        Statement stmt = con.createStatement();
        String sql = "select id,username,password from usertable where username = '" + username +"'" + "and password = '" + password +"'";
        ResultSet selected_table = stmt.executeQuery(sql);
        User user = null;
        if (selected_table.next()){
            user = new User();
            user.setUsername(selected_table.getString("username"));
            user.setPassword(selected_table.getString("password"));
        }

        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        Statement stmt = con.createStatement();
        String sql = "select id,username,password from usertable where username = '" + username +"'";
        ResultSet selected_table = stmt.executeQuery(sql);
        User user = null;
        if (selected_table.next()){
            user = new User();
            user.setUsername(selected_table.getString("username"));
        }

        return (List<User>) selected_table;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {

        Statement stmt = con.createStatement();
        String sql = "select id,username,password from usertable where  password = '" + password +"'";
        ResultSet selected_table = stmt.executeQuery(sql);
        User user = null;
        if (selected_table.next()){
            user = new User();
            user.setPassword(selected_table.getString("password"));
        }
        return (List<User>) selected_table;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {

        Statement stmt = con.createStatement();
        String sql = "select id,username,password from usertable where email = '" + email +"'" ;
        ResultSet selected_table = stmt.executeQuery(sql);
        User user = null;
        if (selected_table.next()){
            user = new User();
            user.setUsername(selected_table.getString("email"));

        }
        return (List<User>) selected_table;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        return null;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {

        Statement stmt = con.createStatement();
        String sql = "select * from usertable ";
        ResultSet selected_table = stmt.executeQuery(sql);
        return (List<User>) selected_table;
    }
}
