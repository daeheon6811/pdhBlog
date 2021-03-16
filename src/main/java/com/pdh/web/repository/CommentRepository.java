package com.pdh.web.repository;


import com.pdh.web.entity.CommentEntity;
import com.sun.istack.Nullable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {

    long countByBoardnumAndType(int boardnum, String type);

    /*글 번호 , 댓글 번호 , 타입 조회*/
    Optional<CommentEntity> findByCommentnumAndBoardnumAndType(int commentnum, int boardnum, String type);

    Page<CommentEntity> findAll(@Nullable Specification<CommentEntity> spec, Pageable pageable);

    Page<CommentEntity> findAllBy(Pageable pageable);
}
