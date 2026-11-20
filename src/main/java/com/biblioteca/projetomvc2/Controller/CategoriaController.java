package com.biblioteca.projetomvc2.Controller;

import com.biblioteca.projetomvc2.Model.Categoria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {
    private List<Categoria> categorias = new ArrayList<Categoria>();

    @GetMapping("/inicio") public String inicio(){
        return "redirect:/categorias";
    }
    @GetMapping
    public String inicio(Model model) {
        model.addAttribute("categoria", new Categoria());
        model.addAttribute("categorias", categorias);

        return "categorias/inicio";
    }

    @PostMapping
    public String cadastrar(Categoria categoria) {
        categorias.add(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/editar/{indice}")
    public String editar(@PathVariable("indice") int indice, Model model) {
        if (indice < 0 || indice >= categorias.size()) {
            return "redirect:/categorias";
        }
        model.addAttribute("categoria", categorias.get(indice));
        model.addAttribute("categorias", categorias);
        model.addAttribute("indice", indice);

        return "categorias/inicio";
    }

    @PostMapping("/editar/{indice}")
    public String atualizar(@PathVariable("indice") int indice, Categoria categoria) {
        if (indice >= 0 && indice < categorias.size()) {
            categorias.set(indice, categoria);
        }
        return "redirect:/categorias";
    }

    @DeleteMapping("/excluir/{indice}")
    public String excluir (@PathVariable("indice") int indice) {
        if (indice>= 0 && indice < categorias.size()) {
            categorias.remove(indice);
        }
        return "redirect:/categorias";
    }
}
