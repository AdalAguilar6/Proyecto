/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.websistemaproduccion.controladores;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.websistemaproduccion.ejb.DAOTipoSB;
import org.websistemaproduccion.ejb.DAOUsuarioSB;
import org.websistemaproduccion.entidades.Tipo;
import org.websistemaproduccion.entidades.Usuario;

/**
 *
 * @author Super Usuario
 */
@ManagedBean(name = "usuarioControlador")
@SessionScoped
public class UsuarioControlador implements Serializable{
    @EJB
    private DAOTipoSB dAOTipoSB;
    @EJB
    private DAOUsuarioSB dAOUsuarioSB;
    private Usuario usuario;
    private List<Usuario> listaTodos;
    private List<Usuario> listaEstadoUsuario;
    private List<Tipo> listaEstado;

    public UsuarioControlador() {
        usuario = new Usuario("-","-", "-");
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String insertar(){
        try{
            dAOUsuarioSB.insertar(usuario);
            usuario = new Usuario("-","-", "-");
            FacesMessage facesMsg = new 
            FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Usuario.insertar", 
                    "Proceso éxitoso");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Usuario.insertar",  e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }               
        return "";
    }
    
    public String buscarUsuario(){
        Usuario usuarioCargadoDesdeBD = null;
        usuarioCargadoDesdeBD = dAOUsuarioSB.buscarUsuarioxId(usuario);
        this.usuario = usuarioCargadoDesdeBD;
        return "";
    }
   
    public String eliminaUsuario(){
        try{
            dAOUsuarioSB.elimina(usuario);
            this.usuario = new Usuario("-","-", "-");
            FacesMessage facesMsg = new 
            FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Usuario.eliminar", 
                    "Proceso éxitoso");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Usuario.eliminar",  e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }                           
        return "";
    }
    
    public String modificaUsuario(){
        try{
            dAOUsuarioSB.modifica(usuario);
            usuario = new Usuario("-","-", "-");
            FacesMessage facesMsg = new 
            FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Usuario.modificar", 
                    "Proceso éxitoso");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Usuario.modificar",  e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }                           
        return "";
    }

    public List<Usuario> getListaTodos() {
        listaTodos = dAOUsuarioSB.listarUsuarioActivo();
        return listaTodos;
    }

    public void setListaTodos(List<Usuario> listaTodos) {
        this.listaTodos = listaTodos;
    }

    public List<Tipo> getListaEstado() {
        listaEstado = dAOTipoSB.buscarTipoxLetra("E");
        return listaEstado;
    }

    public void setListaEstado(List<Tipo> listaEstado) {
        this.listaEstado = listaEstado;
    }

    public List<Usuario> getListaEstadoUsuario() {
        listaEstadoUsuario = dAOUsuarioSB.listarUsuarioxEstado("E00002");
        return listaEstadoUsuario;
    }

    public void setListaEtadoUsuario(List<Usuario> listaEstadoUsuario) {
        this.listaEstadoUsuario = listaEstadoUsuario;
    }
}
