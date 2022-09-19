package lt.bit.pirkiniai.controllers;

import lt.bit.pirkiniai.dao.CekisDAO;
import lt.bit.pirkiniai.dao.PrekeDAO;
import lt.bit.pirkiniai.dao.TipasDAO;
import lt.bit.pirkiniai.data.Cekis;
import lt.bit.pirkiniai.data.Preke;
import lt.bit.pirkiniai.data.Tipas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("preke")
public class PrekeController {

    @Autowired
    private PrekeDAO prekeDAO;

    @Autowired
    private CekisDAO cekisDAO;

    @Autowired
    private TipasDAO tipasDAO;

    @GetMapping
    public ModelAndView sarasas(@RequestParam(value = "cekisId", required = true) Integer cekisId) {
        ModelAndView mav = new ModelAndView("prekes");
        mav.addObject("cekis", cekisDAO.findById(cekisId).get());
        return mav;
    }

    @GetMapping("edit")
    public ModelAndView edit(
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "cekisId", required = true) Integer cekisId
    ) {
        ModelAndView mav;
        if (id == null) {
            mav = new ModelAndView("preke");
        } else {
            Optional<Preke> oPreke = prekeDAO.findById(id);
            if (oPreke.isPresent()) {
                mav = new ModelAndView("preke");
                mav.addObject("value", oPreke.get());
            } else {
                mav = sarasas(cekisId);
            }
        }
        mav.addObject("tipai",tipasDAO.findAll());
        return mav;
    }

    @PostMapping("save")
    @Transactional
    public ModelAndView save(
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam(value = "cekis_id", required = true) Integer cekisId,
            @RequestParam("preke") String preke,
            @RequestParam("kiekis") BigDecimal kiekis,
            @RequestParam("kaina") BigDecimal kaina,
            @RequestParam("tipas_id") Integer tipasId
    ) {
        ModelAndView mav;
        if (id == null) {
            Preke p = new Preke();
            Optional<Cekis> oCekis = cekisDAO.findById(cekisId);
            mav = new ModelAndView("cekis");
            mav.addObject("value", oCekis.get());
            p.setCekis(oCekis.get());
            p.setPreke(preke);
            p.setKiekis(kiekis);
            p.setKaina(kaina);
            Optional<Tipas> oTipas = tipasDAO.findById(tipasId);
            mav = new ModelAndView("tipas");
            mav.addObject("value", oTipas.get());
            p.setTipas(oTipas.get());

            prekeDAO.save(p);
        } else {
            Optional<Preke> oPreke = prekeDAO.findById(id);
            if (oPreke.isPresent()) {
                Preke p = oPreke.get();

                Optional<Cekis> oCekis = cekisDAO.findById(cekisId);
                mav = new ModelAndView("cekis");
                mav.addObject("value", oCekis.get());
                p.setCekis(oCekis.get());
                p.setPreke(preke);
                p.setKiekis(kiekis);
                p.setKaina(kaina);
                Optional<Tipas> oTipas = tipasDAO.findById(tipasId);
                mav = new ModelAndView("tipas");
                mav.addObject("value", oTipas.get());
                p.setTipas(oTipas.get());
                prekeDAO.save(p);
            }
        }
        return sarasas(cekisId);
    }

    @GetMapping("delete")
    @Transactional
    public ModelAndView delete(
            @RequestParam("id") Integer id,
            @RequestParam(value = "cekisId", required = true) Integer cekisId
            ) {
        prekeDAO.deleteById(id);
        return sarasas(cekisId);
    }

    @GetMapping("pagalTipa")
    public ModelAndView pagalTipa(){
        ModelAndView mav = new ModelAndView("pagalTipa");
        mav.addObject("tipai", tipasDAO.findAll());
        return mav;
    }

    @PostMapping("tipas")
    public ModelAndView tipas(
            @RequestParam("tipas_id") Integer tipasId
    ) {

        ModelAndView mav = new ModelAndView("prekesPagalTipa");
        List<Preke> visosPrekes = prekeDAO.pagalTipa(tipasId);
        mav.addObject("list", visosPrekes);

        BigDecimal islaidos = new BigDecimal(0);

        for (Preke preke:visosPrekes){
            islaidos= islaidos.add(preke.getKaina().multiply(preke.getKiekis()));
        }
        mav.addObject("suma",islaidos);
        return mav;
    }
}

