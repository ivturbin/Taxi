package ru.digitalleague.core.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import ru.digitalleague.core.model.Authority;

import java.util.List;


@Mapper
@Repository
public interface AuthorityMapper {
    void insertAll(List<Authority> authorities);
}
