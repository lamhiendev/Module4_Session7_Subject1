package demo.patientservice.service;

import demo.patientservice.dto.PatientRequestDTO;
import demo.patientservice.entity.Patient;

public interface PatientService {
    Patient createNewPatient(PatientRequestDTO requestDTO);
}
