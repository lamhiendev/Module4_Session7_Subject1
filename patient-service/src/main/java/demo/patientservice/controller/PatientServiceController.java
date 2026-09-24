package demo.patientservice.controller;

import demo.patientservice.dto.PatientRequestDTO;
import demo.patientservice.dto.PatientResponseDTO;
import demo.patientservice.entity.Patient;
import demo.patientservice.service.impl.PatientServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/patients")
public class PatientServiceController {
    private final PatientServiceImpl patientService;
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
