package br.ufscar.dc.dsw.beans;

public class ConversorServelet
{
    private int maximo, minimo, incremento;

    public void set_maximo(final int maximo)
    {
        this.maximo = maximo;
    }

    public int get_maximo() {
        return maximo;
    }

    public void set_minimo(final int minimo)
    {
        this.minimo = minimo;
    }

    public int get_minimo() {
        return minimo;
    }

    public void set_incremento(final int incremento)
    {
        this.incremento = incremento;
    }

    public int get_incremento() {
        return incremento;
    }
}
