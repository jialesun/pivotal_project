package com.example.prftmgmt.timesheets;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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

    @GetMapping()
    public List<Timesheet> getAll() {
        List<Timesheet> sortedList = (List<Timesheet>) timesheetRepository.findAll();
        Comparator<Timesheet> compareByStatus = (Timesheet o1, Timesheet o2) -> o1.getPeriod().compareTo(o2.getPeriod());
        Collections.sort(sortedList, compareByStatus);
        return sortedList;
    }

}