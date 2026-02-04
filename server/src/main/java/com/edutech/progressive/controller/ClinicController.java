package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Clinic;
import com.edutech.progressive.service.ClinicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clinic")
public class ClinicController {

    @Autowired
    ClinicService clinicService;


    @GetMapping
    public ResponseEntity<List<Clinic>> getAllClinics() throws Exception {
        return ResponseEntity.ok(clinicService.getAllClinics());
    }

    @GetMapping("/{clinicId}")
    public ResponseEntity<Clinic> getClinicById(@PathVariable int clinicId) throws Exception {
        return ResponseEntity.ok(clinicService.getClinicById(clinicId));
    }

    @PostMapping
    public ResponseEntity<Integer> addClinic(@RequestBody Clinic clinic) throws Exception {
        return new ResponseEntity<>(clinicService.addClinic(clinic),HttpStatus.CREATED);
    }

    @PutMapping("/{clinicId}")
    public ResponseEntity<Void> updateClinic(@PathVariable int clinicId,@RequestBody Clinic clinic) throws Exception {
        clinic.setClinicId(clinicId);
        clinicService.updateClinic(clinic);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{clinicId}")
    public ResponseEntity<Void> deleteClinic(@PathVariable int clinicId) throws Exception {
        clinicService.deleteClinic(clinicId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/location/{location}")
    public ResponseEntity<List<Clinic>> getAllClinicByLocation(@PathVariable String location) throws Exception {
        return ResponseEntity.ok(clinicService.getAllClinicByLocation(location));
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<Clinic>> getAllClinicByDoctorId(@PathVariable int doctorId) throws Exception {
        return ResponseEntity.ok(clinicService.getAllClinicByDoctorId(doctorId));
    }
}
