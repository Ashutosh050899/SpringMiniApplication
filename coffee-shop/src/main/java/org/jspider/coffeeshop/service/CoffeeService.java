package org.jspider.coffeeshop.service;

import org.jspider.coffeeshop.model.Coffee;
import org.jspider.coffeeshop.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeService {
    @Autowired

    private CoffeeRepository repository;

    public List<Coffee> showAll()
    {
        List<Coffee> coffeeList=repository.findAll();
        return coffeeList;
    }

    public void placeOrder(Coffee c){
        repository.save(c);
    }

    public void updateOrder(Coffee c)
    {
        repository.save(c);
    }

    public void cancelOrder(int id){
        repository.deleteById(id);
    }

}
