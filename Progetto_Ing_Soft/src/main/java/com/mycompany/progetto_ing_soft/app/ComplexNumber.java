package com.mycompany.progetto_ing_soft.app;

public class ComplexNumber {
    private double real_part;
    private double imaginary_part;

    public ComplexNumber(double real_part) {
        this.real_part = real_part;
        this.imaginary_part = 0;
    }

    public ComplexNumber(double real_part, double imaginary_part) {
        this.real_part = real_part;
        this.imaginary_part = imaginary_part;
    }
    
    public ComplexNumber addComp(ComplexNumber n1, ComplexNumber n2){
        double a = n1.real_part + n2.real_part;
        double b = n1.imaginary_part + n2.imaginary_part;
        ComplexNumber sum = new ComplexNumber(a, b);
        return sum;
    }
    
    public ComplexNumber subComp(ComplexNumber n1, ComplexNumber n2){
        double a = n1.real_part - n2.real_part;
        double b = n1.imaginary_part - n2.imaginary_part;
        ComplexNumber sub = new ComplexNumber(a, b);
        return sub;
    }
    
    public ComplexNumber multComp(ComplexNumber n1, ComplexNumber n2){
        double a = (n1.real_part * n2.real_part) - (n1.imaginary_part * n2.imaginary_part);
        double b = (n1.real_part * n2.imaginary_part) + (n1.imaginary_part * n2.real_part);
        ComplexNumber mult = new ComplexNumber(a, b);
        return mult;
    }
    
    public ComplexNumber divComp(ComplexNumber n1, ComplexNumber n2){
        double a = (n1.real_part * n2.real_part) + (n1.imaginary_part * n2.imaginary_part);
        double b = (n2.real_part * n2.real_part) + (n2.imaginary_part * n2.imaginary_part);
        double c = (n1.imaginary_part * n2.real_part) - (n1.real_part * n2.imaginary_part);
        double d = (n2.real_part * n2.real_part) + (n2.imaginary_part * n2.imaginary_part);
        
        ComplexNumber div = new ComplexNumber(a/b, c/d);
        return div;
    }
    
    public ComplexNumber sqrtComp(ComplexNumber n1){
        double modulo = Math.sqrt(Math.pow(n1.real_part, 2) + Math.pow(n1.imaginary_part, 2));
        double argomento = Math.atan2(n1.imaginary_part, n1.real_part);

        double radiceModulo = Math.sqrt(modulo);
        double parteRealeRadice = radiceModulo * Math.cos(argomento / 2);
        double parteImmaginariaRadice = radiceModulo * Math.sin(argomento / 2);

        return new ComplexNumber(parteRealeRadice, parteImmaginariaRadice);   
    }
    
    public ComplexNumber signInversionComp(ComplexNumber n1){
        double a = n1.real_part;
        double b = n1.imaginary_part;
        
        if(n1.real_part != 0){
            a = -a;
        }
        if(n1.imaginary_part != 0){
            b = -b;
        }
        
        ComplexNumber sI = new ComplexNumber(a, b);
        return sI;
    }

    @Override
    public String toString() {
        String str;
        str = String.format("%.2f", real_part) + " + (" + String.format("%.2f", imaginary_part) + ")j";
        return str;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.real_part) ^ (Double.doubleToLongBits(this.real_part) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.imaginary_part) ^ (Double.doubleToLongBits(this.imaginary_part) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ComplexNumber other = (ComplexNumber) obj;
        if (Double.doubleToLongBits(this.real_part) != Double.doubleToLongBits(other.real_part)) {
            return false;
        }
        if (Double.doubleToLongBits(this.imaginary_part) != Double.doubleToLongBits(other.imaginary_part)) {
            return false;
        }
        return true;
    }

    public double getReal_part() {
        return real_part;
    }

    public double getImaginary_part() {
        return imaginary_part;
    }
   
}