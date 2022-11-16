package org.SpringBoot.Controller;

import java.util.List;

import org.SpringBoot.Model.Appointment;
import org.SpringBoot.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController("/Appointment")
public class AppointmentController {
	
	@Autowired
	AppointmentService appointmentService;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public void addUserInfo(@RequestBody Appointment appointment)
	{
		appointmentService.addAppointment(appointment);
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public void deleteAppointment(@RequestBody Appointment appointment)
	{
		appointmentService.cancelAppointment(appointment);
	}

	@RequestMapping("/fetch")
	public List<Appointment> getAllUsers()
	{
		List<Appointment> appointment=appointmentService.fetchAllAppointments();
		return appointment;
	}
}
