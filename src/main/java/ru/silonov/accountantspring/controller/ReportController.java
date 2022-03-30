package ru.silonov.accountantspring.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.silonov.accountantspring.model.Report;
import ru.silonov.accountantspring.model.ReportDto;
import ru.silonov.accountantspring.repos.ReportRepository;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    private static final Logger logger = LogManager.getLogger(ReportController.class);

    @Autowired
    private ReportRepository reportRepository;

    @GetMapping("/today")
    public List<Report> selectToday() {
    List<Report> list = reportRepository.findAllByDate(format.format(new Date(System.currentTimeMillis())));
    return list;
    }


    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Report postReport(@RequestBody ReportDto report){
        Report entity =
                new Report( report.getTime(), report.getTask(), report.getUserId());
        logger.info(entity);
        reportRepository.save(entity);
        return entity;
    }
}
