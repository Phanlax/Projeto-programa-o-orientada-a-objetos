/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proj.projetofeitv.controller;

import java.sql.Connection;
import java.sql.SQLException;
import proj.projetofeitv.dao.Conexao;
import proj.projetofeitv.dao.UsuarioDAO;
import proj.projetofeitv.model.Usuario;
import proj.projetofeitv.view.TelaCadastro;

/**
 *
 * @author Gustavo
 */
public class ControllerCadastro {
    private TelaCadastro view;
    private ControllerNavegacao nav;
    
   public ControllerCadastro(TelaCadastro view, ControllerNavegacao nav) {
    this.view = view;
    this.nav = nav;
}
    
    
  public void salvarUsuario() {

    String user = view.getUsuario();
    String senha = view.getSenha();

    if (user.isEmpty() || senha.isEmpty()) {
        view.mostrarMensagem("Preencha todos os campos!");
        return;
    }

    Usuario usuario = new Usuario(user, senha);

    try (Connection connection = new Conexao().getConnection()) {

        UsuarioDAO dao = new UsuarioDAO(connection);
        dao.inserir(usuario);

        view.mostrarMensagem("Usuário cadastrado com sucesso!");
         nav.voltarLogin();

    } catch (SQLException e) {
        view.mostrarMensagem("Falha no cadastro");
        e.printStackTrace();
    }
  }
}