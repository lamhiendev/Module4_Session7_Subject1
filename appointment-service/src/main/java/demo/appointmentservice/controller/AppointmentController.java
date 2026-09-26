package demo.appointmentservice.controller;

import demo.appointmentservice.dto.AppointmentServiceRequest;
import demo.appointmentservice.service.impl.AppointmentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/appointments")
public class AppointmentController {
    private final AppointmentServiceImpl appointmentService;
    @PostMapping
    public ResponseEntity<String> createAppointment(@RequestBody AppointmentServiceRequest request){
        appointmentService.createAppointment(request);
        return ResponseEntity.ok().body("Tạo lịch thành công");
    }
}
