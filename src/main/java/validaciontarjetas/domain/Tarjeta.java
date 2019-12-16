package validaciontarjetas.domain;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;

/**
 * A Tarjeta.
 */
@Entity
@Table(name = "tarjeta")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Tarjeta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "numero")
    private String numero;

    @Column(name = "cod_seguridad")
    private Integer codSeguridad;

    @Column(name = "fecha_vencimiento")
    private Integer fechaVencimiento;

    @Column(name = "monto_max")
    private Double montoMax;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public Tarjeta tipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public Tarjeta numero(String numero) {
        this.numero = numero;
        return this;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Integer getCodSeguridad() {
        return codSeguridad;
    }

    public Tarjeta codSeguridad(Integer codSeguridad) {
        this.codSeguridad = codSeguridad;
        return this;
    }

    public void setCodSeguridad(Integer codSeguridad) {
        this.codSeguridad = codSeguridad;
    }

    public Integer getFechaVencimiento() {
        return fechaVencimiento;
    }

    public Tarjeta fechaVencimiento(Integer fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
        return this;
    }

    public void setFechaVencimiento(Integer fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Double getMontoMax() {
        return montoMax;
    }

    public Tarjeta montoMax(Double montoMax) {
        this.montoMax = montoMax;
        return this;
    }

    public void setMontoMax(Double montoMax) {
        this.montoMax = montoMax;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Tarjeta)) {
            return false;
        }
        return id != null && id.equals(((Tarjeta) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Tarjeta{" +
            "id=" + getId() +
            ", tipo='" + getTipo() + "'" +
            ", numero='" + getNumero() + "'" +
            ", codSeguridad=" + getCodSeguridad() +
            ", fechaVencimiento=" + getFechaVencimiento() +
            ", montoMax=" + getMontoMax() +
            "}";
    }
}
