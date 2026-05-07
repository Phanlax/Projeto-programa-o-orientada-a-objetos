/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proj.projetofeitv.dao;

import java.sql.Connection;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import proj.projetofeitv.model.Filme;

/**
 *
 * @author Gustavo
 */
public class FilmeDAO {
    private Connection conn;

public FilmeDAO(Connection conn) {
    this.conn = conn;
}
    
    public List<Filme> listarFilmes() throws SQLException {
    List<Filme> lista = new ArrayList<>();

    String sql = "SELECT * FROM filmes";

    PreparedStatement stmt = conn.prepareStatement(sql);
    ResultSet rs = stmt.executeQuery();

    while (rs.next()) {
        Filme f = new Filme();
        f.setId(rs.getInt("id"));
        f.setTitulo(rs.getString("titulo"));
        f.setGenero(rs.getString("genero"));
        f.setDuracao(rs.getString("duracao"));
        f.setAno(rs.getInt("ano"));

        lista.add(f);
    }

    return lista;
}
}
