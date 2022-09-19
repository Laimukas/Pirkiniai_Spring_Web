package lt.bit.pirkiniai.controllers;

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import lt.bit.pirkiniai.dao.CekisDAO;
import lt.bit.pirkiniai.data.Cekis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ws/cekis")
public class CekisREST {
    
    @Autowired
    private CekisDAO cekisDAO;
    
    @Autowired
    private HttpServletResponse response;
    
    @GetMapping
    public List<Cekis> list() {
        return cekisDAO.findAll();
    }
    
    @GetMapping("{id}")
    public Cekis getOne(@PathVariable("id") Integer id) {
        Optional<Cekis> oCekis = cekisDAO.findById(id);
        if (oCekis.isPresent()) {
            return oCekis.get();
        }
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        return null;
    }
    
    @PutMapping("{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") Integer id, @RequestBody Cekis cekis) {
        Optional<Cekis> oCekis = cekisDAO.findById(id);
        if (oCekis.isPresent()) {
            Cekis dbCekis = oCekis.get();
            dbCekis.setData(cekis.getData());
            dbCekis.setParduotuve(cekis.getParduotuve());
            dbCekis.setAprasymas(cekis.getAprasymas());
            cekisDAO.save(dbCekis);
        }
    }
    
    @PostMapping
    @Transactional
    public Cekis add(@RequestBody Cekis cekis) {
        cekis.setId(null);
        cekisDAO.save(cekis);
        return cekis;
    }


    @DeleteMapping("{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        Optional<Cekis> oCekis = cekisDAO.findById(id);
        if (oCekis.isPresent()) {
            cekisDAO.delete(oCekis.get());
        }
    }
    
}
