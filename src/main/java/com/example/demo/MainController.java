package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    LibraryRepository libraryRepository;
    long x;
    long w;
    int y=0;
    int z=0;

    // Starts Here
    @RequestMapping("/")
    public String gotoHome(Model model){
        return "homepage";
    }

    // Shows all Books
    @RequestMapping("/booklist")
    public String toBookList(Model model){
        model.addAttribute("fulllist",libraryRepository.findAll());
        return "booklistpage";
    }

    // Goes to Add a Book page
    @GetMapping("/addbook")
    public String addBook(Model model){
        model.addAttribute("libraryBooks",new LibraryBooks());
        return "addbookpage";
    }
    // Checks Validation of Added Book and posts the data
    @PostMapping("/processaddbook")
    public String processBookAdd(@Valid LibraryBooks libraryBooks, BindingResult result){
        if(result.hasErrors()){
            return "addbookpage";
        }
        libraryBooks.setBookavailability("available");
        libraryRepository.save(libraryBooks);
        return "redirect:/booklist";
    }

    // Book Detail page
    @RequestMapping("/bookdetail/{id}")
    public String bookDetail(@PathVariable("id") long id, Model model){
        model.addAttribute("libraryBooks", libraryRepository.findOne(id));
        return "bookpage";
    }

    // Goes to list of Borrowed Books
    @RequestMapping("/borrowedbooks")
    public String borrowedBooks(Model model){
        if(z==1){
            model.addAttribute("returned",libraryRepository.findOne(w));
        }
        z=0;
        model.addAttribute("borrowbooks", libraryRepository.findByBookavailability("borrowed"));
        return "bookreturnpage";
    }

    // Return Book this is an update
    @GetMapping("/returnbook/{id}")
    public String bookReturn(@PathVariable("id") long id){
        w=id;
        z=1;
        LibraryBooks libraryBooks = libraryRepository.findOne(id);
        libraryBooks.setBookavailability("available");
        libraryRepository.save(libraryBooks);
        return"redirect:/borrowedbooks";
    }

    // Goes to list of Available Books
    @RequestMapping("/availablebooks")
    public String checkOutBooks(Model model){
        if(y==1){
            model.addAttribute("borrowed",libraryRepository.findOne(x));
        }
        y=0;
        model.addAttribute("availbooks", libraryRepository.findByBookavailability("available"));
        return "borrowpage";
    }

    //Borrow Book this is an update
    @GetMapping("/checkout/{id}")
    public String bookBorrow(@PathVariable("id") long id){
        x=id;
        y=1;
        LibraryBooks libraryBooks = libraryRepository.findOne(id);
        libraryBooks.setBookavailability("borrowed");
        libraryRepository.save(libraryBooks);
        return"redirect:/availablebooks";
    }

}
