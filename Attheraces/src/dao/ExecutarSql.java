/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author marcelo
 */
public class ExecutarSql {
    
    public static void update(PreparedStatement stmt) throws SQLException {
        sqlDebug(stmt);
        stmt.executeUpdate();
    }
    
    public static ResultSet consulta(PreparedStatement stmt) throws SQLException {
        sqlDebug(stmt);
        return stmt.executeQuery();
    }
    
    private static void sqlDebug(PreparedStatement stmt) {
        //System.out.println(stmt.toString());
    }
    
    public static int getAutoIncrementIdGeradoPeloInsert(PreparedStatement stmt) throws SQLException {
        ResultSet rs = stmt.getGeneratedKeys();
        int autoIncValue = -1;
        if(rs.next()) {
            autoIncValue = rs.getInt(1);
        }
        rs.close();
        return autoIncValue;
    }
    
}
