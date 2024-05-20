package com.luv2code.springdemo.mvc;

import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CustomerController {

    //Add support for @initBinder to convert trim input strings
    //remove leading and trailing whitespace
    //resolve issue for our validation
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }

    @GetMapping("/")
    public String showForm(Model theModel){
        //model allow us to share information between controllers and view page(thymeleaf)
        theModel.addAttribute("customer",new Customer());
        //map over the html file customer-form.html
        return "customer-form";
    }

    @PostMapping("/processForm")
    public String processForm(
            @Valid @ModelAttribute("customer") Customer theCustomer,
            BindingResult theBindingResults){
        //binding result holds the results of the validation

        System.out.println("last name: |" + theCustomer.getLastName() + "|");

        System.out.println("Binding results: "+theBindingResults.toString());

        System.out.println("\n\n\n");

        if (theBindingResults.hasErrors()){
            return "customer-form";
        }else {
            return "customer-confirmation";
        }
    }

}
