package gr.aueb.cf.teacherapp.model.static_data;

import gr.aueb.cf.teacherapp.model.Student;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "programs")
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Getter(AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "program")
    private Set<Student> students = new HashSet<>();

    public Set<Student> getAllStudents (){
        if (students == null) students=new HashSet<>();
        return Collections.unmodifiableSet(students);
    }

    public void addStudent (Student student){
        if (students== null) students = new HashSet<>();
        students.add(student);
        student.setProgram(this);
    }
}
