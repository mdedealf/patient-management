package com.mdedealf.patientservice.service;

import com.mdedealf.patientservice.dto.PatientResponseDTO;
import com.mdedealf.patientservice.mapper.PatientMapper;
import com.mdedealf.patientservice.model.Patient;
import com.mdedealf.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {
    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDTO> getPatients() {
        List<Patient> patients = patientRepository.findAll();

        // Normal way
//        List<PatientResponseDTO> patientResponseDTOSDTOs = patients
//                .stream()
//                .map(PatientMapper::toDTO)
//                .toList();
//
//        return patientResponseDTOSDTOs;

        return patients
                .stream()
                .map(PatientMapper::toDTO)
                .toList();
    }
}
