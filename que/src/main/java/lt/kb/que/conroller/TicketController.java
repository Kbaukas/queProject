package lt.kb.que.conroller;

import lt.kb.que.model.Ticket;
import lt.kb.que.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class TicketController {
    @Autowired
    TicketService ticketService;


    @GetMapping("/fragments")
    public String fragment(Model model) {
        Page<Ticket> page=ticketService.findPage(1,5);
        List<Ticket> tickets = new ArrayList<>();
        tickets = page.getContent().stream().sorted(Comparator.comparingInt(Ticket::getId)).collect(Collectors.toList());

        model.addAttribute("tickets",tickets);


        return "fragments.html" ;


    }


//
//    @GetMapping("fragments")
//    public String fragment(@PathVariable (value = "pageNo") int pageNo, Model model) {
//        int pageSize=5;
//        Page<Ticket> page=ticketService.findPage(1,pageSize);
//        List<Ticket> tickets;
//        tickets = page.getContent().stream().sorted((a,b)->a.getId()-b.getId()).collect(Collectors.toList());
//
//        model.addAttribute("tickets", tickets);
//        model.addAttribute("currentPage", pageNo);
//        model.addAttribute("totalPages", page.getTotalPages());
//        model.addAttribute("totalTickets", page.getTotalElements());
//        return "fragments.html" ;
//
//
//    }







    @GetMapping("tickets")
    String showAll(Model model) {

        return getPage(1,model);

    }


    @GetMapping("tickets/{pageNo}")
    String getPage(@PathVariable (value = "pageNo") int pageNo, Model model) {
        int pageSize=5;
        Page<Ticket> page=ticketService.findPage(pageNo,pageSize);
        List<Ticket> tickets = new ArrayList<>();
        tickets = page.getContent().stream().sorted((a,b)->a.getId()-b.getId()).collect(Collectors.toList());

        model.addAttribute("tickets", tickets);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalTickets", page.getTotalElements());

        return "customerPages/index";

    }

    @GetMapping("/tickets/create")
    public String showSignUpForm(Model model) {
      Ticket ticket=new Ticket();
        model.addAttribute("ticket", ticket);
        return "customerPages/create";
    }
    @RequestMapping(value = "/tickets/create", method= RequestMethod.POST)
    public String addTicket(@ModelAttribute("ticket") Ticket ticket, BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println("klaida");
            return "customerPages/create";
        }

        System.out.println(ticket);

        ticketService.addNewTicket(ticket);
        return "redirect:/tickets";
    }

}