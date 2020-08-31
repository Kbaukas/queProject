package lt.kb.que.conroller;

import lt.kb.que.model.Ticket;
import lt.kb.que.service.TicketService;
import lt.kb.que.util.Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class TicketController {
    @Autowired
    TicketService ticketService;


    @GetMapping("/fragments")
    public String fragment(Model model) {
        int pageSize = 5;

        newList(model, pageSize);


        return "fragments.html";


    }


    @GetMapping("tickets")
    String showAll(Model model) {

        return getPage(1, model);

    }


    @GetMapping("tickets/{pageNo}")
    String getPage(@PathVariable(value = "pageNo") int pageNo, Model model) {
        int pageSize = 5;
        Page<Ticket> page = ticketService.findPage(pageNo, pageSize);

        newList(model, pageSize);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalTickets", page.getTotalElements());

        return "service/tickets";

    }

    private void newList(Model model, int pageSize) {
        List<Ticket> tickets = ticketService.findAll();

        tickets = tickets.stream().sorted((a, b) -> (int) (Generator.timeLeft(a) - Generator.timeLeft(b))).collect(Collectors.toList());
        List<Ticket> newList = new ArrayList<>();
        for (int i = 0; i < pageSize - 1; i++) {
            newList.add(tickets.get(i));
        }
        model.addAttribute("tickets", newList);
    }

    @GetMapping("/tickets/create")
    public String showSignUpForm(Model model) {
        Ticket ticket = new Ticket();
        model.addAttribute("ticket", ticket);
        return "customerPages/create";
    }

    @RequestMapping(value = "/tickets/create", method = RequestMethod.POST)
    public String addTicket(@ModelAttribute("ticket") Ticket ticket, BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println("klaida");
            return "customerPages/create";
        }

        System.out.println(ticket);

        Ticket newTicket = ticketService.addNewTicket(ticket);
        model.addAttribute("ticket", newTicket);
        return "customerPages/ticket";
    }

    @RequestMapping(value = "/tickets/delete", method = RequestMethod.POST)
    public String removeTicket(@RequestParam int id, Model model) {
        Optional<Ticket> ticket = ticketService.findbyId(id);
        if (!ticket.isPresent()) {
            System.out.println("No such a ticket");
            return "redirect:/tickets";
        }
        ticketService.removeTicket(ticket.get());
        String message = "Canceled Successfully";
        model.addAttribute("message", message);
        return "customerPages/index";
    }

    @GetMapping("/ticket/{id}")
    String getById(@PathVariable(value = "id") int id, Model model) {
        Optional<Ticket> ticket = ticketService.findbyId(id);
        System.out.println(ticket);
        if (!ticket.isPresent()) {
            return "error/index";
        }
        model.addAttribute("ticket", ticket.get());
        return "customerPages/ticket";

    }

    @GetMapping("/ticket/find")
    String findTicket(@RequestParam(name = "filter", required = false) String filter, Model model) {
        String message = "Enter serial number";
        if (filter == null) {
            message = "please enter number";
            model.addAttribute("message", message);

            return "customerPages/find";
        } else {

            List<Ticket> tickets = ticketService.findBySerialNr(filter.toLowerCase());
            model.addAttribute("filter", filter);
            if (tickets.isEmpty()) {
                message = "no Ticket found";
                model.addAttribute("message", message);
                return "customerPages/find";
            } else {
                model.addAttribute("ticket", tickets.get(0));
                return "customerPages/ticket";

            }

        }

    }

}
