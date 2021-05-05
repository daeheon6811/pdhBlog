package com.pdh.web.service;


import com.pdh.web.dto.CommentDto;
import com.pdh.web.config.SpecsConfig;
import com.pdh.web.entity.CommentEntity;
import com.pdh.web.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentService {

    
    CommentRepository commentRepository;

    /*댓글 남기기*/
    @Transactional
    public void getReply(CommentDto commentDto) {
        commentRepository.save(commentDto.toEntity());
    }


    /*좋아요*/
    @Transactional
    public void getLikes(int num, int boardnum, String type) {
        Optional<CommentEntity> likesOptional = commentRepository.findByCommentnumAndBoardnumAndType(num, boardnum, type);
        CommentEntity commentEntity = likesOptional.get();
        System.out.println("like:" + commentEntity.getLike());
        commentEntity.setLike(commentEntity.getLike() + 1);
        commentRepository.save(commentEntity);
    }

    /*싫어요*/
    @Transactional
    public void getBed(int num, int boardnum, String type) {
        Optional<CommentEntity> likesOptional = commentRepository.findByCommentnumAndBoardnumAndType(num, boardnum, type);
        CommentEntity commentEntity = likesOptional.get();
        commentEntity.setBad(commentEntity.getBad() + 1);
        commentRepository.save(commentEntity);
    }


    /*댓글 갯수 */
    @Transactional
    public Long getReplyCount(int boardnum, String type) {
        return commentRepository.countByBoardnumAndType(boardnum, type);
    }

    /*댓글 리스트 */
    @Transactional
    public Page<CommentEntity> getCommendList(Pageable pageable, int boardnum) {


        String boardnum_str = Integer.toString(boardnum);

        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
        pageable = PageRequest.of(page, 25, Sort.by(Sort.Direction.DESC, "writeryear"));
        Specification<CommentEntity> spec = Specification.where(SpecsConfig.getBoardNumSearech(boardnum_str));

        return commentRepository.findAll((spec), pageable);
    }


}
