package com.chandan.attendance_system;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    private final AttendanceRepository repo;

    public AttendanceController(AttendanceRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Attendance> getAllAttendance() {
        return repo.findAll();
    }

    @PostMapping
    public Attendance addAttendance(@RequestBody Attendance attendance) {
        return repo.save(attendance);
    }

    @DeleteMapping("/{id}")
    public void deleteAttendance(@PathVariable Long id) {
        repo.deleteById(id);
    }
    
    @PutMapping("/{id}")
    public Attendance updateAttendance(@PathVariable Long id, @RequestBody Attendance updated) {
        Attendance attendance = repo.findById(id)
            .orElseThrow(() -> new RuntimeException("Attendance record not found with id: " + id));

        attendance.setStatus(updated.getStatus());
        return repo.save(attendance);
    }
    
    @GetMapping("/summary")
    public List<Object[]> getAttendanceSummary() {
        return repo.getAttendanceSummary();
    }
    
    @DeleteMapping("/clear")
    public String clearAllAttendance() {
        repo.deleteAll();
        return "All attendance records cleared.";
    }




}

