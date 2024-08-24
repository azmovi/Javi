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
        attr.addFlashAttribute("success", "Studio inserido com sucesso.");
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

        // Apenas rejeita se o problema não for com o CNPJ (CNPJ campo read-only)
        if (result.getFieldErrorCount() > 1 || result.getFieldError("CNPJ") == null) {
            return "studio/cadastro";
        }

        service.salvar(studio);
        attr.addFlashAttribute("success", "Studio editado com sucesso.");
        return "redirect:/studios/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable("id") Long id, ModelMap model) {
        if (service.studioTemFilmes(id)) {
            model.addAttribute("fail", "Studio não excluída. Possui filme(s) vinculado(s).");
        } else {
            service.excluir(id);
            model.addAttribute("success", "Studio excluída com sucesso.");
        }
        return listar(model);
    }
}

