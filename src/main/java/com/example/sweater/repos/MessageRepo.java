package com.example.sweater.repos;

import com.example.sweater.domain.Message;
import com.example.sweater.domain.User;
import com.example.sweater.domain.dto.MessageDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MessageRepo extends CrudRepository<Message, Long> {

    @Query("SELECT new com.example.sweater.domain.dto.MessageDto(" +
            "m," +
            "COUNT(ml)," +
            "(SUM(CASE WHEN ml = :user THEN 1 ELSE 0 END) > 0)" +
            ") " +
            "FROM Message m LEFT JOIN m.likes ml " +
            "GROUP BY m")
    Page<MessageDto> findAll(Pageable pageable, @Param("user") User user);

    @Query("SELECT new com.example.sweater.domain.dto.MessageDto(" +
            "m," +
            "COUNT(ml)," +
            "(SUM(CASE WHEN ml = :user THEN 1 ELSE 0 END) > 0)" +
            ") " +
            "FROM Message m LEFT JOIN m.likes ml " +
            "WHERE m.tag = :tag " +
            "GROUP BY m")
    Page<MessageDto> findByTag(@Param("tag") String tag, Pageable pageable, @Param("user") User user);

    @Query("SELECT new com.example.sweater.domain.dto.MessageDto(" +
            "m," +
            "COUNT(ml)," +
            "(SUM(CASE WHEN ml = :user THEN 1 ELSE 0 END) > 0)" +
            ") " +
            "FROM Message m LEFT JOIN m.likes ml " +
            "WHERE m.author = :author " +
            "GROUP BY m")
    Page<MessageDto> findByUser(Pageable pageable, @Param("user") User user, @Param("author") User author);
}
