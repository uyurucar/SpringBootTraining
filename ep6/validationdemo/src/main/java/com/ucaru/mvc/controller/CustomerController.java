package com.ucaru.mvc.controller;


import com.ucaru.mvc.entity.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {

    //remove whitespace characters beforehand
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder)
    {
        StringTrimmerEditor editor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, editor);
    }

    @GetMapping("/")
    //@ResponseBody
    public String showCustomerForm(Model theModel)
    {
        theModel.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @PostMapping("/processForm")
    public String processCustomerForm(@Valid @ModelAttribute("customer") Customer theCustomer,
                                      BindingResult theBindingResult)
    {
        //System.out.println("last name: **" + theCustomer.getLastName() + "**");

        if(theBindingResult.hasErrors())
        {
            System.out.println(theBindingResult.toString());
            return "customer-form";
        }
        else
            return "customer-confirmation";
    }

}
