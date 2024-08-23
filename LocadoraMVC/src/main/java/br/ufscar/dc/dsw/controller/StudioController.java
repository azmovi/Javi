package br.ufscar.dc.dsw.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.ufscar.dc.dsw.domain.Studio;
import br.ufscar.dc.dsw.service.spec.IStudioService;

@Controller
@RequestMapping("/studios")
public class StudioController {

    @Autowired
    private IStudioService service;

    @GetMapping("/cadastrar")
    public String cadastrar(Studio studio) {
        return "studio/cadastro";
    }

    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("studios", service.buscarTodos());
        return "studio/lista";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid Studio studio, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "studio/cadastro";
        }

        service.salvar(studio);
        attr.addFlashAttribute("sucess", "Studio inserido com sucesso.");
        return "redirect:/studios/listar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("studio", service.buscarPorId(id));
        return "studio/cadastro";
    }

    @PostMapping("/editar")
    public String editar(@Valid Studio studio, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return "studio/cadastro";
        }

        service.salvar(studio);
        attr.addFlashAttribute("sucess", "Studio editado com sucesso.");
        return "redirect:/studios/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
        if (service.studioTemFilmes(id)) {
            attr.addFlashAttribute("fail", "Studio não excluído. Possui Filme(s) vinculado(s).");
        } else {
            service.excluir(id);
            attr.addFlashAttribute("sucess", "Studio excluído com sucesso.");
        }
        return "redirect:/studios/listar";
    }
}

