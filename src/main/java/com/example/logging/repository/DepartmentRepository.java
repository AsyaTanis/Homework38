package com.example.logging.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.logging.model.DepartmentEntity;

import java.util.List;

@Repository
public interface DepartmentRepository extends CrudRepository<DepartmentEntity,Integer> {
    @Override
    List<DepartmentEntity> findAll();
}
