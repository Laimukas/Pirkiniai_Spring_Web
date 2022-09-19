package lt.bit.pirkiniai.controllers;

import java.util.Optional;
import lt.bit.pirkiniai.dao.TipasDAO;
import lt.bit.pirkiniai.data.Tipas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("tipas")
public class TipasController {
    
    @Autowired
    private TipasDAO tipasDAO;
    
    @GetMapping
    public ModelAndView sarasas() {
        ModelAndView mav = new ModelAndView("tipai");
        mav.addObject("list", tipasDAO.findAll());
        return mav;
    }

    @GetMapping("edit")
    public ModelAndView edit(@RequestParam(value = "id", required = false) Integer id) {
        ModelAndView mav;
        if (id == null) {
            mav = new ModelAndView("tipas");
        } else {
            Optional<Tipas> oTipas = tipasDAO.findById(id);
            if (oTipas.isPresent()) {
                mav = new ModelAndView("tipas");
                mav.addObject("value", oTipas.get());
            } else {
                mav = sarasas();
            }
        }
        return mav;
    }

    @PostMapping("save")
    @Transactional
    public ModelAndView save(
            @RequestParam(value = "id", required = false) Integer id,
            @RequestParam("pavadinimas") String pavadinimas
    ) {
        if (id == null) {
            Tipas t = new Tipas();
            t.setPavadinimas(pavadinimas);
            tipasDAO.save(t);
        } else {
            Optional<Tipas> oTipas = tipasDAO.findById(id);
            if (oTipas.isPresent()) {
                Tipas t = oTipas.get();
                t.setPavadinimas(pavadinimas);
                tipasDAO.save(t);
            }
        }
        return sarasas();
    }
    
    @GetMapping("delete")
    @Transactional
    public ModelAndView delete(@RequestParam("id") Integer id) {
        tipasDAO.deleteById(id);
        return sarasas();
    }

}
/*
padaryti prekiu redagavima cekyje (pridejimas, keitimas, trynimas)

dvi ataskaitos:
islaidos pagal tipa
islaidos uz nurodyta laiko tarpa

*/