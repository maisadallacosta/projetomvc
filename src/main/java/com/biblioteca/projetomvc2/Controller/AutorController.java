package com.biblioteca.projetomvc2.Controller;

import com.biblioteca.projetomvc2.Model.Autor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/autores")
public class AutorController {
    private List<Autor> autores = new ArrayList<Autor>();

    @GetMapping("/inicio") public String inicio(){
        return "redirect:/autores";
    }
    @GetMapping
    public String inicio(Model model) {
        model.addAttribute("autor", new Autor());
        model.addAttribute("autores", autores);

        return "autores/inicio";
    }

    @PostMapping
    public String cadastrar(Autor autor) {
        autores.add(autor);
        return "redirect:/autores";
    }

    @GetMapping("/editar/{indice}")
    public String editar(@PathVariable("indice") int indice, Model model) {
        if (indice < 0 || indice >= autores.size()) {
            return "redirect:/autores";
        }
        model.addAttribute("autor", autores.get(indice));
        model.addAttribute("autores", autores);
        model.addAttribute("indice", indice);

        return "autores/inicio";
    }

    @PostMapping("/editar/{indice}")
    public String atualizar(@PathVariable("indice") int indice, Autor autor) {
        if (indice >= 0 && indice < autores.size()) {
            autores.set(indice, autor);
        }
        return "redirect:/autores";
    }

    @DeleteMapping("/excluir/{indice}")
    public String excluir (@PathVariable("indice") int indice) {
        if (indice>= 0 && indice < autores.size()) {
            autores.remove(indice);
        }
        return "redirect:/autores";
    }
}
