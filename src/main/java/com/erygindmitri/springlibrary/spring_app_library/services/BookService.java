package com.erygindmitri.springlibrary.spring_app_library.services;


import com.erygindmitri.springlibrary.spring_app_library.models.Book;
import com.erygindmitri.springlibrary.spring_app_library.models.Image;
import com.erygindmitri.springlibrary.spring_app_library.models.User;
import com.erygindmitri.springlibrary.spring_app_library.repositories.BookRepository;
import com.erygindmitri.springlibrary.spring_app_library.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public BookService(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    //получаем список книг
    public List<Book> bookList(String title){
        if(title != null) return bookRepository.findBookByTitle(title);
        return bookRepository.findAll();
    }

    //Сохранить , добавить новую книгу
    public void saveBook(Principal principal, Book book, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
        book.setUser(getUserByPrincipal(principal));
        Image image1;
        Image image2;
        Image image3;
        if(file1.getSize() != 0 ){
            image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            book.addImageToBook(image1);
        }
        if(file2.getSize() != 0 ){
            image2 = toImageEntity(file2);
            book.addImageToBook(image2);
        }
        if(file3.getSize() != 0 ){
            image3 = toImageEntity(file3);
            book.addImageToBook(image3);
        }

        //получаем и сохраняем превьюшную картинку
        Book bookFromDb = bookRepository.save(book);
        bookFromDb.setPreviewImageId(bookFromDb.getImages().get(0).getId());
        bookRepository.save(book);
    }

    public User getUserByPrincipal(Principal principal){
        if(principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

    //Удаляем книгу из библиотеки
    public void deleteBook(User user, Integer id){
        Book book = bookRepository.findById(id)
                        .orElse(null);
        if(book != null){
            if(book.getUser().getId().equals(user.getId())){
                bookRepository.deleteById(id);
            }
        }


    }

    //показать подробности о книге
    public Book getBookById(Integer id){

        return bookRepository.findById(id).orElse(null);
    }
}
