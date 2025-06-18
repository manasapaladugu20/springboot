package org.example.springboot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Set<Student> findAllByAddress_City(String city);
    @Query("select s from Student s join s.address a where a.city =?1")
    Set<Student> getCityStudents(String city);

    Student findByEmail(String email);
}

