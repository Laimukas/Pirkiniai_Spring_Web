package lt.bit.pirkiniai.controllers;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import lt.bit.pirkiniai.dao.CekisDAO;
import lt.bit.pirkiniai.data.Cekis;
import lt.bit.pirkiniai.data.Preke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("cekis")
public class CekisController {
    
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    @Autowired
    private CekisDAO cekisDAO;
    
    @GetMapping
    public ModelAndView sarasas() {
        ModelAndView mav = new ModelAndView("cekiai");
        mav.addObject("list", cekisDAO.findAll());
        return mav;
    }
    
    @GetMapping("edit")
    public ModelAndView edit(@RequestParam(value = "id", required = false) Integer id) {
        ModelAndView mav;
        if (id == null) {
            mav = new ModelAndView("cekis");
        } else {
            Optional<Cekis> oCekis = cekisDAO.findById(id);
            if (oCekis.isPresent()) {
                mav = new ModelAndView("cekis");
                mav.addObject("value", oCekis.get());
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
            @RequestParam("data") String data,
            @RequestParam("parduotuve") String parduotuve,
            @RequestParam("aprasymas") String aprasymas
    ) {
        if (id == null) {
            Cekis c = new Cekis();
            try {
                c.setData(sdf.parse(data));
            } catch (ParseException ex) {
                c.setData(null);
            }
            c.setParduotuve(parduotuve);
            c.setAprasymas(aprasymas);
            cekisDAO.save(c);
        } else {
            Optional<Cekis> oCekis = cekisDAO.findById(id);
            if (oCekis.isPresent()) {
                Cekis c = oCekis.get();
                try {
                    c.setData(sdf.parse(data));
                } catch (ParseException ex) {
                    c.setData(null);
                }
                c.setParduotuve(parduotuve);
                c.setAprasymas(aprasymas);
                cekisDAO.save(c);
            }
        }
        return sarasas();
    }
    
    @GetMapping("delete")
    @Transactional
    public ModelAndView delete(@RequestParam("id") Integer id) {
        cekisDAO.deleteById(id);
        return sarasas();
    }

    @GetMapping("pagalLaika")
    public String pagalLaika(){
        return "pagalLaika";
    }

    @PostMapping("laikas")
    public ModelAndView laikas(
            @RequestParam("dataNuo") String dataNuo,
            @RequestParam("dataIki") String dataIki
    ) throws ParseException {
        ModelAndView mav = new ModelAndView("cekiai");
        List<Cekis> visiCekiai = cekisDAO.pagalLaika(sdf.parse(dataNuo),sdf.parse(dataIki));
        mav.addObject("list", visiCekiai);

        BigDecimal islaidos = new BigDecimal(0);

        for (Cekis cekis:visiCekiai){

            for (Preke preke:cekis.getPrekes()){
                islaidos= islaidos.add(preke.getKaina().multiply(preke.getKiekis()));
            }

        }
        mav.addObject("suma",islaidos);
        return mav;
    }
}
