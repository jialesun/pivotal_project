
package com.example.prftmgmt.tickets;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TicketRepository extends CrudRepository<Ticket, Long> {

    Optional<Ticket> findById(Long id);

}