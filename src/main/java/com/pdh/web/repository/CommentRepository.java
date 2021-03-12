package com.pdh.web.repository;



import com.pdh.web.entity.CommentEntity;
import com.sun.istack.Nullable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {

    long countByBoardnumAndType(int boardnum , String type);

    Optional<CommentEntity> findByCommentnumAndBoardnumAndType(int commentnum , int boardnum , String type);
    Page<CommentEntity> findAll(@Nullable Specification<CommentEntity> spec, Pageable pageable);
    Page<CommentEntity> findAllBy(Pageable pageable);
}
