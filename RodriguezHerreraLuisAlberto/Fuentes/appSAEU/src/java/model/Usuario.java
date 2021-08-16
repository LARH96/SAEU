/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author LARH96
 */
public class Usuario {
    private String Id;
    private String Password;
    private String Login;
    private String Nombre;
    private String Apellidos;
    private int tipoPerfil;

    public Usuario() {
        this.setId("");
        this.setPassword("");
        this.setLogin("");
        this.setNombre("");
        this.setApellidos("");
        this.tipoPerfil = 0;
    }

    public Usuario(String Id, String Password, String Login, String Nombre, String Apellidos) {
        this.setId(Id);
        this.setPassword(Password);
        this.setLogin(Login);
        this.setNombre(Nombre);
        this.setApellidos(Apellidos);
    }
    
    public Usuario(String Id, int tipoPerfil) {
        this.Id = Id;
        this.Password = Password;
        this.tipoPerfil = tipoPerfil;
    }
    
    public int getTipoPerfil() {
        return tipoPerfil;
    }

    public void setTipoPerfil(int tipoUsuario) {
        this.tipoPerfil = tipoUsuario;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }
}
