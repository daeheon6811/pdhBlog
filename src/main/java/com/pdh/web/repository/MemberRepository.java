package com.pdh.web.repository;

import com.pdh.web.Dto.MemberDto;
import com.pdh.web.entity.MemberEntity;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface MemberRepository extends JpaRepository<MemberEntity, String> {



    Optional<MemberEntity> findByEmail(String email);
    Optional<MemberEntity> findByPassword(String Password);
    Optional<MemberEntity> findByEmailAndPassword(String email , String password);



}
