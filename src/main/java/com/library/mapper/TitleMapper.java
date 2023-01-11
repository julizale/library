package com.library.mapper;

import com.library.domain.Title;
import com.library.domain.dto.TitleDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TitleMapper {

    public TitleDto mapToTitleDto(Title title) {
        return new TitleDto(
                title.getId(),
                title.getBookTitle(),
                title.getAuthor(),
                title.getYearOfPublishing()
        );
    }

    public Title mapToTitle(TitleDto titleDto) {
        return new Title(
                titleDto.getId(),
                titleDto.getBookTitle(),
                titleDto.getAuthor(),
                titleDto.getYearOfPublishing(),
                new ArrayList<>()
        );
    }

    public List<TitleDto> mapToTitleDtoList(List<Title> titles) {
        return titles.stream()
                .map(this::mapToTitleDto)
                .toList();
    }
}
