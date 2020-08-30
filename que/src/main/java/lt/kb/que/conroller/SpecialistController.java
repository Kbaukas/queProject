package lt.kb.que.conroller;

import lt.kb.que.model.Specialist;
import lt.kb.que.service.SpecialistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class SpecialistController {
    @Autowired
    SpecialistService specialistService;

    @GetMapping("/specialists")
    String showAll(Model model){
        List<Specialist> specialists=specialistService.findAll();
        model.addAttribute("specialists",specialists);
        return "specialists";

    }
    @GetMapping("/specialists/{id}")
    public String getSpecialistById(@PathVariable int id,Model model) throws Exception {
       Specialist specialist=specialistService.findById(id).get();
       model.addAttribute("specialist",specialist);
       return "specialist";
    }
}
