package com.example.logging.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.logging.model.ReportEntity;

@Repository
public interface ReportRepository extends CrudRepository<ReportEntity, Integer> {
    @Query("SELECT r.filePath FROM ReportEntity r WHERE r.id =:id")
    ReportEntity readReportById(int id);
}
