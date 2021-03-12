package com.pdh.web.Service;
import com.pdh.web.Dto.BoardDto;
import com.pdh.web.config.SpecsConfig;
import com.pdh.web.entity.BoardEntity;
import com.pdh.web.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@AllArgsConstructor
public class BoardService {

    private BoardRepository boardRepository;

    @Transactional
    public String write(BoardDto boardDto)
    {

        boardDto.setBad(0);
        boardDto.setLike(0);
        boardDto.setViews(0);
        BoardEntity a = boardRepository.save(boardDto.toEntity());
        return "저장";
    }
    @Transactional
    public Page<BoardEntity>  getBoardList(Pageable pageable , String type)
    {
        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
        pageable= PageRequest.of(page,10,Sort.by(Sort.Direction.DESC, "num"));

        Specification<BoardEntity> spec = Specification.where(SpecsConfig.type_searech(type));

        return boardRepository.findAll((spec),pageable);

    }
    @Transactional
    public Page<BoardEntity>  getBoardSearchList(Pageable pageable , String serach , String type)
    {
        String search = serach;
        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
        pageable= PageRequest.of(page,10);

        Specification<BoardEntity> spec = Specification.where(SpecsConfig.title_searech(search));
        spec = spec.and(SpecsConfig.type_searech(type));

        return boardRepository.findAll((spec), pageable);

    }
    @Transactional
    public BoardDto View(int num , String type){

        Optional<BoardEntity> WrapboardEntity = boardRepository.findByNumAndType(num,type);
        BoardEntity boardEntity = WrapboardEntity.get();
        boardEntity.setViews(boardEntity.getViews() + 1);
        return boardEntity.toDto();
    }

    @Transactional
    public BoardDto Update(BoardDto boardDto)
    {
        boardRepository.save(boardDto.toEntity());
        return boardDto;
    }
    @Transactional
    public void Delete(BoardDto boardDto)
    {
        boardRepository.deleteById(boardDto.getNum());

    }

}
