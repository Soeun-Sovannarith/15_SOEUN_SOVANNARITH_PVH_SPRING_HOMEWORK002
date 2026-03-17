//package com.rith._15_soeun_sovannarith_pvh_spring_homework02.services.Impl;
//
//
//import com.rith._15_soeun_sovannarith_pvh_spring_homework02.models.ApiRequest.AuthorRequest;
//import com.rith._15_soeun_sovannarith_pvh_spring_homework02.repositories.AuthorRepository;
//import com.rith._15_soeun_sovannarith_pvh_spring_homework02.services.AuthorService;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class AuthorServiceImpl implements AuthorService {
//    private final AuthorRepository authorRepository;
//
//    public AuthorServiceImpl(AuthorRepository authorRepository){
//        this.authorRepository = authorRepository;
//    }
//
//
//    @Override
//    public List<Author> getAllAuthor(Integer page, Integer size) {
//        Integer offset = page * (size -1);
//        return authorRepository.getAllAuthor(offset,size);
//    }
//
//    @Override
//    public Author getAuthorById(Integer authorId) {
//        return authorRepository.getAuthorById(authorId);
//    }
//
//    @Override
//    public Author addAuthor(AuthorRequest author) {
//        return authorRepository.addAuthor(author);
//    }
//}
//
