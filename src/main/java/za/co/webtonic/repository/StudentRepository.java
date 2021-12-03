package za.co.webtonic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import za.co.webtonic.model.Student;

@Repository
public interface StudentRepository  extends JpaRepository<Student, String>{

}
