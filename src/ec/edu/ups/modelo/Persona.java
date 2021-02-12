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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Andres
 */
@Entity
@NamedQuery(name ="consultaCedula",query = "Select p from Persona p where p.cedula= :cedula")
@NamedQuery(name ="consultaNombre",query = "Select p from Persona p where p.nombre= :nombre")
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//partes de la tabla
@Column
@NotNull
private String cedula;
@Column
private String nombre;
@Column
private String apellido;
@Column
private String fechaNacimiento ;
@Column
private String direccion;
@Column
private Double salario;
//relacion
@OneToMany(mappedBy="persona", cascade=CascadeType.ALL)

private List<Casa>lsitaCasa;

@ManyToOne
@JoinColumn(name ="fk_banco")
private Banco banco;
//getters y setters

    public Persona() {
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public Persona(Long id, String cedula, String nombre, String apellido, String fechaNacimiento, String direccion, Double salario, Banco banco) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.salario = salario;
        this.banco = banco;
    }

    public Persona(Long id, String cedula, String nombre, String apellido, String fechaNacimiento, String direccion, Double salario) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.salario = salario;
    }


    public List<Casa> getLsitaCasa() {
        return lsitaCasa;
    }

    public void setLsitaCasa(List<Casa> lsitaCasa) {
        this.lsitaCasa = lsitaCasa;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
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
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", fechaNacimiento=" + fechaNacimiento + ", apellido=" + apellido + ", direccion=" + direccion + ", salario=" + salario + '}';
    }

 
    
}