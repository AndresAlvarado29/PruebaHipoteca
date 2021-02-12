/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.utils.JPAUtils;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Andres
 */
public abstract class AbstractControlador <E> {
private List<E> lista;
private Class<E> clase;
private EntityManager em;

 public AbstractControlador() {
        lista = new ArrayList();
        Type t =getClass().getGenericSuperclass();
        ParameterizedType pt=(ParameterizedType)t;
        clase = (Class) pt.getActualTypeArguments()[0];
        em = JPAUtils.getEntityManager();
    }
    public AbstractControlador(EntityManager em) {
        lista = new ArrayList();
        Type t =getClass().getGenericSuperclass();
        ParameterizedType pt=(ParameterizedType)t;
        clase = (Class) pt.getActualTypeArguments()[0];
        this.em = em;
    }
public E crear(E objeto) throws Exception{
this.validar(objeto);
em.getTransaction().begin();
em.persist(objeto);
em.getTransaction().commit();
lista.add(objeto);
return objeto;
}
public boolean eliminar(E objeto){
em.getTransaction().begin();
em.remove(em.merge(objeto));
em.getTransaction().commit();
lista.remove(objeto);
return true;
}  
public E actualizar(E objeto)throws Exception{
    this.validar(objeto);
em.getTransaction().begin();
objeto=em.merge(objeto);
em.getTransaction().commit();
lista= this.buscarTodo();
return objeto;
}
public E buscar(Object id){
return(E) em.find(clase, id);
}
public List<E> buscarTodo(){
return em.createQuery("Select t from "+clase.getSimpleName()+" t ").getResultList();
}


public abstract boolean validar(E objeto)throws Exception;

    public List<E> getLista() {
        return lista;
    }

    public void setLista(List<E> lista) {
        this.lista = lista;
    }

    public Class<E> getClase() {
        return clase;
    }

    public void setClase(Class<E> clase) {
        this.clase = clase;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }


}
