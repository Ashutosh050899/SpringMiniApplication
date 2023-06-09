package org.jspider.coffeeshop.controller;

import org.jspider.coffeeshop.model.Coffee;
import org.jspider.coffeeshop.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CoffeeController {
    @Autowired

    private CoffeeService service;

    List<Coffee> coffeeList=new ArrayList<>();

    @GetMapping("/")
    public String showAllOrder(Model model)
    {
        coffeeList= service.showAll();
        model.addAttribute("records",coffeeList);
        return "orderlist";
    }
    @GetMapping("/addOrder")
    public String showOrderForm(Model model)
    {
        model.addAttribute(new Coffee());
        return "placeOrder";
    }

    @PostMapping("/placeOrder")
    public String placeorder(Coffee c)
    {
        service.placeOrder(c);
        return "redirect:/";
    }

@GetMapping("/updateorder/{id}")
    public String showUpdateForm(@PathVariable(value = "id")int id, Model model){
        Coffee c=coffeeList.get(id-1);
        model.addAttribute("coffee",c);
        return "updateorder";
    }
    @PostMapping("/updateOrder")
    public String changeOrder(Coffee c)
    {
        service.updateOrder(c);
        return "redirect:/";
    }
    @GetMapping ("/deleteorder/{id}")
    public String cancelOrder(@PathVariable(value = "id") int id)
    {
        for (int i = 0; i < coffeeList.size(); i++) {

            Coffee c1=coffeeList.get(i);
            if(c1.getOrderNo()==id)
            {
                service.cancelOrder(id);
            }
        }
        return "redirect:/";
    }

}
