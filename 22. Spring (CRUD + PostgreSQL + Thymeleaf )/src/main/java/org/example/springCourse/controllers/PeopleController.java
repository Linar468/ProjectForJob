package org.example.springCourse.controllers;


import org.example.springCourse.dao.PersonDAO;
import org.example.springCourse.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.show(id));
        return "people/show";

    }

    /*
    @GetMapping("/new")
    public String newPerson(Model model){

                                            //если используются ThymeLeaf формы,
                                                мы должны передавать тот объект
                                                    для которого эта форма нужна,
                                                        передача объекта Person выполняется с помощью в модели,
                                                            поэтому в параметрах необходимо указать модель
                                            // внедряем модель,
                                                затем в эту модель помещаем новый объект класса Person

                                            //Создаст объект,
                                                не считает никаких данных из поля, потому что их нету
                                                    пустой объект все равно положит в модель
        model.addAttribute("person", new Person());
        return "people/new";
    }*/

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        //указываем ключ с которым объект класса Person будет положен в модель
        //Аннотация @ModelAttribute создаст объект класса Person и положит его сама в модель
        return "people/new";
    }

    @PostMapping() // по пост запросу по адресу /people попадаем в этот метод
    public String create(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        // создает объект,
        // считывает данные из поля,
        // ПОМЕЩАЕТ эти данные в объект,
        // помещает этот объект в модель
        if (bindingResult.hasErrors())
            return "people/new";

        personDAO.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("person", personDAO.show(id));
        return "people/edit";

    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult, @PathVariable("id") int id) {
        // Model attribute принимает объект Person из формы по ключу person
        if (bindingResult.hasErrors())
            return "people/edit";
        personDAO.update(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        personDAO.delete(id);
        return "redirect:/people";
    }
}
