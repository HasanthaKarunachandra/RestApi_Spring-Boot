package com.shototech.healthcare.system.service;

import com.shototech.healthcare.system.dto.request.RequestDoctorDto;
import com.shototech.healthcare.system.dto.response.ResponseDoctorDto;
import com.shototech.healthcare.system.dto.response.paginated.PaginatedDoctorResponseDto;

import java.util.List;

public interface DoctorService {
    public void createDoctor(RequestDoctorDto dto);
    public ResponseDoctorDto getDoctor(long id);
    public void deleteDoctor(long id);
    public List<ResponseDoctorDto> findDoctorsByName(String name);
    public void updateDoctor(long id,RequestDoctorDto dto);
    public PaginatedDoctorResponseDto getAllDoctors(String searchText, int page, int size);
}
