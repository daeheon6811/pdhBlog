package com.pdh.web.config;

import com.pdh.web.entity.BoardEntity;
import com.pdh.web.entity.CommentEntity;
import javassist.compiler.ast.Keyword;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SpecsConfig {




    /*제목 항목 조회*/
    public static Specification<BoardEntity> getTitleSearech(final String keyword) {

        return new Specification<BoardEntity>() {
            @Override
            public Predicate toPredicate(Root<BoardEntity> root,
                                         CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.like(root.get("title"), "%" + keyword + "%");
            }
        };
    }
    /*글 종류 조회*/
    public static Specification<BoardEntity> getTypeSearech(final String keyword) {

        return new Specification<BoardEntity>() {
            @Override
            public Predicate toPredicate(Root<BoardEntity> root,
                                         CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.like(root.get("type"), keyword);
            }
        };
    }

    /*글 번호 조회 */
    public static Specification<CommentEntity> getBoardNumSearech(final String keyword) {

        return new Specification<CommentEntity>() {
            @Override
            public Predicate toPredicate(Root<CommentEntity> root,
                                         CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.like(root.get("boardnum").as(String.class), keyword);
            }
        };
    }




}
