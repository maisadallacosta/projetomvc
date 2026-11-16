package com.biblioteca.projetomvc2.Controller;

import org.springframework.ui.Model;
import com.biblioteca.projetomvc2.Model.Livro;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/livro")
public class LivroController {

    @GetMapping
    public String exibirLivros(Model model) {

        Livro livro = new Livro();
        livro.setTitulo("Livro 1");
        livro.setAutor("Autor");
        livro.setIsbn("4545555455");

        model.addAttribute("livro", livro);

        return "livro";
    }
}
