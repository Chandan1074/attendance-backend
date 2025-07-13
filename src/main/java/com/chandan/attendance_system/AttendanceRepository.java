package com.chandan.attendance_system;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    @Query("SELECT a.student.name, COUNT(a), SUM(CASE WHEN a.status = 'Present' THEN 1 ELSE 0 END) " +
           "FROM Attendance a GROUP BY a.student.name")
    List<Object[]> getAttendanceSummary();

}
