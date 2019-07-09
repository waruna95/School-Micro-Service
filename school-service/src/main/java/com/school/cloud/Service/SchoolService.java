package com.school.cloud.Service;


import com.school.cloud.Modal.School;

import java.util.List;

public interface SchoolService {
    School save(School school);
    List<School> fetchAllSchools();
    School fetchSchool(String Id);

}
