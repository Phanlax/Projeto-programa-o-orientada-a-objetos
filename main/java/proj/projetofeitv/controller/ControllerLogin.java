/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proj.projetofeitv.controller;

import java.sql.Connection;
import proj.projetofeitv.dao.Conexao;
import proj.projetofeitv.dao.UsuarioDAO;
import proj.projetofeitv.model.Usuario;
import proj.projetofeitv.view.TelaLogin;

/**
 *
 * @author Gustavo
 */
public class ControllerLogin {
    private TelaLogin view;
    private ControllerNavegacao nav;
  
    
    
    public ControllerLogin(TelaLogin view, ControllerNavegacao nav) {
        this.view = view;
        this.nav = nav;
    }

    //função de login
    public void login() {

    String usuario = view.getUsuario();
    String senha = view.getSenha();

    if (usuario.isEmpty() || senha.isEmpty()) {
        view.mostrarMensagem("Preencha todos os campos!");
        return;
    }

    try (Connection conn = new Conexao().getConnection()) {

        UsuarioDAO dao = new UsuarioDAO(conn);

        Usuario usuarioLogado = dao.login(usuario, senha); // 🔥 MUDOU AQUI

        if (usuarioLogado != null) {
            nav.setUsuarioLogado(usuarioLogado);
            
            view.mostrarMensagem("Login realizado com sucesso!");

            
            int id = usuarioLogado.getId();

            nav.abrirPrincipal();

        } else {
            view.mostrarMensagem("Usuário ou senha inválidos!");
        }

    } catch (Exception e) {
        view.mostrarMensagem("Erro ao fazer login");
        e.printStackTrace();
    }
  }
}

