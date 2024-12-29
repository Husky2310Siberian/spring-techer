package gr.aueb.cf.teacherapp.model;

import gr.aueb.cf.teacherapp.model.static_data.Program;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "students")
public class Student extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String uuid;

    @Column(unique = true)
    private String identityNumber;

    private String firstname;

    private String lastname;

    @ManyToOne
    @JoinColumn(name = "program_id")
    private Program program;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @PrePersist
    public void initializeUUID(){
        if (uuid == null) {
            uuid = UUID.randomUUID().toString();
        }
    }
}