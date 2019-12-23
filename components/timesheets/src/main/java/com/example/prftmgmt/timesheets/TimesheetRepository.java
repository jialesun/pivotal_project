package com.example.prftmgmt.timesheets;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TimesheetRepository extends CrudRepository<Timesheet, Long> {
    Optional<Timesheet> findById(Long id);
}