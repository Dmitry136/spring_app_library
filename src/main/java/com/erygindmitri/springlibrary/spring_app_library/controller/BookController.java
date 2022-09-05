package com.erygindmitri.springlibrary.spring_app_library.controller;

import com.erygindmitri.springlibrary.spring_app_library.models.Book;
import com.erygindmitri.springlibrary.spring_app_library.models.User;
import com.erygindmitri.springlibrary.spring_app_library.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String books(@RequestParam(name = "searchWord", required = false) String title, Principal principal, Model model){
        model.addAttribute("books", bookService.bookList(title));
        model.addAttribute("user", bookService.getUserByPrincipal(principal));
        return "books";
    }

    @PostMapping("/book/add")
    public String addBook(@RequestParam("file1") MultipartFile file1,
                          @RequestParam("file2") MultipartFile file2,
                          @RequestParam("file3") MultipartFile file3, Principal principal,
                          Book book) throws IOException {
        bookService.saveBook(principal, book, file1, file2, file3);
        return "redirect:/";
    }

    @PostMapping("/book/delete/{id}")
    public String deleteBook(@PathVariable Integer id, Principal principal){
        bookService.deleteBook(bookService.getUserByPrincipal(principal), id);
        return "redirect:/";
    }

    @GetMapping("/book/{id}")
    public String bookInfo(@PathVariable Integer id, Model model, Principal principal){
        Book book = bookService.getBookById(id);
        model.addAttribute("user", bookService.getUserByPrincipal(principal));
        model.addAttribute("book", book);
        model.addAttribute("images", book.getImages());
        return "book-info";
    }

    @GetMapping("/my/book")
    public String userBook(Principal principal, Model model){
        User user = bookService.getUserByPrincipal(principal);
        model.addAttribute("user", user);
        model.addAttribute("books", user.getBookList());
        return "my-book";
    }
}
