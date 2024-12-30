package gr.aueb.cf.teacherapp.service;

import gr.aueb.cf.teacherapp.model.static_data.Program;

import java.util.List;

public interface IProgramService {
    List<Program> findAllPrograms();
}
