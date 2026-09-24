package demo.patientservice.service.impl;

import demo.patientservice.dto.PatientRequestDTO;
import demo.patientservice.entity.Patient;
import demo.patientservice.repository.PatientServiceRepository;
import demo.patientservice.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientServiceRepository patientServiceRepository;
    @Override
    public Patient createNewPatient(PatientRequestDTO requestDTO) {
        Patient newPatient = Patient.builder()
                .fullName(requestDTO.getFullName())
                .dateOfBirth(requestDTO.getDateOfBirth())
                .gender(requestDTO.getGender())
                .phoneNumber(requestDTO.getPhoneNumber())
                .address(requestDTO.getAddress())
                .medicalHistory(requestDTO.getMedicalHistory())
                .build();
        return patientServiceRepository.save(newPatient);
    }
}
