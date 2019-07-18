package com.school.cloud.Service;


import com.school.cloud.Modal.School;
import com.school.cloud.Repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolServiceImpl implements SchoolService{

    @Autowired
    SchoolRepository schoolRepository;

    @Override
    public School save(School school) {
        return schoolRepository.save(school);
    }

    @Override
    public List<School> fetchAllSchools() {
        return schoolRepository.findAll();
    }


    @Override
    public School fetchSchool(String Id) {
        Optional<School> optional = schoolRepository.findById(Id);
        School school1 = optional.get();
        return school1;
    }

    @Override
    public List<School> getOnlySchools() {
        return  schoolRepository.find("Thurstan College");
    }

}
