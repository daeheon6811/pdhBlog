package com.pdh.web.repository;
import com.pdh.web.entity.BoardInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardInfoRepository extends JpaRepository<BoardInfoEntity, String> {
}
