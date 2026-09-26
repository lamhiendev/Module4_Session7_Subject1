package demo.appointmentservice.service;

import demo.appointmentservice.dto.AppointmentServiceRequest;
import demo.appointmentservice.entity.Appointment;

public interface AppointmentService {
    Appointment createAppointment(AppointmentServiceRequest request);
}
