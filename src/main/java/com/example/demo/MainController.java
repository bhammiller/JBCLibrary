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
        libraryRepository.save(libraryBooks);
        return "redirect:/booklist";
    }

    // Goes to list of Borrowed Books
    @PostMapping("/borrowedbooks")
    public String availableBooks(Model model){
        model.addAttribute("borrowbooks", libraryRepository.findByBookavailability("borrowed"));
        return "bookreturnpage";
    }

    // Return Book this is an update
    public String bookReturn(Model model){

    }

    // Goes to list of Available Books
    @PostMapping("/availablebooks")
    public String checkedOutBooks(Model model){
        model.addAttribute("availbooks", libraryRepository.findByBookavailability("available"));
        return "borrowpage";
    }

    //Borrow Book this is an update
}