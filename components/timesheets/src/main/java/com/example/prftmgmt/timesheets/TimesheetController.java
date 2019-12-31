package com.example.prftmgmt.timesheets;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/timesheets")
public class TimesheetController {

    private TimesheetRepository timesheetRepository;

    public TimesheetController(TimesheetRepository timesheetRepository) {
        this.timesheetRepository = timesheetRepository;
    }

    @PostMapping
    public ResponseEntity<Timesheet> create(@RequestBody Timesheet timesheet) {

        timesheetRepository.save(timesheet);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Timesheet> delete(@PathVariable Long id) {
        Optional<Timesheet> doomed = timesheetRepository.findById(id);
        if (doomed != null) timesheetRepository.delete(doomed.get());
        HttpStatus status = (doomed != null) ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(status);
    }

    @GetMapping("/{id}")
    public List<Timesheet> getId(@PathVariable Long id) {
        Timesheet obj = timesheetRepository.findById(id).get();
        List<Timesheet> lst = new ArrayList<Timesheet>();
        lst.add(obj);
        return lst;
    }

    @GetMapping()
    public List<Timesheet> getAll() {
        List<Timesheet> sortedList = (List<Timesheet>) timesheetRepository.findAll();
        Comparator<Timesheet> compareByStatus = (Timesheet o1, Timesheet o2) -> o1.getPeriod().compareTo(o2.getPeriod());
        Collections.sort(sortedList, compareByStatus);
        return sortedList;
    }

    @GetMapping("/sort_period")
    public List<Timesheet> getAllSortPeriod() {
        List<Timesheet> sortedList = (List<Timesheet>) timesheetRepository.findAll();
        Comparator<Timesheet> compareByPeriod = (Timesheet o1, Timesheet o2) -> o1.getPeriod().compareTo( o2.getPeriod() );
        Collections.sort(sortedList, compareByPeriod);
        return sortedList;
    }


    @GetMapping("/sort_project")
    public List<Timesheet> getAllSortProject() {
        List<Timesheet> sortedList = (List<Timesheet>) timesheetRepository.findAll();
        Comparator<Timesheet> compareByProject = (Timesheet o1, Timesheet o2) -> o1.getProject().compareTo( o2.getProject() );
        Collections.sort(sortedList, compareByProject);
        return sortedList;
    }

    @GetMapping("/sort_status")
    public List<Timesheet> getAllSortStatus() {
        List<Timesheet> sortedList = (List<Timesheet>) timesheetRepository.findAll();
        Comparator<Timesheet> compareByStatus = (Timesheet o1, Timesheet o2) -> o1.getStatus().compareTo( o2.getStatus() );
        Collections.sort(sortedList, compareByStatus);
        return sortedList;
    }


    @GetMapping("/sort_total")
    public List<Timesheet> getAllSortTotal() {
        List<Timesheet> sortedList = (List<Timesheet>) timesheetRepository.findAll();
        Comparator<Timesheet> compareByTotal = (Timesheet o1, Timesheet o2) -> o1.getTotal() - o2.getTotal();
        Collections.sort(sortedList, compareByTotal);
        return sortedList;
    }

}