package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Patient;
import com.edutech.progressive.exception.PatientNotFoundException;
import com.edutech.progressive.service.PatientService;
import com.edutech.progressive.service.impl.PatientServiceImplArraylist;
import com.edutech.progressive.service.impl.PatientServiceImplJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    @Qualifier("patientServiceImplJpa")
    PatientService patientService;

    @Autowired
    PatientServiceImplArraylist patientServiceImplArraylist;
    
   

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(patientService.getAllPatients());
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<Patient> getPatientById(@PathVariable int patientId) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(patientService.getPatientById(patientId));

    }

    @PostMapping
    public ResponseEntity<Integer> addPatient(@RequestBody Patient patient) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(patientService.addPatient(patient));

    }

    @PutMapping("/{patientId}")
    public ResponseEntity<Void> updatePatient(@PathVariable int patientId,@RequestBody Patient patient)  {
       
       try {
          patient.setPatientId(patientId);
        patientService.updatePatient(patient);
        return new ResponseEntity<>(HttpStatus.OK);
       } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }
      

    }

    @DeleteMapping("/{patientId}")
    public ResponseEntity<Void> deletePatient(@PathVariable int patientId) {
        try {
             patientService.deletePatient(patientId);
          return ResponseEntity.noContent().build();
        } 
        catch(PatientNotFoundException pn){
 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
       
    }

    @GetMapping("/fromArrayList")
    public ResponseEntity<List<Patient>> getAllPatientFromArrayList() throws Exception {
       return ResponseEntity.status(HttpStatus.OK).body(patientServiceImplArraylist.getAllPatients());
    }

    @PostMapping("/toArrayList")
    public ResponseEntity<Void> addPatientToArrayList() {
         return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @GetMapping("/fromArrayList/sorted")
    public ResponseEntity<List<Patient>> getAllPatientSortedByNameFromArrayList() throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(patientServiceImplArraylist.getAllPatientSortedByName());
  
    }
}
