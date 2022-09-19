package lt.bit.pirkiniai.data;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipai")
public class Tipas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String pavadinimas;

    public Tipas() {
    }

    public Tipas(Integer id, String pavadinimas) {
        this.id = id;
        this.pavadinimas = pavadinimas;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
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
        final Tipas other = (Tipas) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Tipas{" + "id=" + id + ", pavadinimas=" + pavadinimas + '}';
    }

}
