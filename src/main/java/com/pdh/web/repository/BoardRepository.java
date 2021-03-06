package com.pdh.web.repository;

import com.pdh.web.entity.BoardEntity;
import com.sun.istack.Nullable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<BoardEntity, Integer> , JpaSpecificationExecutor<BoardEntity> {
    Optional<BoardEntity> findByNumAndType(@Nullable  int i , String type); // 번호,타입 조회

    Page<BoardEntity> findAll(@Nullable  Specification<BoardEntity> spec, Pageable pageable); // 모든 리스트 조회
    Page<BoardEntity> findAllBy(@Nullable  Pageable pageable);


}
