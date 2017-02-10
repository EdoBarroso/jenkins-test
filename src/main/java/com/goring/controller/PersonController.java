package com.goring.controller;

import com.goring.domain.Person;
import com.goring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ekansh on 12/7/15.
 */

@Controller
@RequestMapping(value = {"","/person"})
public class PersonController {

    @Autowired
    private PersonService personService;


    @RequestMapping(value = {"/","index"})
    public String index(Model model){
        model.addAttribute("persons", personService.findAll());
        return "person/index";
    }

    @RequestMapping(value = "create")
    public String create(){
        return "person/create";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(Person person){
        personService.save(person);
        return "redirect:index";
    }

    @RequestMapping(value = "edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("person",personService.findById(id));
        return "person/edit";
    }


    @RequestMapping(value = "update",method = RequestMethod.POST)
    public String update(Person person){
        personService.save(person);
        return "redirect:index";
    }

    @RequestMapping(value = "delete/{id}")
    public String delete(@PathVariable Long id){
        personService.delete(id);
        return "redirect:/person/index";
    }

}
