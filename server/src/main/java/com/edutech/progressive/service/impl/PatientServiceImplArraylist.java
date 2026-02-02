package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Patient;
import com.edutech.progressive.service.PatientService;

@Service
public class PatientServiceImplArraylist implements PatientService {
    private static List<Patient> patientList = new ArrayList<>();

    @Override
    public List<Patient> getAllPatients() {
        return patientList;
    }

    @Override
    public Integer addPatient(Patient patient) {
        if(patientList.add(patient))
       return 1;
       else return -1;
    }

    @Override
    public List<Patient> getAllPatientSortedByName() {
        List<Patient> list = new ArrayList<>(patientList);
        Collections.sort(list);
        return list;
    }


    public void emptyArrayList() throws Exception{
        patientList.clear();
    }

}
