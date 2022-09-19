package lt.bit.pirkiniai.dao;

import lt.bit.pirkiniai.data.Preke;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PrekeDAO extends JpaRepository<Preke, Integer>{

    @Query("select p from Preke p where p.tipas.id = :tipId")
    public List<Preke> pagalTipa(
            @Param("tipId")
            Integer tipId);
}
