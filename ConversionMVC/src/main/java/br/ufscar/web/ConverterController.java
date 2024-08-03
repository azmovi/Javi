package br.ufscar.web;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConverterController {
    @Autowired
    private ConverterService converterService;

    @GetMapping("/")
    public String formulario(Model model) {
        model.addAttribute("converter", new ConverterDomain());
        return "formulario";
    }

    @PostMapping("/converter")
    public String tabela(@ModelAttribute ConverterDomain converter, Model model) {
        ArrayList<Double> celsius = converterService.getCelsius(converter);
        model.addAttribute("celsius", celsius);

        ArrayList<Double> fahr = converterService.getFahr(celsius);
        model.addAttribute("fahr", fahr);

        ArrayList<Double> kelvin = converterService.getKelvin(celsius);
        model.addAttribute("kelvin", kelvin);

        return "tabela";
    }
}

