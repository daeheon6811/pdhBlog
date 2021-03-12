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



    public static Specification<BoardEntity>titleLike(final String Keyword){
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get("title"),Keyword,root.get("title"));

    }
    public static Specification<BoardEntity> title_searech(final String keyword) {

        return new Specification<BoardEntity>() {
            @Override
            public Predicate toPredicate(Root<BoardEntity> root,
                                         CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.like(root.get("title"), "%" + keyword + "%");
            }
        };
    }
    public static Specification<BoardEntity> type_searech(final String keyword) {

        return new Specification<BoardEntity>() {
            @Override
            public Predicate toPredicate(Root<BoardEntity> root,
                                         CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.like(root.get("type"), keyword);
            }
        };
    }

    public static Specification<CommentEntity> boardnum_searech(final String keyword) {

        return new Specification<CommentEntity>() {
            @Override
            public Predicate toPredicate(Root<CommentEntity> root,
                                         CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.like(root.get("boardnum").as(String.class), keyword);
            }
        };
    }

    public static Specification<BoardEntity>searchboard(Map<String,Object> filter) {
        return (root, criteriaQuery, criteriaBuilder) ->
        {
            List<Predicate> predicates = new ArrayList<>();

            filter.forEach((key, value) -> {
                String likeValue = "%" + value + "%";
                switch (key) {
                    case "title":
                        predicates.add(criteriaBuilder.like(root.get(key).as(String.class), likeValue));
                        break;
                }
            });
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

    }


}
