package br.ufscar.web;

public class ConverterDomain{
    private Double max, min, inc; 

    public ConverterDomain()
    {

    }

    public ConverterDomain(Double min, Double max, Double inc)
    {
        this.min = min;
        this.max = max;
        this.inc = inc;
    }

        public Double getMin()
    {
        return this.min;
    }

    public Double getMax()
    {
        return this.max;
    }
        
    public Double getInc()
    {
        return this.inc;
    }

    public void setMin(Double min)
    {
        this.min = min;
    }
    
    public void setMax(Double max)
    {
        this.max = max;
    }

    public void setInc(Double inc)
    {
        this.inc = inc;
    }

}
