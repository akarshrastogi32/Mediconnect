package com.edutech.progressive.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutech.progressive.entity.Clinic;
import com.edutech.progressive.repository.ClinicRepository;
import com.edutech.progressive.service.ClinicService;

@Service
public class ClinicServiceImplJpa implements ClinicService {

    private final ClinicRepository clinicRepository;

    public ClinicServiceImplJpa(ClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }

    @Override
    public List<Clinic> getAllClinics() throws Exception {
        return clinicRepository.findAll();
    }

    @Override
    public Clinic getClinicById(int clinicId) throws Exception {
        return clinicRepository.findById(clinicId).orElse(null);
    }

    @Override
    public Integer addClinic(Clinic clinic) throws Exception {
        Clinic c = clinicRepository.save(clinic);
        return c.getClinicId();
    }

    @Override
    public void updateClinic(Clinic clinic) throws Exception {
        clinicRepository.save(clinic);
    }

    @Override
    public void deleteClinic(int clinicId) throws Exception {
        clinicRepository.deleteById(clinicId);
    }

       public List<Clinic> getAllClinicByLocation(String location) throws Exception { 
        return clinicRepository.findAllByLocation(location);
        }

    public List<Clinic> getAllClinicByDoctorId(int doctorId) throws Exception { 
        return clinicRepository.findAllByDoctorId(doctorId);

     }
}
