/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proj.projetofeitv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import proj.projetofeitv.model.Filme;

/**
 *
 * @author Gustavo
 */
public class FavoritoDAO {
    private Connection conn;

    public FavoritoDAO(Connection conn) {
        this.conn = conn;
    }

    public void favoritar(int usuarioId, int filmeId) throws SQLException {

        String sql = "INSERT INTO favoritos (usuario_id, filme_id) VALUES (?, ?) ON CONFLICT DO NOTHING";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, usuarioId);
        stmt.setInt(2, filmeId);

        stmt.executeUpdate();
    }
    public void removerFavorito(int usuarioId, int filmeId) throws SQLException {

    String sql = "DELETE FROM favoritos WHERE usuario_id = ? AND filme_id = ?";

    PreparedStatement stmt = conn.prepareStatement(sql);

    stmt.setInt(1, usuarioId);
    stmt.setInt(2, filmeId);

    stmt.executeUpdate();
}
    
    
    
    
    public List<Filme> buscarFavoritos(int usuarioId) throws SQLException {

    List<Filme> lista = new ArrayList<>();

    String sql = """
        SELECT f.*
        FROM filmes f
        JOIN favoritos fav ON f.id = fav.filme_id
        WHERE fav.usuario_id = ?
    """;

    PreparedStatement stmt = conn.prepareStatement(sql);
    stmt.setInt(1, usuarioId);

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

