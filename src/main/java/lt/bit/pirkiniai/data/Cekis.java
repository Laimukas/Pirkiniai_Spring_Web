package lt.bit.pirkiniai.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cekiai")
public class Cekis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date data;
    private String parduotuve;
    private String aprasymas;
    @OneToMany(mappedBy = "cekis")
    @JsonIgnore
    private List<Preke> prekes;

    public Cekis() {
    }

    public Cekis(Integer id, Date data, String parduotuve, String aprasymas) {
        this.id = id;
        this.data = data;
        this.parduotuve = parduotuve;
        this.aprasymas = aprasymas;
    }

    public String getAprasymas() {
        return aprasymas;
    }

    public void setAprasymas(String aprasymas) {
        this.aprasymas = aprasymas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getParduotuve() {
        return parduotuve;
    }

    public void setParduotuve(String parduotuve) {
        this.parduotuve = parduotuve;
    }

    public List<Preke> getPrekes() {
        return prekes;
    }

    public void setPrekes(List<Preke> prekes) {
        this.prekes = prekes;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.id);
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
        final Cekis other = (Cekis) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Cekis{" + "id=" + id + ", data=" + data + ", parduotuve=" + parduotuve + ", aprasymas=" + aprasymas + '}';
    }

}
