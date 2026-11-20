package com.biblioteca.projetomvc2.Controller;

import org.springframework.ui.Model;
import com.biblioteca.projetomvc2.Model.Livro;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/livros")
public class LivroController {

    private List<Livro> livros = new ArrayList<>();

    @GetMapping("/inicio")
    public String inicio() { return "livros/inicio";}

    @GetMapping
    public String listar(Model model){
        model.addAttribute("livros", livros);
        return "livros/lista";
    }

    public String cadastrar (@ModelAttribute Livro livro){
        livros.add(livro);
        return "redirect:/livros";
    }

    @DeleteMapping("/excluir/{indice}")
    public String excluir(@PathVariable int indice){
        if (indice >= 0 && indice < livros.size()){
            livros.remove(indice);
        }
        return "redirect:/livros";
    }

    @PostMapping("/editar/{indice}")
    public String atualizar(@PathVariable("indice") int indice, Livro livro) {
        if (indice >= 0 && indice < livros.size()) {
            livros.set(indice, livro);
        }
        return "redirect:/livros";
    }
}
