package com.biblioteca.projetomvc2.Controller;

import com.biblioteca.projetomvc2.Model.Emprestimo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/emprestimos")
public class EmprestimoController {
    private List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();

    @GetMapping("/inicio") public String inicio(){
        return "redirect:/emprestimos";
    }
    @GetMapping
    public String inicio(Model model) {
        model.addAttribute("emprestimo", new Emprestimo());
        model.addAttribute("emprestimos", emprestimos);

        return "emprestimos/inicio";
    }

    @PostMapping
    public String cadastrar(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
        return "redirect:/emprestimos";
    }

    @GetMapping("/editar/{indice}")
    public String editar(@PathVariable("indice") int indice, Model model) {
        if (indice < 0 || indice >= emprestimos.size()) {
            return "redirect:/emprestimos";
        }
        model.addAttribute("emprestimo", emprestimos.get(indice));
        model.addAttribute("emprestimos", emprestimos);
        model.addAttribute("indice", indice);

        return "emprestimos/inicio";
    }

    @PostMapping("/editar/{indice}")
    public String atualizar(@PathVariable("indice") int indice, Emprestimo emprestimo) {
        if (indice >= 0 && indice < emprestimos.size()) {
            emprestimos.set(indice, emprestimo);
        }
        return "redirect:/emprestimos";
    }

    @DeleteMapping("/excluir/{indice}")
    public String excluir (@PathVariable("indice") int indice) {
        if (indice>= 0 && indice < emprestimos.size()) {
            emprestimos.remove(indice);
        }
        return "redirect:/emprestimos";
    }
}
