package com.airline.userinfoservice.service;

import com.airline.userinfoservice.entity.Staff;
import java.util.List;

public interface StaffService {
    Staff createStaff(Staff staff);
    Staff getStaffById(Long id);
    List<Staff> getAllStaff();
    Staff updateStaff(Long id, Staff staff);
    void deleteStaff(Long id);
} 