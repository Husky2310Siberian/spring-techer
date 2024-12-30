package gr.aueb.cf.teacherapp.mapper;

import gr.aueb.cf.teacherapp.core.enums.Role;
import gr.aueb.cf.teacherapp.dto.*;
import gr.aueb.cf.teacherapp.model.Student;
import gr.aueb.cf.teacherapp.model.Teacher;
import gr.aueb.cf.teacherapp.model.User;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public Teacher mapToTeacherEntity(TeacherInsertDTO teacherInsertDTO) {
        Teacher teacher = new Teacher();
        teacher.setFirstname(teacherInsertDTO.getFirstname());
        teacher.setLastname(teacherInsertDTO.getLastname());
        teacher.setVat(teacherInsertDTO.getVat());
        return teacher;
    }

    public TeacherReadOnlyDTO mapToTeacherReadOnlyDTO(Teacher teacher) {
        return new TeacherReadOnlyDTO(teacher.getId(), teacher.getCreatedAt(),
                teacher.getUpdatedAt(), teacher.getUuid(), teacher.getFirstname(),
                teacher.getLastname(),teacher.getVat(), teacher.getRegion().getName());
    }

    public Student mapToStudentEntity(StudentInsertDTO studentInsertDTO){
        Student student = new Student();
        student.setFirstname(studentInsertDTO.getFirstname());
        student.setLastname(studentInsertDTO.getLastname());
        student.setIdentityNumber(studentInsertDTO.getIdentityNumber());
        return student;
    }

    public StudentReadOnlyDTO mapToStudentReadOnlyDTO(Student student){
        return new StudentReadOnlyDTO(student.getId(), student.getCreatedAt(), student.getUpdatedAt(),
                student.getUuid(), student.getIdentityNumber(), student.getFirstname(),
                student.getLastname(), student.getTeacher().getLastname(), student.getProgram().getName());
    }

    public User mapToUserEntity(UserInsertDTO userInsertDTO) {
        return new User(null, userInsertDTO.getUsername(),
                userInsertDTO.getPassword(), Role.valueOf(userInsertDTO.getRole().toUpperCase()));
    }
}
