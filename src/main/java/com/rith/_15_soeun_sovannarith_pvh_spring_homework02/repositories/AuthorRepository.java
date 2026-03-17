//package com.rith._15_soeun_sovannarith_pvh_spring_homework02.repositories;
//
//
//import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.ApiRequest.AuthorRequest;
//import org.apache.ibatis.annotations.*;
//
//import java.util.List;
//
//@Mapper
//public interface AuthorRepository {
//
//    @Results(id = "authorMapper", value = {
//            @Result(property = "authorId", column = "author_id"),
//            @Result(property = "name", column = "name"),
//            @Result(property = "gender", column = "gender")
//    })
//    @Select("SELECT * FROM author OFFSET#{offset} LIMIT #{size}")
//   List<Author> getAllAuthor(Integer offset, Integer size);
//
//
//    @ResultMap("authorMapper")
//    @Select("SELECT * FROM author WHERE author_id = #{authorId};")
//    Author getAuthorById(Integer authorId);
//
//    @ResultMap("authorMapper")
//    @Select("INSERT INTO author VALUES(#{req.name},#{req.gender}) RETURNING *")
//    Author addAuthor(@Param("req") AuthorRequest author);
//}
