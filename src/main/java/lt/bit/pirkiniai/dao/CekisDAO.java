package lt.bit.pirkiniai.dao;

import lt.bit.pirkiniai.data.Cekis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface CekisDAO extends JpaRepository<Cekis, Integer>{

    @Query("select c from Cekis c where c.data >= :nuo and c.data <= :iki")
    public List<Cekis> pagalLaika(
            @Param("nuo")
            Date nuo,
            @Param("iki")
            Date iki );
    
}
