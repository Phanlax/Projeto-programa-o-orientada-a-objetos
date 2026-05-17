/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proj.projetofeitv.controller;
import proj.projetofeitv.model.Usuario;
import proj.projetofeitv.view.TelaCadastro;
import proj.projetofeitv.view.TelaFavoritos;
import proj.projetofeitv.view.TelaListaReproducao;
import proj.projetofeitv.view.TelaLogin;
import proj.projetofeitv.view.TelaPrincipal;
/**
 *
 * @author Gustavo
 */
public class ControllerNavegacao {
    private TelaLogin telaLogin;
    private TelaCadastro telaCadastro;
    private TelaPrincipal telaPrincipal;
    private TelaFavoritos telaFavoritos;
    private TelaListaReproducao telaListaReproducao;
    
    //primeira tela
    public void iniciar() {
        telaLogin = new TelaLogin(this);
        telaLogin.setVisible(true);
    }

   public void abrirCadastro() {
    telaLogin.dispose();

    telaCadastro = new TelaCadastro(this);
    telaCadastro.setVisible(true);
}

    public void voltarLogin() {
       telaCadastro.dispose();

        telaLogin = new TelaLogin(this);
        telaLogin.setVisible(true);
    }
    
    public void abrirPrincipal() {
    telaLogin.dispose();

    telaPrincipal = new TelaPrincipal(this);
    telaPrincipal.setVisible(true);
}
  
    public void abrirFavoritos() {
        telaPrincipal.dispose();
        
        telaFavoritos = new TelaFavoritos(this);
        telaFavoritos.setVisible(true);
    }
    
    public void voltaPrincipalFavoritos(){
        telaFavoritos.dispose();
        
        telaPrincipal = new TelaPrincipal(this);
        telaPrincipal.setVisible(true);
    
    }
     
    public void abrirListaReproducao(){
        telaFavoritos.dispose();
        
        telaListaReproducao = new TelaListaReproducao(this);
        telaListaReproducao.setVisible(true);
    }
    
    public void voltaPrincipalLista(){
        telaListaReproducao.dispose();
        
        telaPrincipal = new TelaPrincipal(this);
        telaPrincipal.setVisible(true);
    
    }
    public void voltaFavoritosLista(){
        telaListaReproducao.dispose();
        
        telaFavoritos = new TelaFavoritos(this);
        telaFavoritos.setVisible(true);
    }
    
    // Funções dos botões de sair 
    //sai dos favoritos
    public void voltaLoginFavoritos(){
        telaFavoritos.dispose();
        
        telaLogin = new TelaLogin(this);
        telaLogin.setVisible(true);
    }
    //sai da tela principal
    public void voltarLoginPrincipal() {
       telaPrincipal.dispose();

        telaLogin = new TelaLogin(this);
        telaLogin.setVisible(true);
    }
    //sai da lista
    public void voltaLoginLista(){
        telaListaReproducao.dispose();
        
        telaLogin = new TelaLogin(this);
        telaLogin.setVisible(true);
    }
    
            
private Usuario usuarioLogado;


public Usuario getUsuarioLogado() {
    return usuarioLogado;
}

public void setUsuarioLogado(Usuario usuario) {
    this.usuarioLogado = usuario;
    }
}
