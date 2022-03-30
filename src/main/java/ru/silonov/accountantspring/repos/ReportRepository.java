package ru.silonov.accountantspring.repos;

import org.springframework.data.repository.CrudRepository;
import ru.silonov.accountantspring.model.Report;

import java.util.List;

public interface ReportRepository extends CrudRepository<Report, Long> {

    public List<Report> findAllByDate(String date);

}
