package lt.kb.que.conroller;

import lt.kb.que.model.Ticket;
import lt.kb.que.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class TicketController {
    @Autowired
    TicketService ticketService;

    @GetMapping("tickets")
    String showAll(Model model) {
        List<Ticket> tickets = new ArrayList<>();
        tickets = ticketService.findAll();
        model.addAttribute("tickets", tickets);
        return "index";

    }

    @GetMapping("/tickets/create")
    public String showSignUpForm(Model model) {
      Ticket ticket=new Ticket();
        model.addAttribute("ticket", ticket);
        return "createNewticket";
    }
    @RequestMapping(value = "/tickets/create", method= RequestMethod.POST)
    public String addTicket(@ModelAttribute("ticket") Ticket ticket, BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println("klaida");
            return "createNewticket";
        }

        System.out.println(ticket);
        ticketService.addNewTicket(ticket);
        return "redirect:/tickets";
    }

}
