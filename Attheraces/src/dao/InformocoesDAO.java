/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author marce
 */
public class InformocoesDAO extends DAO {
    
    public void salvar(Date data, String hora, String pista, double oddFav,
            String nomeFav, String oddFavText, double oddFav2, String nomeFav2, String oddFav2Text, String distancia,
            String numCavalos, String campeao, String link, int numeroCavalos, double dist) throws SQLException {
        try {
            PreparedStatement stmt = conexaoDb.prepareStatement("INSERT INTO ATT "
                    + "(DATA, HORA, PISTA, ODDFAV, NAMEFAV, ODDFAV2, NAMEFAV2, DISTANCIA, NUMCAVALOSTEXT, CAMPEAO, LINK, ODDFAVTEXT, ODDFAV2TEXT, NUMEROCAVALOS, DIST) "
                    + "VALUES "
                    + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setDate(1, new java.sql.Date(data.getTime()));
            stmt.setString(2, hora);
            stmt.setString(3, pista);
            stmt.setDouble(4, oddFav);
            stmt.setString(5, nomeFav);
            stmt.setDouble(6, oddFav2);
            stmt.setString(7, nomeFav2);
            stmt.setString(8, distancia);
            stmt.setString(9, numCavalos);
            stmt.setString(10, campeao);
            stmt.setString(11, link);
            stmt.setString(12, oddFavText);
            stmt.setString(13, oddFav2Text);
            stmt.setInt(14, numeroCavalos);
            stmt.setDouble(15, dist);
            ExecutarSql.update(stmt);
        } catch (SQLIntegrityConstraintViolationException ex) {
            atualizar(data, hora, pista, oddFav, nomeFav, oddFavText, oddFav2, nomeFav2, oddFav2Text, distancia, numCavalos, campeao, link, numeroCavalos, dist);
        }
    }
    
    public void atualizar(Date data, String hora, String pista, double oddFav,
            String nomeFav, String oddFavText, double oddFav2, String nomeFav2, String oddFav2Text, String distancia,
            String numCavalos, String campeao, String link, int numeroCavalos, double dist) throws SQLException {
        
        PreparedStatement stmt = conexaoDb.prepareStatement("UPDATE ATT "
                                                          + "SET ODDFAV=?, NAMEFAV=?, ODDFAV2=?, NAMEFAV2=?, DISTANCIA=?, NUMCAVALOSTEXT=?, CAMPEAO=?, LINK=?, ODDFAVTEXT=?, ODDFAV2TEXT=?, NUMEROCAVALOS=?, DIST=?  "
                                                          + "WHERE DATA=? AND HORA=? AND PISTA=?");
        stmt.setDouble(1, oddFav);
        stmt.setString(2, nomeFav);
        stmt.setDouble(3, oddFav2);
        stmt.setString(4, nomeFav2);
        stmt.setString(5, distancia);
        stmt.setString(6, numCavalos);
        stmt.setString(7, campeao);
        stmt.setString(8, link);
        stmt.setString(9, oddFavText);
        stmt.setString(10, oddFav2Text);
        stmt.setInt(11, numeroCavalos);
        stmt.setDouble(12, dist);
        stmt.setDate(13, new java.sql.Date(data.getTime()));
        stmt.setString(14, hora);
        stmt.setString(15, pista);
        ExecutarSql.update(stmt);
    }
    
    public List<Informacoes> listagem(Date dataInicia, Date dataFinal, String where, String orderByS) throws SQLException {
        List<Informacoes> listagem = new ArrayList<>();
        PreparedStatement stmt = conexaoDb.prepareStatement("SELECT * "
                                                          + "FROM ATT "
                                                          + "WHERE (DATA >=? AND DATA <=?) "
                                                          + where
                                                          + "ORDER BY " + orderByS);
        stmt.setDate(1, new java.sql.Date(dataInicia.getTime()));
        stmt.setDate(2, new java.sql.Date(dataFinal.getTime()));
        System.out.println(stmt.toString());
        ResultSet rs = ExecutarSql.consulta(stmt);
        while(rs.next()) {
            Informacoes i = new Informacoes();
            i.setData(new Date(rs.getDate("DATA").getTime()));
            i.setHora(rs.getString("HORA"));
            i.setPista(rs.getString("PISTA"));
            i.setOddFav(rs.getDouble("ODDFAV"));
            i.setNomeOddFav(rs.getString("NAMEFAV"));
            i.setOddFavText(rs.getString("ODDFAVTEXT"));
            i.setOddFav2(rs.getDouble("ODDFAV2"));
            i.setNomeOddFav2(rs.getString("NAMEFAV2"));
            i.setOddFav2Text(rs.getString("ODDFAV2TEXT"));
            i.setDistancia(rs.getString("DISTANCIA"));
            i.setNumCavalos(rs.getString("NUMCAVALOSTEXT"));
            i.setCampeao(rs.getString("CAMPEAO"));
            i.setLink(rs.getString("LINK"));
            i.setDist(rs.getDouble("DIST"));
            listagem.add(i);
        }
        rs.close();
        stmt.close();
        return listagem;
    }
    
}
