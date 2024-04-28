package br.ufscar.dc.dsw.beans;

import java.util.ArrayList;

public class Convert{
    private int maximo, minimo, incremento;
    private ArrayList<Integer> array_celsius;

    public Convert() {}

    public int getMin()
    {
        return this.minimo;
    }

    public int getMax()
    {
        return this.maximo;
    }
        
    public int getInc()
    {
        return this.incremento;
    }

    public void setMin(int minimo)
    {
        this.minimo = minimo;
    }
    
    public void setMax(int maximo)
    {
        this.maximo = maximo + 1;
    }

    public void setInc(int incremento)
    {
        this.incremento = incremento;
    }
    
    public ArrayList<Integer> getCelsius()
    {
        this.array_celsius = new ArrayList<>();
        for (int i = this.minimo; i < this.maximo; i += this.incremento) {
            this.array_celsius.add(i);
        }
        return array_celsius;
    }

    public ArrayList<Double> getFahr()
    {
        ArrayList<Double> array_fahr = new ArrayList<>();
        for (int i = this.minimo; i < this.maximo; i += this.incremento) {
            array_fahr.add(1.8 * i + 32);
        }
        return array_fahr;
    }

    public ArrayList<Double> getKelvin()
    {
        ArrayList<Double> array_kelvin = new ArrayList<>();
        for (int i = this.minimo; i < this.maximo; i += this.incremento) {
            array_kelvin.add(i + 273.15);
        }
        return array_kelvin;
    }
}
