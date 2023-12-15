package com.mycompany.progetto_ing_soft.app;

public class Variables {
    private ComplexNumber var[];
    private StackComplex stack;

    public Variables(StackComplex stack) {
        this.stack = stack;
        var = new ComplexNumber[26];
    }
    
    public void saveVar(char let){
        var[let - 97] = stack.topNum();
    }
    
    public void saveNum(char let){
        stack.addNumToStack(var[let - 97]);
    }
    
    public void addVar(char let){
        ComplexNumber sum = new ComplexNumber(0,0);
        var[let - 97] = sum.addComp(var[let - 97], stack.topNum());
    }
    
    public void subVar(char let){
        ComplexNumber sub = new ComplexNumber(0,0);
        var[let - 97] = sub.subComp(var[let - 97], stack.topNum());
    }
    
    public ComplexNumber getVar(char let){
        return var[let-97];
    }
}
