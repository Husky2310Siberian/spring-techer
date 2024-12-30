package gr.aueb.cf.teacherapp.service;

import gr.aueb.cf.teacherapp.core.exceptions.EntityAlreadyExistsException;
import gr.aueb.cf.teacherapp.core.exceptions.EntityInvalidArgumentException;
import gr.aueb.cf.teacherapp.dto.StudentInsertDTO;
import gr.aueb.cf.teacherapp.dto.StudentReadOnlyDTO;
import gr.aueb.cf.teacherapp.mapper.Mapper;
import gr.aueb.cf.teacherapp.model.Student;
import gr.aueb.cf.teacherapp.model.static_data.Program;
import gr.aueb.cf.teacherapp.repository.ProgramRepository;
import gr.aueb.cf.teacherapp.repository.StudentRepository;
import gr.aueb.cf.teacherapp.repository.TeacherRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService{

    private final StudentRepository studentRepository;
    private final ProgramRepository programRepository;
    private final TeacherRepository teacherRepository;
    private final Mapper mapper;

    @Override
    @Transactional
    public Page<StudentReadOnlyDTO> getPaginatedStudents(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<Student> studentPage = studentRepository.findAll(pageable);

        return studentPage.map(mapper::mapToStudentReadOnlyDTO);
    }


    @Override
    @Transactional(rollbackOn = Exception.class)
    public Student saveStudent(StudentInsertDTO dto) throws EntityAlreadyExistsException,
            EntityInvalidArgumentException {

        if (studentRepository.findByIdentityNumber(dto.getIdentityNumber()).isPresent()){
            throw new EntityAlreadyExistsException("Student" , "Student with identity number"
                    + dto.getIdentityNumber() + "already exists");
        }
        Student student = mapper.mapToStudentEntity(dto);
        Program program = programRepository.findById(dto.getProgramId())
                .orElseThrow(() -> new EntityInvalidArgumentException("Student" , "Invalid Student id"));

        student.setProgram(program);
        return studentRepository.save(student);
    }


}
