package com.codegym.demojpa.repositories;

import com.codegym.demojpa.models.TypeOfClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfClassRepository extends JpaRepository<TypeOfClass, Integer> {
}
