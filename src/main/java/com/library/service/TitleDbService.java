package com.library.service;

import com.library.domain.Member;
import com.library.domain.Title;
import com.library.repository.TitleRepository;
import org.springframework.stereotype.Service;

@Service
public class TitleDbService {

    private TitleRepository titleRepository;

    public Title saveTitle(Title title) {
        return titleRepository.save(title);
    }

}
