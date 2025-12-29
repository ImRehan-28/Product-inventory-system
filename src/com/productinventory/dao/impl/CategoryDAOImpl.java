package com.productinventory.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.productinventory.dao.CategoryDAO;
import com.productinventory.model.Category;
import com.productinventory.util.DBConnection;

public class CategoryDAOImpl implements CategoryDAO {

    private static final String INSERT_CATEGORY =
        "INSERT INTO category (category_id, name, status) VALUES (?, ?, ?)";

    private static final String UPDATE_CATEGORY =
        "UPDATE category SET name=?, status=? WHERE category_id=?";

    private static final String DELETE_CATEGORY =
        "DELETE FROM category WHERE category_id=?";

    private static final String SELECT_BY_ID =
        "SELECT * FROM category WHERE category_id=?";

    private static final String SELECT_ALL =
        "SELECT * FROM category";

    @Override
    public boolean addCategory(Category category) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(INSERT_CATEGORY)) {

            ps.setInt(1, category.getCategoryId());
            ps.setString(2, category.getCategoryName());
            ps.setString(3, category.getStatus());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateCategory(Category category) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(UPDATE_CATEGORY)) {

            ps.setString(1, category.getCategoryName());
            ps.setString(2, category.getStatus());
            ps.setInt(3, category.getCategoryId());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteCategory(int categoryId) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(DELETE_CATEGORY)) {

            ps.setInt(1, categoryId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Category getCategoryById(int categoryId) 
    {
        Category category = null;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(SELECT_BY_ID)) {

            ps.setInt(1, categoryId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                category = new Category();
                category.setCategoryId(rs.getInt("category_id"));
                category.setCategoryName(rs.getString("name"));
                category.setStatus(rs.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public List<Category> getAllCategory() {
        List<Category> categories = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(SELECT_ALL);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Category category = new Category();
                category.setCategoryId(rs.getInt("category_id"));
                category.setCategoryName(rs.getString("name"));
                category.setStatus(rs.getString("status"));
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }
}
