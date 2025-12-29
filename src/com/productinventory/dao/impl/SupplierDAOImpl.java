package com.productinventory.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.productinventory.dao.SupplierDAO;
import com.productinventory.model.Supplier;
import com.productinventory.util.DBConnection;

public class SupplierDAOImpl implements SupplierDAO {

    private static final String INSERT_SUPPLIER =
        "INSERT INTO supplier (supplier_id, name, email_address, phno, status, created_at) " +
        "VALUES (?, ?, ?, ?, ?, ?)";

    private static final String UPDATE_SUPPLIER =
        "UPDATE supplier SET name=?, email_address=?, phno=?, status=? WHERE supplier_id=?";

    private static final String DELETE_SUPPLIER =
        "DELETE FROM supplier WHERE supplier_id=?";

    private static final String SELECT_BY_ID =
        "SELECT * FROM supplier WHERE supplier_id=?";

    private static final String SELECT_ALL =
        "SELECT * FROM supplier";

    @Override
    public boolean addSupplier(Supplier supplier) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(INSERT_SUPPLIER)) {

            ps.setInt(1, supplier.getSupplierId());
            ps.setString(2, supplier.getName());
            ps.setString(3, supplier.getEmailAddress());
            ps.setLong(4, supplier.getPhno());
            ps.setString(5, supplier.getStatus());
            ps.setTimestamp(6, Timestamp.valueOf(supplier.getCreatedAt()));

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateSupplier(Supplier supplier) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(UPDATE_SUPPLIER)) {

            ps.setString(1, supplier.getName());
            ps.setString(2, supplier.getEmailAddress());
            ps.setLong(3, supplier.getPhno());
            ps.setString(4, supplier.getStatus());
            ps.setInt(5, supplier.getSupplierId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteSupplier(int supplierId) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(DELETE_SUPPLIER)) {

            ps.setInt(1, supplierId);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Supplier getSupplierById(int supplierId) {
        Supplier supplier = null;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(SELECT_BY_ID)) {

            ps.setInt(1, supplierId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                supplier = new Supplier();
                supplier.setSupplierId(rs.getInt("supplier_id"));
                supplier.setName(rs.getString("name"));
                supplier.setEmailAddress(rs.getString("email_address"));
                supplier.setPhno(rs.getLong("phno"));
                supplier.setStatus(rs.getString("status"));
                supplier.setCreatedAt(
                    rs.getTimestamp("created_at").toLocalDateTime()
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return supplier;
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        List<Supplier> suppliers = new ArrayList<>();

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(SELECT_ALL);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Supplier supplier = new Supplier();
                supplier.setSupplierId(rs.getInt("supplier_id"));
                supplier.setName(rs.getString("name"));
                supplier.setEmailAddress(rs.getString("email_address"));
                supplier.setPhno(rs.getLong("phno"));
                supplier.setStatus(rs.getString("status"));
                supplier.setCreatedAt(
                    rs.getTimestamp("created_at").toLocalDateTime()
                );
                suppliers.add(supplier);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return suppliers;
    }
}
