package lt.bit.pirkiniai.dao;

import lt.bit.pirkiniai.data.Tipas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipasDAO extends JpaRepository<Tipas, Integer>{
    
}
