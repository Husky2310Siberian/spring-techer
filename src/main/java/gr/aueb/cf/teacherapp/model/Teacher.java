package gr.aueb.cf.teacherapp.model;

import gr.aueb.cf.teacherapp.model.static_data.Region;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "teachers")
public class Teacher extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String uuid;

    @Column(unique = true)
    private String vat;

    private String firstname;

    private String lastname;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @Getter(AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "teacher")
    private Set<Student> students = new HashSet<>();

    public Set<Student> getAllStudents(){
        if (students == null)  students= new HashSet<>();
        return Collections.unmodifiableSet(students);
    }

    public void addStudent(Student student){
        if (student == null) students = new HashSet<>();
        students.add(student);
        student.setTeacher(this);
    }

    @PrePersist
    public void initializeUUID(){
        if (uuid==null){
            uuid = UUID.randomUUID().toString();
        }
    }
}