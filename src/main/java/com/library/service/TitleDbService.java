package com.library.service;

import com.library.domain.Title;
import com.library.exception.TitleNotFoundException;
import com.library.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TitleDbService {

    @Autowired
    private TitleRepository titleRepository;

    public Title saveTitle(Title title) {
        return titleRepository.save(title);
    }

    public Title getTitle(long titleId) throws TitleNotFoundException {
        return titleRepository.findById(titleId).orElseThrow(TitleNotFoundException::new);
    }

}
