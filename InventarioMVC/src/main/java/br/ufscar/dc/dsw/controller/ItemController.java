package br.ufscar.dc.dsw.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufscar.dc.dsw.domain.Loja;
import br.ufscar.dc.dsw.domain.Item;
import br.ufscar.dc.dsw.service.spec.ILojaService;
import br.ufscar.dc.dsw.service.spec.IItemService;

@Controller
@RequestMapping("/itens")
public class ItemController {

	@Autowired
	private IItemService itemService;

	@Autowired
	private ILojaService lojaService;

	@GetMapping("/cadastrar")
	public String cadastrar(Item Item) {
		return "item/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("Itens", itemService.buscarTodos());
		return "item/lista";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid Item Item, BindingResult result, RedirectAttributes attr) {

		if (result.hasErrors()) {
			return "item/cadastro";
		}

		itemService.salvar(Item);
		attr.addFlashAttribute("sucess", "Item inserido com sucesso");
		return "redirect:/itens/listar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("item", itemService.buscarPorId(id));
		return "item/cadastro";
	}

	@PostMapping("/editar")
	public String editar(@Valid Item Item, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "item/cadastro";
		}

		itemService.salvar(Item);
		attr.addFlashAttribute("sucess", "Item editado com sucesso.");
		return "redirect:/itens/listar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		itemService.excluir(id);
		attr.addFlashAttribute("sucess", "Item excluído com sucesso.");
		return "redirect:/itens/listar";
	}

	@ModelAttribute("lojas")
	public List<Loja> listaLojas() {
		return lojaService.buscarTodos();
	}
}
