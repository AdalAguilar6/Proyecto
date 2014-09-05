/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.websistemaproduccion.controladores;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import org.websistemaproduccion.ejb.DAOPedidoSB;
import org.websistemaproduccion.ejb.DAOPersonaSB;
import org.websistemaproduccion.ejb.DAOTipoSB;
import org.websistemaproduccion.ejbnegocios.EJBTotalLibrasLocal;
import org.websistemaproduccion.entidades.Ordenproduccion;
import org.websistemaproduccion.entidades.Pedido;
import org.websistemaproduccion.entidades.Persona;
import org.websistemaproduccion.entidades.Tipo;

/**
 *
 * @author Super Usuario
 */
@ManagedBean(name = "pedidoControlador")
@SessionScoped
public class PedidoControlador implements Serializable{
    @EJB
    private EJBTotalLibrasLocal eJBTotalLibras;
    @EJB
    private DAOPersonaSB dAOPersonaSB;
    @EJB
    private DAOTipoSB dAOTipoSB;
    @EJB
    private DAOPedidoSB dAOPedidoSB;
    private Pedido pedido;
    Date fecha = new Date();
    private List<Tipo> listaTroquelados;
    private List<Tipo> listaTipoFuelles;
    private List<Tipo> listaTipoSello;
    private List<Tipo> listaTipoAdicional;
    private List<Persona> listaCliente;
    private List<Pedido> listaTodos;
    private List<Pedido> listaPedidoPe;    
    private List<Pedido> listaPedidoPr;    
    private List<Pedido> listaPedidoTe;        
    private List<Pedido> listaPedidoEx;
    private List<Pedido> listaPedidoFl;    
    private List<Pedido> listaPedidoDb;    
    private List<Pedido> listaPedidoRe;    
    private List<Pedido> listaPedidoCs;    
    private List<Pedido> listaPedidoAprobar;        
    private DataModel<Ordenproduccion> listaDetalle;
    private List<Ordenproduccion> listaDt;     
    private Boolean checkAprobado;
    private Boolean checkRefilado;
    private Boolean checkDoblado;
    private Boolean checkImpresa;
    private Boolean checkImpUnaCara;
    private Boolean checkImpDosCaras;
    private Boolean checkImpFrente;
    private Boolean checkImpContinua;
    private Boolean checkImpDorso;
    private float total;
    private Pedido selectedPedido;
    private Ordenproduccion dt;     

    
    public PedidoControlador() {
        pedido = new Pedido(0,fecha,fecha,"-","-","Pe","-","TRANSPARENTE","-","-","Ex",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    public String insertar(){
        try{
            if (checkAprobado) {
                pedido.setAprobado(1);
            } else {
                pedido.setAprobado(0);
            }
            if (checkDoblado) {
                pedido.setDoblado(1);
            } else {
                pedido.setDoblado(0);
            }
            if (checkRefilado) {
                pedido.setRefilado(1);
            } else {
                pedido.setRefilado(0);
            }
            if (checkImpresa) {
                pedido.setImpresa(1);
            } else {
                pedido.setImpresa(0);
            }        
            if (checkImpContinua) {
                pedido.setImpresionContinua(1);
            } else {
                pedido.setImpresionContinua(0);
            }  
            if (checkImpDorso) {
                pedido.setImpresionDorso(1);
            } else {
                pedido.setImpresionDorso(0);
            }          
            if (checkImpDosCaras) {
                pedido.setImpresionDosCara(1);
            } else {
                pedido.setImpresionDosCara(0);
            }                  
            if (checkImpFrente) {
                pedido.setImpresionFrente(1);
            } else {
                pedido.setImpresionFrente(0);
            }                          
            if (checkImpUnaCara) {
                pedido.setImpresionUnaCara(1);
            } else {
                pedido.setImpresionUnaCara(0);
            }                                  
            dAOPedidoSB.insertar(pedido);
            pedido = new Pedido(0,fecha,fecha,"-","-","Pe","-","TRANSPARENTE","-","-","Ex",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
            FacesMessage facesMsg = new 
            FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Pedido.insertar", 
                    "Proceso éxitoso");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Pedido.insertar",  e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }                          
        return "";
    }
    
    public String buscarPedidoId(int idPedido){
        Pedido pedidoCargadoDesdeBD = null;
        pedidoCargadoDesdeBD = dAOPedidoSB.buscarPedidoId(idPedido);
        this.pedido = pedidoCargadoDesdeBD;
        return "";
    }
    
    public String buscarPedidoxId(){
        Pedido pedidoCargadoDesdeBD = null;
        pedidoCargadoDesdeBD = dAOPedidoSB.buscarPedidoxId(pedido);
        this.pedido = pedidoCargadoDesdeBD;
        return "";
    }    
    
    public String eliminaPedido(){
        try{
            dAOPedidoSB.elimina(pedido);
            pedido = new Pedido(0,fecha,fecha,"-","-","Pe","-","TRANSPARENTE","-","-","Ex",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
            FacesMessage facesMsg = new 
            FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Pedido.eliminar", 
                    "Proceso éxitoso");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Pedido.eliminar",  e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }                          
        return "";
    }
    
    public String modificaPedido(){
        try{
            if (checkAprobado) {
                pedido.setAprobado(1);
            } else {
                pedido.setAprobado(0);
            }        
            if (checkDoblado) {
                pedido.setDoblado(1);
            } else {
                pedido.setDoblado(0);
            }
            if (checkRefilado) {
                pedido.setRefilado(1);
            } else {
                pedido.setRefilado(0);
            }
            if (checkImpresa) {
                pedido.setImpresa(1);
            } else {
                pedido.setImpresa(0);
            }        
            if (checkImpContinua) {
                pedido.setImpresionContinua(1);
            } else {
                pedido.setImpresionContinua(0);
            }  
            if (checkImpDorso) {
                pedido.setImpresionDorso(1);
            } else {
                pedido.setImpresionDorso(0);
            }          
            if (checkImpDosCaras) {
                pedido.setImpresionDosCara(1);
            } else {
                pedido.setImpresionDosCara(0);
            }                  
            if (checkImpFrente) {
                pedido.setImpresionFrente(1);
            } else {
                pedido.setImpresionFrente(0);
            }                          
            if (checkImpUnaCara) {
                pedido.setImpresionUnaCara(1);
            } else {
                pedido.setImpresionUnaCara(0);
            }                                      
            dAOPedidoSB.modifica(pedido);
            pedido = new Pedido(0,fecha,fecha,"-","-","Pe","-","TRANSPARENTE","-","-","Ex",0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
            FacesMessage facesMsg = new 
            FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Pedido.modificar", 
                    "Proceso éxitoso");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Pedido.modificar",  e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }                              
        return "";
    }

    public List<Tipo> getListaTroquelados() {
        listaTroquelados = dAOTipoSB.buscarTipoxLetra("T0");
        return listaTroquelados;
    }

    public void setListaTroquelados(List<Tipo> listaTroquelados) {
        this.listaTroquelados = listaTroquelados;
    }

    public List<Tipo> getListaTipoFuelles() {
        listaTipoFuelles = dAOTipoSB.buscarTipoxLetra("F");
        return listaTipoFuelles;
    }

    public void setListaTipoFuelles(List<Tipo> listaTipoFuelles) {
        this.listaTipoFuelles = listaTipoFuelles;
    }

    public List<Tipo> getListaTipoSello() {
        listaTipoSello = dAOTipoSB.buscarTipoxLetra("S");
        return listaTipoSello;
    }

    public void setListaTipoSello(List<Tipo> listaTipoSello) {
        this.listaTipoSello = listaTipoSello;
    }

    public List<Tipo> getListaTipoAdicional() {
        listaTipoAdicional = dAOTipoSB.buscarTipoxLetra("A");        
        return listaTipoAdicional;
    }

    public void setListaTipoAdicional(List<Tipo> listaTipoAdicional) {
        this.listaTipoAdicional = listaTipoAdicional;
    }

    public Boolean getCheckAprobado() {
        if (pedido.getAprobado().equals(new Integer(1))) {
            checkAprobado = true;
        } else {
            checkAprobado = false;
        }       
        return checkAprobado;
    }

    public void setCheckAprobado(Boolean checkAprobado) {
        this.checkAprobado = checkAprobado;
    }

    public Boolean getCheckRefilado() {
        if (pedido.getRefilado().equals(new Integer(1))) {
            checkRefilado = true;
        } else {
            checkRefilado = false;
        }               
        return checkRefilado;
    }

    public void setCheckRefilado(Boolean checkRefilado) {
        this.checkRefilado = checkRefilado;
    }

    public Boolean getCheckDoblado() {
        if (pedido.getDoblado().equals(new Integer(1))) {
            checkDoblado = true;
        } else {
            checkDoblado = false;
        }               
        return checkDoblado;
    }

    public void setCheckDoblado(Boolean checkDoblado) {
        this.checkDoblado = checkDoblado;
    }

    public Boolean getCheckImpresa() {
        if (pedido.getImpresa().equals(new Integer(1))) {
            checkImpresa = true;
        } else {
            checkImpresa = false;
        }               
        return checkImpresa;
    }

    public void setCheckImpresa(Boolean checkImpresa) {
        this.checkImpresa = checkImpresa;
    }

    public Boolean getCheckImpUnaCara() {
        if (pedido.getImpresionUnaCara().equals(new Integer(1))) {
            checkImpUnaCara = true;
        } else {
            checkImpUnaCara = false;
        }               
        return checkImpUnaCara;
    }

    public void setCheckImpUnaCara(Boolean checkImpUnaCara) {
        this.checkImpUnaCara = checkImpUnaCara;
    }

    public Boolean getCheckImpDosCaras() {
        if (pedido.getImpresionDosCara().equals(new Integer(1))) {
            checkImpDosCaras = true;
        } else {
            checkImpDosCaras = false;
        }               
        return checkImpDosCaras;
    }

    public void setCheckImpDosCaras(Boolean checkImpDosCaras) {
        this.checkImpDosCaras = checkImpDosCaras;
    }

    public Boolean getCheckImpFrente() {
        if (pedido.getImpresionFrente().equals(new Integer(1))) {
            checkImpFrente = true;
        } else {
            checkImpFrente = false;
        }               
        return checkImpFrente;
    }

    public void setCheckImpFrente(Boolean checkImpFrente) {
        this.checkImpFrente = checkImpFrente;
    }

    public Boolean getCheckImpContinua() {
        if (pedido.getImpresionContinua().equals(new Integer(1))) {
            checkImpContinua = true;
        } else {
            checkImpContinua = false;
        }               
        return checkImpContinua;
    }

    public void setCheckImpContinua(Boolean checkImpContinua) {
        this.checkImpContinua = checkImpContinua;
    }

    public Boolean getCheckImpDorso() {
        if (pedido.getImpresionDorso().equals(new Integer(1))) {
            checkImpDorso = true;
        } else {
            checkImpDorso = false;
        }               
        return checkImpDorso;
    }

    public void setCheckImpDorso(Boolean checkImpDorso) {
        this.checkImpDorso = checkImpDorso;
    }

    public List<Persona> getListaCliente() {
        listaCliente = dAOPersonaSB.buscarPersonaCliente(1);
        return listaCliente;
    }

    public void setListaCliente(List<Persona> listaCliente) {
        this.listaCliente = listaCliente;
    }
    
     public float totalLibras(){
        try{
            total = eJBTotalLibras.totalLibras(pedido.getAncho(), pedido.getLargo(), pedido.getTamanoAdicional(), pedido.getCalibre(), pedido.getCantidad(), pedido.getIdProducto().getIdProducto());
            pedido.setLibrasTotales(total);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Pedido.totalLibras",  e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }                              
        return total;      
    }    

    public List<Pedido> getListaPedidoEx() {
        listaPedidoEx = dAOPedidoSB.buscarPedidoEstadoEtapa("Pe", "Ex", 1);
        return listaPedidoEx;
    }

    public void setListaPedidoEx(List<Pedido> listaPedidoEx) {
        this.listaPedidoEx = listaPedidoEx;
    }

    public List<Pedido> getListaPedidoFl() {
        listaPedidoFl = dAOPedidoSB.buscarPedidoEstadoEtapa("Pe", "Fl", 1);
        return listaPedidoFl;
    }

    public void setListaPedidoFl(List<Pedido> listaPedidoFl) {
        this.listaPedidoFl = listaPedidoFl;
    }

    public List<Pedido> getListaPedidoDb() {
        listaPedidoDb = dAOPedidoSB.buscarPedidoEstadoEtapa("Pe", "Db", 1);     
        return listaPedidoDb;
    }

    public void setListaPedidoDb(List<Pedido> listaPedidoDb) {
        this.listaPedidoDb = listaPedidoDb;
    }

    public List<Pedido> getListaPedidoRe() {
        listaPedidoRe = dAOPedidoSB.buscarPedidoEstadoEtapa("Pe", "Re", 1);     
        return listaPedidoRe;
    }

    public void setListaPedidoRe(List<Pedido> listaPedidoRe) {
        this.listaPedidoRe = listaPedidoRe;
    }

    public List<Pedido> getListaPedidoCs() {
        listaPedidoCs = dAOPedidoSB.buscarPedidoEstadoEtapa("Pe", "Cs", 1);     
        return listaPedidoCs;
    }

    public void setListaPedidoCs(List<Pedido> listaPedidoCs) {
        this.listaPedidoCs = listaPedidoCs;
    }
    
    public Pedido getSelectedPedido() {
        return selectedPedido;
    }

    public void setSelectedPedido(Pedido selectedPedido) {
        this.selectedPedido = selectedPedido;
    }
    
    public String aprobarPedido(){
        if (pedido.getAprobado()==0){
            pedido.setAprobado(1);
            dAOPedidoSB.modifica(pedido);
        }
        return "";
    }        

    public String anularPedido(){
       pedido.setEstado("An");
       dAOPedidoSB.modifica(pedido);
       return "";
    }          
    
    public List<Pedido> getListaPedidoAprobar() {
        listaPedidoAprobar = dAOPedidoSB.buscarPedidoxAprobar(0);
        return listaPedidoAprobar;
    }

    public void setListaPedidoAprobar(List<Pedido> listaPedidoAprobar) {
        this.listaPedidoAprobar = listaPedidoAprobar;
    }

    public DataModel<Ordenproduccion> getListaDetalle() {
        return listaDetalle;
    }

    public List<Ordenproduccion> getListaDt() {
        return listaDt;
    }

    public void setListaDt(List<Ordenproduccion> listaDt) {
        this.listaDt = listaDt;
    }

    public Ordenproduccion getDt() {
        return dt;
    }

    public void setDt(Ordenproduccion dt) {
        this.dt = dt;
    }

    public List<Pedido> getListaPedidoPe() {
        listaPedidoPe = dAOPedidoSB.buscarPedidoxEstado("Pe");  
        return listaPedidoPe;
    }

    public void setListaPedidoPe(List<Pedido> listaPedidoPe) {
        this.listaPedidoPe = listaPedidoPe;
    }

    public List<Pedido> getListaPedidoPr() {
        listaPedidoPr = dAOPedidoSB.buscarPedidoxEstado("Pr");  
        return listaPedidoPr;
    }

    public void setListaPedidoPr(List<Pedido> listaPedidoPr) {
        this.listaPedidoPr = listaPedidoPr;
    }

    public List<Pedido> getListaPedidoTe() {
        listaPedidoTe = dAOPedidoSB.buscarPedidoxEstado("Te");  
        return listaPedidoTe;
    }

    public void setListaPedidoTe(List<Pedido> listaPedidoTe) {
        this.listaPedidoTe = listaPedidoTe;
    }

    public List<Pedido> getListaTodos() {
        listaTodos = dAOPedidoSB.listarTodos();  
        return listaTodos;
    }

    public void setListaTodos(List<Pedido> listaTodos) {
        this.listaTodos = listaTodos;
    }
}
