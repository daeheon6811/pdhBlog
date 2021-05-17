package com.pdh.web.service;
import com.pdh.web.dto.BoardDto;
import com.pdh.web.config.SpecsConfig;
import com.pdh.web.dto.BoardTypeDto;
import com.pdh.web.entity.BoardEntity;
import com.pdh.web.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private BoardRepository boardRepository;

    /*글 쓰기 */
    @Transactional
    public String getWrite(BoardDto boardDto)
    {

        boardDto.setBad(0);
        boardDto.setLike(0);
        boardDto.setViews(0);
        BoardEntity a = boardRepository.save(boardDto.toEntity());
        return "저장";
    }
    /*게시글 리스트 조회*/
    @Transactional
    public Page<BoardEntity>  getBoardList(Pageable pageable , String type)
    {
        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
        pageable= PageRequest.of(page,10,Sort.by(Sort.Direction.DESC, "num"));


        Specification<BoardEntity> spec = Specification.where(SpecsConfig.getTypeSearech(type));

        return boardRepository.findAll((spec),pageable);

    }
    @Transactional
    public String getBoardType(){

        return null;
    }

    /*검색 조회*/
    @Transactional
    public Page<BoardEntity>  getBoardSearchList(Pageable pageable , String serach , String type)
    {
        String search = serach;
        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
        pageable= PageRequest.of(page,10);

        Specification<BoardEntity> spec = Specification.where(SpecsConfig.getTitleSearech(search));
        spec = spec.and(SpecsConfig.getTypeSearech(type));

        return boardRepository.findAll((spec), pageable);

    }
    /*글 보기 조회 */
    @Transactional
    public BoardDto getView(int num , String type){

        Optional<BoardEntity> WrapboardEntity = boardRepository.findByNumAndType(num,type);
        BoardEntity boardEntity = WrapboardEntity.get();
        boardEntity.setViews(boardEntity.getViews() + 1);
        return boardEntity.toDto();
    }

    /*글 수정 */
    @Transactional
    public BoardDto getUpdate(BoardDto boardDto)
    {
        boardRepository.save(boardDto.toEntity());
        return boardDto;
    }
    /*글 삭제*/
    @Transactional
    public void getDelete(BoardDto boardDto)
    {
        boardRepository.deleteById(boardDto.getNum());

    }

}
