package br.ufscar.dc.dsw.beans;

import java.util.ArrayList;

public class convert{
    private int maximo, minimo, incremento;
    public double fahr, kelvin;

    public ArrayList<Integer> vetor_celsius;
    public ArrayList<Double> vetor_fahr, vetor_kelvin;

    public convert() {
        vetor_celsius = new ArrayList<>();
        vetor_fahr = new ArrayList<>();
        vetor_kelvin = new ArrayList<>();

        for (int celsius = minimo; celsius <= maximo; celsius += incremento) {
            fahr = 1.8 * celsius + 32;
            kelvin = celsius + 273.15;
            vetor_celsius.add(celsius);
            vetor_fahr.add(fahr);
            vetor_kelvin.add(kelvin);
        }
    }
    public ArrayList<Integer> get_vetor_celsius() {
        return vetor_celsius;
    }

    public ArrayList<Double> get_vetor_fahr() {
        return vetor_fahr;
    }

    public ArrayList<Double> get_vetor_kelvin() {
        return vetor_kelvin;
    }

}
