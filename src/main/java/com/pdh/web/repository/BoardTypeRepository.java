package com.pdh.web.repository;

import com.pdh.web.entity.BoardInfoEntity;
import com.pdh.web.entity.BoardTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardTypeRepository extends JpaRepository<BoardTypeEntity, String> {
    Optional<BoardTypeEntity> findByBoardtypenm(String typecm);


}
