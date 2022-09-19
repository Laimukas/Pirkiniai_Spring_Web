package lt.bit.pirkiniai.data;

import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prekes")
public class Preke {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "cekis_id")
    private Cekis cekis;
    private String preke;
    private BigDecimal kiekis;
    private BigDecimal kaina;
    @ManyToOne
    @JoinColumn(name = "tipas_id")
    private Tipas tipas;

    public Preke() {
    }

    public Preke(Integer id, Cekis cekis, String preke, BigDecimal kiekis, BigDecimal kaina, Tipas tipas) {
        this.id = id;
        this.cekis = cekis;
        this.preke = preke;
        this.kiekis = kiekis;
        this.kaina = kaina;
        this.tipas = tipas;
    }

    public Tipas getTipas() {
        return tipas;
    }

    public void setTipas(Tipas tipas) {
        this.tipas = tipas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cekis getCekis() {
        return cekis;
    }

    public void setCekis(Cekis cekis) {
        this.cekis = cekis;
    }

    public String getPreke() {
        return preke;
    }

    public void setPreke(String preke) {
        this.preke = preke;
    }

    public BigDecimal getKiekis() {
        return kiekis;
    }

    public void setKiekis(BigDecimal kiekis) {
        this.kiekis = kiekis;
    }

    public BigDecimal getKaina() {
        return kaina;
    }

    public void setKaina(BigDecimal kaina) {
        this.kaina = kaina;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Preke other = (Preke) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Preke{" + "id=" + id + ", cekis=" + cekis + ", preke=" + preke + ", kiekis=" + kiekis + ", kaina=" + kaina + ", tipas=" + tipas + '}';
    }
    
}
