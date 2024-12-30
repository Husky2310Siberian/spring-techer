package gr.aueb.cf.teacherapp.controller;

import gr.aueb.cf.teacherapp.core.exceptions.EntityAlreadyExistsException;
import gr.aueb.cf.teacherapp.core.exceptions.EntityInvalidArgumentException;
import gr.aueb.cf.teacherapp.dto.StudentInsertDTO;
import gr.aueb.cf.teacherapp.dto.StudentReadOnlyDTO;
import gr.aueb.cf.teacherapp.mapper.Mapper;
import gr.aueb.cf.teacherapp.model.Student;
import gr.aueb.cf.teacherapp.repository.StudentRepository;
import gr.aueb.cf.teacherapp.service.ProgramService;
import gr.aueb.cf.teacherapp.service.StudentService;
import gr.aueb.cf.teacherapp.service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/school")
@RequiredArgsConstructor
public class StudentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
    private final StudentService studentService;
    private final ProgramService programService;
    private final TeacherService teacherService;
    private final Mapper mapper;
    private final StudentRepository studentRepository;

    @GetMapping("/students")
    public String getPaginatedStudents(@RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "1") int size,
                                        Model model){

        Page<StudentReadOnlyDTO> studentsPage = studentService.getPaginatedStudents(page, size);
        model.addAttribute("studentPage", studentsPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", studentsPage.getTotalPages());

        return "students"; // return Thymleaf view(students.html)

    }

    @GetMapping("/students/insert")
    public String getStudentForm(Model model){
        model.addAttribute("studentInsertDTO", new StudentInsertDTO());
        model.addAttribute("programs", programService.findAllPrograms());

        return "student-form";
    }

    @PostMapping("/students/insert")
    public String saveStudent(@Valid @ModelAttribute("studentInsertDTO") StudentInsertDTO studentInsertDTO,
                              BindingResult bindingResult, Model model){

        Student savedStudent;
        if (bindingResult.hasErrors()){
            return "student-form";
        }

        try {
            savedStudent = studentService.saveStudent(studentInsertDTO);
            LOGGER.info("Student with id {} inserted" , savedStudent.getId());
        } catch (EntityAlreadyExistsException | EntityInvalidArgumentException e){
            LOGGER.error("Student with id {} not inserted", studentInsertDTO.getIdentityNumber());
            model.addAttribute("errorMessage", e.getMessage());
            return "student-form";
        }

        StudentReadOnlyDTO studentReadOnlyDTO = mapper.mapToStudentReadOnlyDTO(savedStudent);
        model.addAttribute("student", savedStudent);
        return "success";
    }
}
