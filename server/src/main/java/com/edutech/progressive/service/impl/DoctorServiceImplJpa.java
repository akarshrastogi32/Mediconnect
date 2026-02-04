
package com.edutech.progressive.service.impl;

import java.util.Collections;
import java.util.List;

import javax.print.Doc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Doctor;
import com.edutech.progressive.repository.DoctorRepository;
import com.edutech.progressive.service.DoctorService;

@Service
public class DoctorServiceImplJpa implements DoctorService {

   private final DoctorRepository doctorRepository;

    public DoctorServiceImplJpa(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<Doctor> getAllDoctors() throws Exception {

        return doctorRepository.findAll();
    }

    @Override
    public Integer addDoctor(Doctor doctor) throws Exception {
       Doctor d=doctorRepository.save(doctor);
        return d.getDoctorId();
    }

    @Override
    public List<Doctor> getDoctorSortedByExperience() throws Exception {

        List<Doctor> list = doctorRepository.findAll();

        Collections.sort(list);

        return list;

    }

    public void updateDoctor(Doctor doctor) throws Exception {
        doctorRepository.save(doctor);

    }

    public void deleteDoctor(int doctorId) throws Exception {
        
        doctorRepository.deleteById(doctorId);
    }

    public Doctor getDoctorById(int doctorId) throws Exception {
        return doctorRepository.findByDoctorId(doctorId).get();

    }

}
