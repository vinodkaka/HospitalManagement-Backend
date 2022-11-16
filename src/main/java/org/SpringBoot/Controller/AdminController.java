package org.SpringBoot.Controller;

import org.SpringBoot.Model.Appointment;
import org.SpringBoot.Model.Doctor;
import org.SpringBoot.Service.AdminService;
import org.SpringBoot.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController("/Admin")
public class AdminController {

@Autowired
AdminService adminservice;

@Autowired
AppointmentService appointmentservice;


@RequestMapping(value="/addDoctor",method=RequestMethod.POST)
public void addDoctor(@RequestBody Doctor doctor)
{
	adminservice.addDoctor(doctor);
}


@RequestMapping(value="/addappointment",method=RequestMethod.POST)
public void addappointment(@RequestBody Appointment appointment) {
	appointmentservice.addAppointment(appointment);
}
//@RequestMapping(value="/addDoctor",method=RequestMethod.POST)
//public void addDoctor(@RequestBody Doctor doctor)
//{
//	adminservice.addDoctor(doctor);
//}

}
