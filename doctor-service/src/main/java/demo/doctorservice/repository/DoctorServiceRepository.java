package demo.doctorservice.repository;

import demo.doctorservice.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorServiceRepository extends JpaRepository<Doctor,Long> {
}
