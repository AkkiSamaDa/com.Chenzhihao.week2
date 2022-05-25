package Chenzhihao.model;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Category implements java.io.Serializable{
    private int categoryId;
    private String categoryName;
    private String description;
    private Boolean active;
    public Category(){

    }
    public Category(String categoryName){this.categoryName = categoryName;}
    public Category(String categoryName,String description,Boolean active){
        this.categoryName = categoryName;
        this.description = description;
        this.active = active;
    }
    public int getCategoryId(){return this.categoryId;}
    public void setCategoryId(int categoryId){this.categoryId = categoryId;}
    public String getCategoryName(){return this.categoryName;}
    public void setCategoryName(String categoryName){this.categoryName = categoryName;}
    public String getDescription(){return this.description;}
    public void setDescription(String description){this.description = description;}
    public Boolean getActive(){return this.active;}
    public void setActive(Boolean active){this.active = active;}
    public static List<Category> findAllCategory(Connection con){
        List<Category> list = new ArrayList<Category>();
        String queryString = "select * from Category";
        try {
            PreparedStatement statement = con.prepareStatement(queryString);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Category c = new Category();
                c.setCategoryId(resultSet.getInt("categoryid"));
                c.setCategoryName(resultSet.getString("categoryName"));
                c.setDescription(resultSet.getString("Description"));
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }

    public static String findByCategoryId(Connection con,int categoryId){
        String categoryName = null;
        try {
            String queryString = "select CategoryName form Category where categoryId=?";
            PreparedStatement statement = con.prepareStatement(queryString);
            statement.setInt(1,categoryId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                categoryName = resultSet.getString("categoryName");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryName;
    }

}
