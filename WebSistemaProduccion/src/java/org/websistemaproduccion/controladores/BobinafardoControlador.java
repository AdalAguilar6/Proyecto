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
import org.websistemaproduccion.ejb.DAOBobinaFardoSB;
import org.websistemaproduccion.ejb.DAOBodegaSB;
import org.websistemaproduccion.ejb.DAOOrdenProduccionSB;
import org.websistemaproduccion.ejb.DAOPedidoSB;
import org.websistemaproduccion.entidades.Bobinafardo;
import org.websistemaproduccion.entidades.Bodega;
import org.websistemaproduccion.entidades.Ordenproduccion;
import org.websistemaproduccion.entidades.Pedido;

/**
 *
 * @author Super Usuario
 */
@ManagedBean
@SessionScoped
public class BobinafardoControlador implements Serializable{
    @EJB
    private DAOPedidoSB dAOPedidoSB;
    @EJB
    private DAOBodegaSB dAOBodegaSB;
    @EJB
    private DAOOrdenProduccionSB dAOOrdenProduccionSB;
    @EJB
    private DAOBobinaFardoSB dAOBobinaFardoSB;
    private Bobinafardo bobinafardo;
    private Bobinafardo bobinafardoAnt;
    private Bobinafardo bobinafardoSelect;
    private Bobinafardo bobinafardoEntrada;
    private Ordenproduccion ordenproduccion;
    Date fecha = new Date();    
    private String procesoOrden;
    private int correlativoOrden;
    private String codigo;
    private String codigoAnt;
    int x=0;
    private Bodega bodega;
    private String etapa;
    private String etapaAnt;
    private Pedido pedido;
    private float pesoEntrada= 0;
    private List<Bobinafardo> listaDetallexOrden;
    private List<Bobinafardo> listaBobinasEntrada;

    /**
     * Creates a new instance of BobinafardoControlador
     */
    public BobinafardoControlador() {
        bobinafardo = new Bobinafardo("-", 0, 0, fecha, fecha, "-", 0);
        bobinafardoSelect = new Bobinafardo("-", 0, 0, fecha, fecha, "-", 0);
    }

    public Bobinafardo getBobinafardo() {
        return bobinafardo;
    }

    public void setBobinafardo(Bobinafardo bobinafardo) {
        this.bobinafardo = bobinafardo;
    }
    
    public String insertar(){
        try{
            if (bobinafardo.getIdBobinaFardoEntrada()== null){
                pesoEntrada = 0;
            }else{
                bobinafardoEntrada = dAOBobinaFardoSB.buscarBobinaCodigo(bobinafardo.getIdBobinaFardoEntrada());
                pesoEntrada = bobinafardoEntrada.getPeso();
            }
            bobinafardo.setPesoEntrada(pesoEntrada);
            
            dAOBobinaFardoSB.insertar(bobinafardo);
            dAOPedidoSB.modifica(pedido);
            FacesMessage facesMsg = new 
            FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Bobinafardo.insertar", 
                    "Registro con éxito");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Bobinafardo.insertar",  e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }            
        return "";
    }
    
    public String buscarBobinaCodigo(){
        Bobinafardo bobinaCargadoDesdeBD = null;
        bobinaCargadoDesdeBD = dAOBobinaFardoSB.buscarBobinaxCodigo(bobinafardo);
        this.bobinafardo = bobinaCargadoDesdeBD;
        return "";
    }
    
    public String buscarBobinaxCodigo(String codigo ){
        Bobinafardo bobinaCargadoDesdeBD = null;
        bobinaCargadoDesdeBD = dAOBobinaFardoSB.buscarBobinaCodigo(codigo);
        this.bobinafardoSelect = bobinaCargadoDesdeBD;
        return "";
    }    
    
    public String eliminaBobina(){
        try{
            dAOBobinaFardoSB.elimina(bobinafardo);
            FacesMessage facesMsg = new 
            FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Bobinafardo.eliminar", 
                    "Registro con éxito");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Bobinafardo.eliminar",  e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }  
        return "";
    }
    
    public String modificaBobina(){
        try{
            dAOBobinaFardoSB.modifica(bobinafardo);
            FacesMessage facesMsg = new 
            FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Bobinafardo.modificar", 
                    "Registro con éxito");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Bobinafardo.modificar",  e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }  
        return "";
    }

    public String eliminaBobinaSelect(){
        try{    
            bobinafardo=bobinafardoSelect;
            dAOBobinaFardoSB.elimina(bobinafardo);
            FacesMessage facesMsg = new 
            FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Bobinafardo.eliminar", 
                    "Registro con éxito");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Bobinafardo.eliminar",  e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }          
        return "";
    }
    
    public String modificaBobinaSelect(){
        try{
            bobinafardo=bobinafardoSelect;
            dAOBobinaFardoSB.modifica(bobinafardo);
            FacesMessage facesMsg = new 
            FacesMessage(FacesMessage.SEVERITY_INFO, 
                    "Bobinafardo.modificar", 
                    "Registro con éxito");
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        } catch (Exception e) {
            FacesMessage facesMsg = new 
                    FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Bobinafardo.modificar",  e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        }  
        return "";
    }    
    
    
    public void filtrarOrdenEx(int idOrden){
        inicializarOrden(idOrden);
        codigo = "P".concat(ordenproduccion.getIdPedido().toString().concat("-".concat("E".concat(String.valueOf(correlativoOrden).concat("-SKU-".concat(String.valueOf(x)))))));        
        codigoAnt = "P".concat(ordenproduccion.getIdPedido().toString().concat("-".concat("E".concat(String.valueOf(correlativoOrden).concat("-SKU-".concat(String.valueOf(x-1)))))));        
        bobinafardo.setIdBobinaFardo(codigo);
        
        if ((x-1)>0){
            bobinafardoAnt = dAOBobinaFardoSB.buscarBobinaCodigo(codigoAnt);
            bobinafardo.setHoraInicio(bobinafardoAnt.getHoraFinal());
        }
        pedido = dAOPedidoSB.buscarPedidoId(ordenproduccion.getIdPedido().getIdPedido());
        
        etapa = dAOBobinaFardoSB.EtapaPedido("Ex",pedido);
        pedido.setEtapa(etapa);
        pedido.setEstado("Pe");
    }        
  
    public void filtrarOrdenFl(int idOrden){
        inicializarOrden(idOrden);
        codigo = "P".concat(ordenproduccion.getIdPedido().toString().concat("-".concat("F".concat(String.valueOf(correlativoOrden).concat("-SKU-".concat(String.valueOf(x)))))));        
        codigoAnt = "P".concat(ordenproduccion.getIdPedido().toString().concat("-".concat("F".concat(String.valueOf(correlativoOrden).concat("-SKU-".concat(String.valueOf(x-1)))))));        
        bobinafardo.setIdBobinaFardo(codigo);
        if ((x-1)>0){
            bobinafardoAnt = dAOBobinaFardoSB.buscarBobinaCodigo(codigoAnt);
            bobinafardo.setHoraInicio(bobinafardoAnt.getHoraFinal());
        }        
        pedido = dAOPedidoSB.buscarPedidoId(ordenproduccion.getIdPedido().getIdPedido());
        
        etapa = dAOBobinaFardoSB.EtapaPedido("Fl",pedido);
        pedido.setEtapa(etapa);
        pedido.setEstado("Pe");        

        etapaAnt = dAOBobinaFardoSB.EtapaAnterior("Fl", pedido);
    }       

    public void filtrarOrdenRe(int idOrden){
        inicializarOrden(idOrden);
        codigo = "P".concat(ordenproduccion.getIdPedido().toString().concat("-".concat("R".concat(String.valueOf(correlativoOrden).concat("-SKU-".concat(String.valueOf(x)))))));        
        codigoAnt = "P".concat(ordenproduccion.getIdPedido().toString().concat("-".concat("R".concat(String.valueOf(correlativoOrden).concat("-SKU-".concat(String.valueOf(x-1)))))));        
        bobinafardo.setIdBobinaFardo(codigo);
        
        if ((x-1)>0){
            bobinafardoAnt = dAOBobinaFardoSB.buscarBobinaCodigo(codigoAnt);
            bobinafardo.setHoraInicio(bobinafardoAnt.getHoraFinal());
        }        
        pedido = dAOPedidoSB.buscarPedidoId(ordenproduccion.getIdPedido().getIdPedido());
        
        etapa = dAOBobinaFardoSB.EtapaPedido("Re",pedido);
        pedido.setEtapa(etapa);
        pedido.setEstado("Pe");        

        etapaAnt = dAOBobinaFardoSB.EtapaAnterior("Re", pedido);

    }       

    public void filtrarOrdenDb(int idOrden){
        inicializarOrden(idOrden);
        codigo = "P".concat(ordenproduccion.getIdPedido().toString().concat("-".concat("D".concat(String.valueOf(correlativoOrden).concat("-SKU-".concat(String.valueOf(x)))))));        
        codigoAnt = "P".concat(ordenproduccion.getIdPedido().toString().concat("-".concat("D".concat(String.valueOf(correlativoOrden).concat("-SKU-".concat(String.valueOf(x-1)))))));        
        bobinafardo.setIdBobinaFardo(codigo);
        if ((x-1)>0){
            bobinafardoAnt = dAOBobinaFardoSB.buscarBobinaCodigo(codigoAnt);
            bobinafardo.setHoraInicio(bobinafardoAnt.getHoraFinal());
        }        
        pedido = dAOPedidoSB.buscarPedidoId(ordenproduccion.getIdPedido().getIdPedido());
        
        etapa = dAOBobinaFardoSB.EtapaPedido("Db",pedido);
        pedido.setEtapa(etapa);
        pedido.setEstado("Pe");        

        etapaAnt = dAOBobinaFardoSB.EtapaAnterior("Db", pedido);
    }       
    
    public void filtrarOrdenCs(int idOrden){
        inicializarOrden(idOrden);
        codigo = "P".concat(ordenproduccion.getIdPedido().toString().concat("-".concat("C".concat(String.valueOf(correlativoOrden).concat("-SKU-".concat(String.valueOf(x)))))));        
        codigoAnt = "P".concat(ordenproduccion.getIdPedido().toString().concat("-".concat("C".concat(String.valueOf(correlativoOrden).concat("-SKU-".concat(String.valueOf(x-1)))))));        
        bobinafardo.setIdBobinaFardo(codigo);
        if ((x-1)>0){
            bobinafardoAnt = dAOBobinaFardoSB.buscarBobinaCodigo(codigoAnt);
            bobinafardo.setHoraInicio(bobinafardoAnt.getHoraFinal());
        }        
        pedido = dAOPedidoSB.buscarPedidoId(ordenproduccion.getIdPedido().getIdPedido());
        
        etapa = dAOBobinaFardoSB.EtapaPedido("Cs",pedido);
        pedido.setEtapa(etapa);
        pedido.setEstado("Te");        

        etapaAnt = dAOBobinaFardoSB.EtapaAnterior("Cs", pedido);
    }       
    
    public void inicializarOrden(int idOrden){
        ordenproduccion= dAOOrdenProduccionSB.buscarOrdenId(idOrden);
        x = dAOBobinaFardoSB.ConteoBobinas(idOrden);
        bodega = dAOBodegaSB.buscarBodegaId(1);        
        procesoOrden = ordenproduccion.getProceso();
        correlativoOrden = ordenproduccion.getCorrelativo();
        bobinafardo.setIdOrden(ordenproduccion);
        bobinafardo.setSecuencial(x);
        bobinafardo.setIdBodega(bodega);
        bobinafardo.setPeso(0);
        bobinafardo.setObservacion("-");
        bobinafardo.setHoraFinal(fecha);
    }    

    public Ordenproduccion getOrdenproduccion() {
        return ordenproduccion;
    }

    public void setOrdenproduccion(Ordenproduccion ordenproduccion) {
        this.ordenproduccion = ordenproduccion;
    }

    public String getProcesoOrden() {
        return procesoOrden;
    }

    public void setProcesoOrden(String procesoOrden) {
        this.procesoOrden = procesoOrden;
    }

    public int getCorrelativoOrden() {
        return correlativoOrden;
    }

    public void setCorrelativoOrden(int correlativoOrden) {
        this.correlativoOrden = correlativoOrden;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    public Bobinafardo getBobinafardoAnt() {
        return bobinafardoAnt;
    }

    public void setBobinafardoAnt(Bobinafardo bobinafardoAnt) {
        this.bobinafardoAnt = bobinafardoAnt;
    }

    public String getCodigoAnt() {
        return codigoAnt;
    }

    public void setCodigoAnt(String codigoAnt) {
        this.codigoAnt = codigoAnt;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    public void filtrarDetalleOrden(int idOrden){
        listaDetallexOrden = dAOBobinaFardoSB.listarDetalleOrden(idOrden);
    }       
/*
    public void encontrarPeso(String codigo){
        bobinafardoEntrada = dAOBobinaFardoSB.buscarBobinaCodigo(codigo);
        pesoEntrada = bobinafardoEntrada.getPeso();
        bobinafardo.setPesoEntrada(pesoEntrada);
    }       
 */   
    public List<Bobinafardo> getListaDetallexOrden() {
        return listaDetallexOrden;
    }

    public void setListaDetallexOrden(List<Bobinafardo> listaDetallexOrden) {
        this.listaDetallexOrden = listaDetallexOrden;
    }

    public Bobinafardo getBobinafardoSelect() {
        return bobinafardoSelect;
    }

    public void setBobinafardoSelect(Bobinafardo bobinafardoSelect) {
        this.bobinafardoSelect = bobinafardoSelect;
    }

    public String getEtapaAnt() {
        return etapaAnt;
    }

    public void setEtapaAnt(String etapaAnt) {
        this.etapaAnt = etapaAnt;
    }

    public List<Bobinafardo> getListaBobinasEntrada() {
        listaBobinasEntrada = dAOBobinaFardoSB.listarBobinasEntrada(etapaAnt, pedido, bodega);
        return listaBobinasEntrada;
    }

    public void setListaBobinasEntrada(List<Bobinafardo> listaBobinasEntrada) {
        this.listaBobinasEntrada = listaBobinasEntrada;
    }

    public float getPesoEntrada() {
        return pesoEntrada;
    }

    public void setPesoEntrada(float pesoEntrada) {
        this.pesoEntrada = pesoEntrada;
    }

    public Bobinafardo getBobinafardoEntrada() {
        return bobinafardoEntrada;
    }

    public void setBobinafardoEntrada(Bobinafardo bobinafardoEntrada) {
        this.bobinafardoEntrada = bobinafardoEntrada;
    }
}
