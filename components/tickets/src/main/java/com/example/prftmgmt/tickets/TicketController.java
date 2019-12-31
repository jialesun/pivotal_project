package com.example.prftmgmt.tickets;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private TicketRepository ticketRepository;

    public TicketController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @PostMapping
    public ResponseEntity<Ticket> create(@RequestBody Ticket ticket) {

        ticketRepository.save(ticket);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Ticket> delete(@PathVariable Long id) {
        Optional<Ticket> doomed = ticketRepository.findById(id);
        if (doomed != null) ticketRepository.delete(doomed.get());
        HttpStatus status = (doomed != null) ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(status);
    }

    @GetMapping()
    public List<Ticket> getAll(){
        return (List<Ticket>) ticketRepository.findAll();
    }

    @GetMapping("/{id}")
    public List<Ticket> getId(@PathVariable Long id) {
        Ticket obj = ticketRepository.findById(id).get();
        List<Ticket> lst = new ArrayList<Ticket>();
        lst.add(obj);
        return lst;
    }

    @GetMapping("/sort_status")
    public List<Ticket> getAllSortStatus() {
        List<Ticket> sortedList = (List<Ticket>) ticketRepository.findAll();
        Comparator<Ticket> compareByStatus = (Ticket o1, Ticket o2) -> o1.getStatus().compareTo( o2.getStatus() );
        Collections.sort(sortedList, compareByStatus);
        return sortedList;
    }


    @GetMapping("/sort_name")
    public List<Ticket> getAllSortName() {
        List<Ticket> sortedList = (List<Ticket>) ticketRepository.findAll();
        Comparator<Ticket> compareByName = (Ticket o1, Ticket o2) -> o1.getName().compareTo( o2.getName() );
        Collections.sort(sortedList, compareByName);
        return sortedList;
    }

    @GetMapping("/sort_lead")
    public List<Ticket> getAllSortLead() {
        List<Ticket> sortedList = (List<Ticket>) ticketRepository.findAll();
        Comparator<Ticket> compareByLead = (Ticket o1, Ticket o2) -> o1.getTeamLead().compareTo( o2.getTeamLead() );
        Collections.sort(sortedList, compareByLead);
        return sortedList;
    }

    @GetMapping("/sort_id")
    public List<Ticket> getAllSortId() {
        List<Ticket> sortedList = (List<Ticket>) ticketRepository.findAll();
        Comparator<Ticket> compareById = (Ticket o1, Ticket o2) -> o1.getId().compareTo( o2.getId() );
        Collections.sort(sortedList, compareById);
        return sortedList;
    }

}