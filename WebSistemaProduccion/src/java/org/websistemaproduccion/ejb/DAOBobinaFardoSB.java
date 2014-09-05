/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.websistemaproduccion.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.websistemaproduccion.entidades.Bobinafardo;
import org.websistemaproduccion.entidades.Bodega;
import org.websistemaproduccion.entidades.Pedido;

@Stateless
public class DAOBobinaFardoSB extends DAOEntidadSB<Bobinafardo> {
    @PersistenceContext(unitName = "WebSistemaProduccionPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public Bobinafardo buscarBobinaxCodigo(Bobinafardo bobinafardo) {
        Bobinafardo bf = null;
        Query q = em.createNamedQuery("Bobinafardo.findByIdBobinaFardo");
        q.setParameter("idBobinaFardo", bobinafardo.getIdBobinaFardo());
        bf = (Bobinafardo) q.getSingleResult();
        return bf;
    }  

    public Bobinafardo buscarBobinaCodigo(String codigo) {
        Bobinafardo bf = null;
        Query q = em.createNamedQuery("Bobinafardo.findByIdBobinaFardo");
        q.setParameter("idBobinaFardo", codigo);
        bf = (Bobinafardo) q.getSingleResult();
        return bf;
    }      
    
    public int ConteoBobinas(int idOrden) {
        Query q = em.createNamedQuery("Bobinafardo.conteoSecuencia");
        q.setParameter("idOrden", idOrden);
        return ((Long) q.getSingleResult()).intValue()+1;
    }   
    
    public String EtapaAnterior(String etapa, Pedido pedido){
        String etapa_anterior = "";
        if (etapa.equals("Re")){
            etapa_anterior = "Ex";
        }
        
	if (etapa.equals("Cs")){
            etapa_anterior = "Db";
        }
        
	if (etapa.equals("Fl")){
            if (pedido.getRefilado() == 1){
		etapa_anterior = "Re";
            }else{
		etapa_anterior = "Ex";
            }    
        }
    
	if (etapa.equals("Db")){
            if (pedido.getImpresa() == 1){
		etapa_anterior = "Fl";
            }else{
		if (pedido.getRefilado() == 1){
                    etapa_anterior = "Re";
                }else{
                    etapa_anterior = "Ex";
                }
            }
        } 
        return etapa_anterior;
    }
    
    public String EtapaPedido(String etapa, Pedido pedido){
        String nueva_etapa= "";
        
        if (etapa.equals(pedido.getEtapa())){
           if (pedido.getEtapa().equals("Ex")){
               if (pedido.getRefilado() == 1){
                   nueva_etapa = "Re";
               }else{
                   if (pedido.getImpresa() == 1){
                       nueva_etapa = "Fl";
                   }else{
                       if(pedido.getIdProducto().getNombre().equals("BOLSA")){
                           nueva_etapa = "Db";
                       }else{
                           if(pedido.getDoblado()==1){
                               nueva_etapa = "Db";
                           }else{
                                nueva_etapa = "Ex";
                           }
                       }
                   }
               }               
           }
        
            /* Etapa de Refilado */
           if (pedido.getEtapa().equals("Re")){
              if (pedido.getImpresa() == 1){
                  nueva_etapa = "Fl";
              }else{
                  if (pedido.getIdProducto().getNombre().equals("BOLSA")){
                     nueva_etapa = "Db";
                  }else{
                     if (pedido.getDoblado()== 1){
                        nueva_etapa = "Db";
                     }else{
                        nueva_etapa = "Re";
                     } 
                  }
              }
           }

           /* Etapa de Flexografía */
           if (pedido.getEtapa().equals("Fl")){
              if (pedido.getIdProducto().getNombre().equals("BOLSA")){
                  nueva_etapa = "Db";
              }else{
                  if (pedido.getDoblado()== 1){
                     nueva_etapa = "Db";
                  }else{
                     nueva_etapa = "Fl";	
                  }
              }
           }

           /* Etapa de Doblado */
           if (pedido.getEtapa().equals("Db")){
              if (pedido.getIdProducto().getNombre().equals("BOLSA")){
                  nueva_etapa = "Cs";
              }else{
                  nueva_etapa = "Db";	
              }
           }

           /* Etapa de Corte y Sello */
           if (pedido.getEtapa().equals("CS")){
                nueva_etapa = "Cs";
           }           
           
        }else{
           nueva_etapa = pedido.getEtapa();
        }
        return nueva_etapa;
    }
    

    public List<Bobinafardo> listarDetalleOrden(int idOrden) {
        List<Bobinafardo> lista = null;
        try {
            Query q = em.createNamedQuery("Bobinafardo.findByIdOrden");
            q.setParameter("idOrden", idOrden);
            lista = q.getResultList();
        } catch (Exception e) {
            return null;
        }
        return lista;
    }           
    
    public List<Bobinafardo> listarBobinasEntrada(String etapaAnt, Pedido pedido, Bodega bodega) {
        List<Bobinafardo> lista = null;
        try {
            Query q = em.createNamedQuery("Bobinafardo.findByEtapaAnt");
            q.setParameter("etapaAnt", (etapaAnt).concat("%"));
            q.setParameter("idPedido", pedido.getIdPedido());
            q.setParameter("idBodega", bodega.getIdBodega());
            lista = q.getResultList();
        } catch (Exception e) {
            return null;
        }
        return lista;
    }     
    
      public List<Bobinafardo> listarTodos() {
        List<Bobinafardo> lista = null;
        try {
            Query q = em.createNamedQuery("Bobinafardo.findAll");
            lista = q.getResultList();
        } catch (Exception e) {
            return null;
        }
        return lista;
    }       
}
