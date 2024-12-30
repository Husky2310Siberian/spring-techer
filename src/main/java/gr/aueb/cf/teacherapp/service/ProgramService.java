package gr.aueb.cf.teacherapp.service;

import gr.aueb.cf.teacherapp.model.static_data.Program;
import gr.aueb.cf.teacherapp.repository.ProgramRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProgramService implements IProgramService{

    private final ProgramRepository programRepository;
    @Override
    public List<Program> findAllPrograms() {
        return programRepository.findAll();
    }
}
