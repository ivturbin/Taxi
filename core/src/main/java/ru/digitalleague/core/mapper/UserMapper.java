package ru.digitalleague.core.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.jdbc.core.SqlProvider;
import org.springframework.stereotype.Repository;
import ru.digitalleague.core.model.User;

import java.util.Optional;

@Mapper
@Repository
public interface UserMapper {
    void insert(User user);

    Optional<User> findByLogin(String s);

    @SelectProvider(value = SqlProvider.class, method = "test")
    User findTestSqlInjection(String sql);
}
