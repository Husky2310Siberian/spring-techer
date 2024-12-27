package gr.aueb.cf.teacherapp.service;

import gr.aueb.cf.teacherapp.model.static_data.Region;
import gr.aueb.cf.teacherapp.repository.RegionRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionService implements IRegionService{

    private final RegionRepository regionRepository;


    @Override
    public List<Region> findAllRegions() {
        return regionRepository.findAll();
    }
}
