package lt.bit.pirkiniai.controllers;

import lt.bit.pirkiniai.dao.CekisDAO;
import lt.bit.pirkiniai.dao.PrekeDAO;
import lt.bit.pirkiniai.dao.TipasDAO;
import lt.bit.pirkiniai.data.Cekis;
import lt.bit.pirkiniai.data.Preke;
import lt.bit.pirkiniai.data.Tipas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("ws/cekis/{cekisId}/preke")

public class PrekeREST {

    @Autowired
    private PrekeDAO prekeDAO;

    @Autowired
    private CekisDAO cekisDAO;

    @Autowired
    private TipasDAO tipasDAO;

    @Autowired
    private HttpServletResponse response;

    @GetMapping
    public List<Preke> list(
            @PathVariable("cekisId") Integer id
    ) {
        Optional<Cekis> oCekis = cekisDAO.findById(id);
        if (oCekis.isPresent()) {
            return oCekis.get().getPrekes();
        }
        return null;
    }

    @GetMapping("{prekeId}")
    public Preke getOne(
            @PathVariable("cekisId") Integer cekisId,
            @PathVariable("prekeId") Integer id
    ) {
        Optional<Cekis> oCekis = cekisDAO.findById(cekisId);
        Optional<Preke> oPreke = prekeDAO.findById(id);
        if (oPreke.isPresent() && oCekis.isPresent()) {
            return oPreke.get();
        }
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        return null;
    }

    @PutMapping("{prekeId}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("prekeId") Integer id, @RequestBody Preke preke) {
        Optional<Preke> oPreke = prekeDAO.findById(id);
        if (oPreke.isPresent()) {
            Preke dbPreke = oPreke.get();
            dbPreke.setPreke(preke.getPreke());
            dbPreke.setKaina(preke.getKaina());
            dbPreke.setKiekis(preke.getKiekis());
            prekeDAO.save(dbPreke);
        }
    }

    @PostMapping
    @Transactional
    public Preke add(
            @PathVariable("cekisId") Integer cekisId,
            @RequestBody Preke preke
    ) {
        preke.setId(null);
        Cekis c = cekisDAO.findById(cekisId).get();
        preke.setCekis(c);
        Tipas tipas = tipasDAO.findById(preke.getTipas().getId()).get();
        preke.setTipas(tipas);
        prekeDAO.save(preke);
        return preke;
    }

    @DeleteMapping("{prekeId}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("prekeId") Integer id) {
        Optional<Preke> oPreke = prekeDAO.findById(id);
        if (oPreke.isPresent()) {
            prekeDAO.delete(oPreke.get());
        }
    }
}
