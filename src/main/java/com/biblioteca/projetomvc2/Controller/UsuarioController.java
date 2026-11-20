package com.biblioteca.projetomvc2.Controller;
import com.biblioteca.projetomvc2.Model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    private List<Usuario> usuarios = new ArrayList<>();

    @GetMapping("/inicio") public String inicio(){
        return "redirect:/usuario";
    }

    @GetMapping public String inicio(Model model){
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", usuarios);

        return "usuario/inicio";
    }

    @PostMapping public String inserirUsuario(Usuario usuario){
        usuarios.add(usuario);
        return "redirect:/usuario";
    }

    @GetMapping("/editar/{indice}")
    public String editarUsuario(@PathVariable("indice") int indice, Model model){
        if (indice < 0 || indice >= usuarios.size()){
            return "redirect:/usuario";
        }
        model.addAttribute("usuario", usuarios.get(indice));
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("indice", indice);

        return "usuario/inicio";
    }

    @PostMapping("/editar/{indice}")
    public String atualizarUsuario(@PathVariable("indice") int indice, Usuario usuario){
        if (indice >= 0 && indice < usuarios.size()){
            // o campo de senha vem vazio na edição: mantém a senha antiga se não digitaram outra
            if (usuario.getSenha() == null || usuario.getSenha().isBlank()){
                usuario.setSenha(usuarios.get(indice).getSenha());
            }
            usuarios.set(indice, usuario);
        }
        return "redirect:/usuario";
    }

    @DeleteMapping("/excluir/{indice}")
    public String excluirUsuario(@PathVariable("indice") int indice){
        if (indice >= 0 && indice < usuarios.size()){
            usuarios.remove(indice);
        }
        return "redirect:/usuario";
    }
}
