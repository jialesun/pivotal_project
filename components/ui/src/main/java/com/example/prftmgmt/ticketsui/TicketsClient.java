package com.example.prftmgmt.ticketsui;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestOperations;

import java.util.ArrayList;
import java.util.List;

public class TicketsClient {
    private static ParameterizedTypeReference<List<TicketUI>> ticketListType = new ParameterizedTypeReference<List<TicketUI>>() {
    };
    private String ticketURL;
    private RestOperations restOperations;
    private static final int CACHE_SIZE = 5;
    private final List<TicketUI> lastRead = new ArrayList<>(CACHE_SIZE);
    private static final Logger log = LoggerFactory.getLogger(TicketsClient.class);

    public TicketsClient(String ticketURL, RestOperations restOperations) {
        this.ticketURL = ticketURL;
        this.restOperations = restOperations;
    }

    public void create(TicketUI ticket) {
        restOperations.postForEntity(ticketURL, ticket, TicketUI.class);
    }

    public void delete(long id) {
        restOperations.delete(ticketURL + "/" + id);
    }

    public List<TicketUI> display(long id) {
       List<TicketUI> lst = restOperations.exchange(ticketURL + "/" + id, HttpMethod.GET, null, ticketListType).getBody();
       return lst;
    }

    @HystrixCommand(fallbackMethod="getAllFallback",commandProperties = {
            @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")
    })
    public List<TicketUI> getAll() {
        List<TicketUI> read = restOperations.exchange(ticketURL, HttpMethod.GET, null, ticketListType).getBody();
        log.debug("Read {} tickets from {}", read.size(), ticketURL);

        lastRead.clear();
        int copyCount = (read.size() < CACHE_SIZE) ? read.size() : CACHE_SIZE;
        for (int i =0; i < copyCount; i++)
            lastRead.add(read.get(i));
        log.debug("Copied {} tickets into the cache", copyCount);

        return read;
    }

    public List<TicketUI> getAllFallback() {
        log.debug("Returning {} tickets from the fallback method", lastRead.size());

        return lastRead;
    }

    public List<TicketUI> getAllSortStatus() {
        List<TicketUI> read = restOperations.exchange(ticketURL + "/sort_status", HttpMethod.GET, null, ticketListType).getBody();
        return read;
    }

    public List<TicketUI> getAllSortName() {
        List<TicketUI> read = restOperations.exchange(ticketURL + "/sort_name", HttpMethod.GET, null, ticketListType).getBody();
        return read;
    }

    public List<TicketUI> getAllSortLead() {
        List<TicketUI> read = restOperations.exchange(ticketURL + "/sort_lead", HttpMethod.GET, null, ticketListType).getBody();
        return read;
    }

    public List<TicketUI> getAllSort(String sort) {
        List<TicketUI> read = restOperations.exchange(ticketURL + "/sort_" + sort, HttpMethod.GET, null, ticketListType).getBody();
        return read;
    }




}