/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import com.sun.istack.internal.NotNull;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Andres
 */
@Entity
public class Banco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
@Column
@NotNull
private int hipotecas;
@Column
private int avals;
@OneToMany(mappedBy="banco", cascade=CascadeType.ALL)
private List<Persona>listaPersona;
@OneToMany(mappedBy="banco", cascade=CascadeType.ALL)
private List<Persona>listaGarante;
@Column
private double importe;
@Column
private int plazo;
@Column
private double pagos;
@Column
private double cuotas;

    public Banco() {
    }

    public Banco(int hipotecas, int avals, double importe, int plazo, double pagos, double cuotas) {
        this.hipotecas = hipotecas;
        this.avals = avals;
        this.importe = importe;
        this.plazo = plazo;
        this.pagos = pagos;
        this.cuotas = cuotas;
    }

    public Banco(Long id, int hipotecas, int avals, double importe, int plazo, double pagos, double cuotas) {
        this.id = id;
        this.hipotecas = hipotecas;
        this.avals = avals;
        this.importe = importe;
        this.plazo = plazo;
        this.pagos = pagos;
        this.cuotas = cuotas;
    }



    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public double getPagos() {
        return pagos;
    }

    public void setPagos(double pagos) {
        this.pagos = pagos;
    }

    
    public double getCuotas() {
        return cuotas;
    }

    public void setCuotas(double cuotas) {
        this.cuotas = cuotas;
    }

    

    public int getHipotecas() {
        return hipotecas;
    }

    public void setHipotecas(int hipotecas) {
        this.hipotecas = hipotecas;
    }

    public int getAvals() {
        return avals;
    }

    public void setAvals(int avals) {
        this.avals = avals;
    }

    public List<Persona> getListaPersona() {
        return listaPersona;
    }

    public void setListaPersona(List<Persona> listaPersona) {
        this.listaPersona = listaPersona;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Banco)) {
            return false;
        }
        Banco other = (Banco) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.ups.modelo.Banco[ id=" + id + " ]";
    }
    
}
