package lt.kb.que.conroller;

import lt.kb.que.model.Specialist;
import lt.kb.que.model.Ticket;
import lt.kb.que.service.SpecialistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class SpecialistController {
    @Autowired
    SpecialistService specialistService;

    @GetMapping("/specialists")
    String showAll(Model model) {
        List<Specialist> specialists = specialistService.findAll();
        model.addAttribute("specialists", specialists);
        return "service/specialists";

    }

    @GetMapping("/specialists/{id}")
    public String getSpecialistById(@PathVariable int id, Model model) {
        System.out.println("-----------------------------------------------------");
        System.out.println(SecurityContextHolder.getContext().getAuthentication());
        Optional<Specialist> specialist = specialistService.findById(id);
        if (!specialist.isPresent()) {
            return "error/index";
        }
        specialist.ifPresent(value -> model.addAttribute("specialist", value));
        return "service/specialist";
    }


    @GetMapping("/specialists/create")
    public String createSpecialistForm(Model model) {

        Specialist specialist = new Specialist();
        model.addAttribute("specialist", specialist);
        return "service/createSpecialist";
    }

    @RequestMapping(value = "/specialists/create", method = RequestMethod.POST)
    public String addTicket(@ModelAttribute("specialist") Specialist specialist, BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println("klaida");
            return "service/createSpecialist";
        }

        System.out.println(specialist);

        specialistService.addNewSpecialis(specialist);
        return "redirect:/specialists";
    }

}
