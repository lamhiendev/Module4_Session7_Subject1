package demo.patientservice.controller;

import demo.patientservice.dto.PatientRequestDTO;
import demo.patientservice.dto.PatientResponseDTO;
import demo.patientservice.entity.Patient;
import demo.patientservice.repository.PatientServiceRepository;
import demo.patientservice.service.impl.PatientServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/patients")
public class PatientServiceController {
    private final PatientServiceImpl patientService;
    private final PatientServiceRepository patientServiceRepository;
    @GetMapping("/{id}")
    public ResponseEntity<PatientResponseDTO> getPatientById(@PathVariable Long id){
        Patient patient = patientServiceRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tồn tại"));
        return new ResponseEntity<>(new PatientResponseDTO(
                patient.getFullName(),
                patient.getDateOfBirth(),
                patient.getGender(),
                patient.getPhoneNumber(),
                patient.getAddress(),
                patient.getMedicalHistory()
        ),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<PatientResponseDTO> createNewPatient(@RequestBody PatientRequestDTO requestDTO){
        Patient newPatient = patientService.createNewPatient(requestDTO);
        return new ResponseEntity<>(new PatientResponseDTO(
                newPatient.getFullName(),
                newPatient.getDateOfBirth(),
                newPatient.getGender(),
                newPatient.getPhoneNumber(),
                newPatient.getAddress(),
                newPatient.getMedicalHistory()
        ), HttpStatus.CREATED);
    }
}
