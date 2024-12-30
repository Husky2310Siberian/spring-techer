package gr.aueb.cf.teacherapp.service;

import gr.aueb.cf.teacherapp.core.exceptions.EntityAlreadyExistsException;
import gr.aueb.cf.teacherapp.core.exceptions.EntityInvalidArgumentException;
import gr.aueb.cf.teacherapp.dto.StudentInsertDTO;
import gr.aueb.cf.teacherapp.dto.StudentReadOnlyDTO;
import gr.aueb.cf.teacherapp.dto.TeacherReadOnlyDTO;
import gr.aueb.cf.teacherapp.model.Student;
import org.springframework.data.domain.Page;

public interface IStudentService {
    Student saveStudent(StudentInsertDTO dto) throws EntityAlreadyExistsException, EntityInvalidArgumentException;
    public Page<StudentReadOnlyDTO> getPaginatedStudents(int page , int size);
}