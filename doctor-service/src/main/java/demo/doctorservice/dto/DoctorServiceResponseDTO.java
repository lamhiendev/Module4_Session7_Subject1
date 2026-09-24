package demo.doctorservice.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DoctorServiceResponseDTO {
    private String name;

    private String specialization;

    private Integer experienceYears;

    private String email;

    private Boolean status;
}
