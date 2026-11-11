
package br.com.nrsnorte.suporte.controller;

import br.com.nrsnorte.suporte.model.Ticket;
import br.com.nrsnorte.suporte.repository.TicketRepository;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
public class WebController {

    private static final Set<String> CATEGORIES =
            Set.of("Hardware", "Software", "Rede", "Impressora");

    private static final Set<String> PRIORITIES =
            Set.of("Baixa", "Média", "Alta");

    private final TicketRepository repository;

    public WebController(TicketRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/tickets";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/tickets")
    public String list(Model model) {
        model.addAttribute("tickets",
                repository.findAllByOrderByCreatedAtDesc());
        return "tickets";
    }

    @GetMapping("/tickets/new")
    public String newTicket(Model model) {
        model.addAttribute("ticket", new Ticket());
        return "ticket-form";
    }

    @PostMapping("/tickets")
    public String create(
            @Valid @ModelAttribute("ticket") Ticket ticket,
            BindingResult result,
            Authentication authentication) {

        if (ticket.getCategory() == null
                || !CATEGORIES.contains(ticket.getCategory())) {
            result.rejectValue(
                    "category",
                    "ticket.category.invalid",
                    "Selecione uma categoria válida."
            );
        }

        if (ticket.getPriority() == null
                || !PRIORITIES.contains(ticket.getPriority())) {
            result.rejectValue(
                    "priority",
                    "ticket.priority.invalid",
                    "Selecione uma prioridade válida."
            );
        }

        if (result.hasErrors()) {
            return "ticket-form";
        }

        ticket.setRequester(authentication.getName());
        ticket.setStatus("Aberto");

        repository.save(ticket);

        return "redirect:/tickets?created";
    }

    @GetMapping("/tickets/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Ticket ticket = repository.findById(id).orElseThrow();
        model.addAttribute("ticket", ticket);
        return "ticket-detail";
    }
}
