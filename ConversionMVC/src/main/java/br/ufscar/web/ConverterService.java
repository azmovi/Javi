package br.ufscar.web;

import java.text.DecimalFormat;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public class ConverterService {
    private DecimalFormat df = new DecimalFormat("#.00");

    public ArrayList<Double> getCelsius(ConverterDomain converter) {
        ArrayList<Double> vecCelsius = new ArrayList<>();
        for (Double i = converter.getMin(); i <= converter.getMax(); i += converter.getInc()) {
            vecCelsius.add(i);
        }
        return vecCelsius;
    }

    public ArrayList<Double> getFahr(ArrayList<Double> vecCelsius) {
        ArrayList<Double> vecFahr = new ArrayList<>();
        for (Double value : vecCelsius) {
            vecFahr.add(1.8 * value + 32);
        }
        return vecFahr;
    }

    public ArrayList<Double> getKelvin(ArrayList<Double> vecCelsius) {
        ArrayList<Double> vecKelvin = new ArrayList<>();
        for (Double value : vecCelsius) {
            vecKelvin.add(Double.valueOf(df.format(value + 273.15)));
        }
        return vecKelvin;
    }
}

