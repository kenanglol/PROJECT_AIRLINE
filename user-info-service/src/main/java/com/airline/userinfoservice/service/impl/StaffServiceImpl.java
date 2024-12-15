package com.airline.userinfoservice.service.impl;

import com.airline.userinfoservice.entity.Staff;
import com.airline.userinfoservice.repository.StaffRepository;
import com.airline.userinfoservice.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;

    @Override
    public Staff createStaff(Staff staff) {
        if (staffRepository.existsByPassportNo(staff.getPassportNo())) {
            throw new RuntimeException("Staff with this passport number already exists");
        }
        return staffRepository.save(staff);
    }

    @Override
    public Staff getStaffById(Long id) {
        return staffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Staff not found with id: " + id));
    }

    @Override
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    @Override
    public Staff updateStaff(Long id, Staff staff) {
        Staff existingStaff = getStaffById(id);
        
        if (!existingStaff.getPassportNo().equals(staff.getPassportNo()) && 
            staffRepository.existsByPassportNo(staff.getPassportNo())) {
            throw new RuntimeException("Staff with this passport number already exists");
        }

        staff.setStaffId(id);
        return staffRepository.save(staff);
    }

    @Override
    public void deleteStaff(Long id) {
        if (!staffRepository.existsById(id)) {
            throw new RuntimeException("Staff not found with id: " + id);
        }
        staffRepository.deleteById(id);
    }
} 