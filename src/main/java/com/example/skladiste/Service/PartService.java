package com.example.skladiste.Service;


import com.example.skladiste.Repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartService {

    @Autowired
    PartRepository partRepository;
    public void deletePart(Long id)
    {
        partRepository.deleteById(id);
    }
}
