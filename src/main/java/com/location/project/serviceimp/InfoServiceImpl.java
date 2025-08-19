package com.location.project.serviceimp;


import com.location.project.entity.Info;
import com.location.project.repository.InfoRepository;
import com.location.project.service.InfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoServiceImpl implements InfoService {

    @Autowired
    private InfoRepository infoRepository;

    @Override
    public void saveInfo(Info info) {
        // Perform any necessary validation or business logic
        infoRepository.save(info);
    }
}
