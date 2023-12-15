package com.mycompany.progetto_ing_soft.app;

import com.mycompany.progetto_ing_soft.exceptions.OneElementStackException;
import com.mycompany.progetto_ing_soft.exceptions.StackEmptyException;
import com.mycompany.progetto_ing_soft.exceptions.NotInitializedVarException;
import com.mycompany.progetto_ing_soft.exceptions.DivisionByZeroException;
import java.util.Stack;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;


public class StackComplex {
    private Stack<ComplexNumber> stack;
    private Variables var;
    
    public StackComplex() {
        this.stack = new Stack<>();
        var = new Variables(this);
    }
    
    public void checkOperation(String operatore, GridPane variables_pane) throws StackEmptyException, OneElementStackException, DivisionByZeroException, NotInitializedVarException{
        double re;
        double im;
        String parola[] = operatore.split("[+\\-j]");
        
        if("+".equals(operatore)){
            if(stack.isEmpty()){
                throw new StackEmptyException();
            }
            if(stack.size()==1){
                throw new OneElementStackException();
            }
            ComplexNumber n1 = removeNum();
            ComplexNumber n2 = removeNum();
            ComplexNumber sum = new ComplexNumber(0,0);
            addNumToStack(sum.addComp(n1, n2));
            
        }else if("-".equals(operatore)){
            if(stack.isEmpty()){
                throw new StackEmptyException();
            }
            if(stack.size()==1){
                throw new OneElementStackException();
            }
            ComplexNumber n1 = removeNum();
            ComplexNumber n2 = removeNum();
            ComplexNumber sub = new ComplexNumber(0,0);
            addNumToStack(sub.subComp(n1, n2));
            
        }else if("*".equals(operatore)){
            if(stack.isEmpty()){
                throw new StackEmptyException();
            }
            if(stack.size()==1){
                throw new OneElementStackException();
            }
            ComplexNumber n1 = removeNum();
            ComplexNumber n2 = removeNum();
            ComplexNumber mult = new ComplexNumber(0,0);
            addNumToStack(mult.multComp(n1, n2));
            
        }else if("/".equals(operatore)){
            if(stack.isEmpty()){
                throw new StackEmptyException();
            }
            if(stack.size()==1){
                throw new OneElementStackException();
            } 
            ComplexNumber n1 = removeNum();
            ComplexNumber n2 = removeNum();
            if(n2.equals(new ComplexNumber(0, 0)) || n2.equals(new ComplexNumber(0))){
                addNumToStack(n2);
                addNumToStack(n1);
                throw new DivisionByZeroException();
            }
            ComplexNumber div = new ComplexNumber(0,0);
            addNumToStack(div.divComp(n1, n2));
            
        }else if("SQRT".equals(operatore)){
            if(stack.isEmpty()){
                throw new StackEmptyException();
            }
            ComplexNumber n = removeNum();
            ComplexNumber num_zero = new ComplexNumber(0);
            if(!n.equals(num_zero)){
                ComplexNumber sqrt = new ComplexNumber(0,0);
                addNumToStack(sqrt.sqrtComp(n));
                addNumToStack(sqrt.signInversionComp(sqrt.sqrtComp(n))); 
            }
            else{
                addNumToStack(num_zero);
            }            
        }else if("+-".equals(operatore)){
            if(stack.isEmpty()){
                throw new StackEmptyException();
            }
            ComplexNumber n = removeNum();
            ComplexNumber inv = new ComplexNumber(0,0);
            addNumToStack(inv.signInversionComp(n));
            
        }else if("DROP".equals(operatore)){
            if(stack.isEmpty()){
                throw new StackEmptyException();
            }
            drop();
            
        }else if("DUP".equals(operatore)){
            if(stack.isEmpty()){
                throw new StackEmptyException();
            }
            dup();
            
        }else if("OVER".equals(operatore)){
            if(stack.isEmpty()){
                throw new StackEmptyException();
            }
            if(stack.size()==1){
                throw new OneElementStackException();
            }
            over();
            
        }else if("SWAP".equals(operatore)){
            if(stack.isEmpty()){
                throw new StackEmptyException();
            }
            if(stack.size()==1){
                throw new OneElementStackException();
            }
            swap();
                    
        }else if("CLEAR".equals(operatore)){
            clear();
            
        }else if(operatore.matches(">[a-z]{1}")){
            if(stack.isEmpty()){
                throw new StackEmptyException();
            }
            var.saveVar(operatore.charAt(1));
            char let = operatore.charAt(1);
            int index = 0;
            
            for(Node node : variables_pane.getChildren()){
                    if(node instanceof Label){
                        Label lab = (Label) node;
                        if(var.getVar(let)!=null && index==(let-97))
                            lab.setText(let + " = " + var.getVar(let));
                        index++;
                    }
            }
            
        }else if(operatore.matches("<[a-z]{1}")){
            if(var.getVar(operatore.charAt(1))==null)
                throw new NotInitializedVarException();
            var.saveNum(operatore.charAt(1));
            
        }else if(operatore.matches("\\+[a-z]{1}")){
            if(stack.isEmpty()){
                throw new StackEmptyException();
            }
            if(var.getVar(operatore.charAt(1))==null)
                throw new NotInitializedVarException();
            var.addVar(operatore.charAt(1));
            char let = operatore.charAt(1);
            int index = 0;
            
            for(Node node : variables_pane.getChildren()){
                    if(node instanceof Label){
                        Label lab = (Label) node;
                        if(var.getVar(let)!=null && index==(let-97))
                            lab.setText(let + " = " + var.getVar(let));
                        index++;
                    }
            }
            
        }else if(operatore.matches("-[a-z]{1}")){
            if(stack.isEmpty()){
                throw new StackEmptyException();
            }
            if(var.getVar(operatore.charAt(1))==null)
                throw new NotInitializedVarException();
            var.subVar(operatore.charAt(1));
            char let = operatore.charAt(1);
            int index = 0;
            
            for(Node node : variables_pane.getChildren()){
                    if(node instanceof Label){
                        Label lab = (Label) node;
                        if(var.getVar(let)!=null && index==(let-97))
                            lab.setText(let + " = " + var.getVar(let));
                        index++;
                    }
            }
            
        }else if(operatore.matches("\\+\\d+(\\.\\d+)?")){
            re = Double.parseDouble(parola[1]);
            addNumToStack(new ComplexNumber(re));
            
        }else if(operatore.matches("\\d+(\\.\\d+)?")){
            re = Double.parseDouble(parola[0]);
            addNumToStack(new ComplexNumber(re));
            
        }else if(operatore.matches("-\\d+(\\.\\d+)?")){
            re = Double.parseDouble(parola[1]);
            re = -re;
            addNumToStack(new ComplexNumber(re));
            
        }else if(operatore.matches("\\+?\\d+(\\.\\d+)?\\+\\d+(\\.\\d+)?j")){
            if(parola.length == 3){
                re = Double.parseDouble(parola[1]);
                im = Double.parseDouble(parola[2]);
                addNumToStack(new ComplexNumber(re, im));
            }else{
                re = Double.parseDouble(parola[0]);
                im = Double.parseDouble(parola[1]);
                addNumToStack(new ComplexNumber(re, im));
            }
            
        }else if(operatore.matches("\\+?\\d+(\\.\\d+)?-\\d+(\\.\\d+)?j")){
            if(parola.length == 3){
                re = Double.parseDouble(parola[1]);
                im = Double.parseDouble(parola[2]);
                im = -im;
                addNumToStack(new ComplexNumber(re, im));
            }else{
                re = Double.parseDouble(parola[0]);
                im = Double.parseDouble(parola[1]);
                im = -im;
                addNumToStack(new ComplexNumber(re, im));
            }
            
        }else if(operatore.matches("-\\d+(\\.\\d+)?\\+\\d+(\\.\\d+)?j")){
            re = Double.parseDouble(parola[1]);
            im = Double.parseDouble(parola[2]);
            re = -re;
            addNumToStack(new ComplexNumber(re, im));
            
        }else if(operatore.matches("-\\d+(\\.\\d+)?-\\d+(\\.\\d+)?j")){
            re = Double.parseDouble(parola[1]);
            im = Double.parseDouble(parola[2]);
            re = -re;
            im = -im;
            addNumToStack(new ComplexNumber(re, im));   
        }
    }
    
    public void addNumToStack(ComplexNumber c){
        stack.push(c);
    }
    
    public ComplexNumber removeNum(){
        return stack.pop();
    }
    
    public ComplexNumber topNum(){
        return stack.lastElement();
    } 
    
    public void clear(){
        stack.removeAllElements();
    }
    
    public void drop(){
        removeNum();
    }
    
    public void dup(){
        ComplexNumber c = stack.lastElement();
        addNumToStack(c);
    }
    
    public void swap(){
        ComplexNumber n2 = removeNum();
        ComplexNumber n1 = removeNum();
        addNumToStack(n2);
        addNumToStack(n1);
    }
    
    public void over(){
        ComplexNumber last = removeNum();
        ComplexNumber secondLast = stack.lastElement();
        addNumToStack(last);
        addNumToStack(secondLast);    
    }

    public Stack<ComplexNumber> getStack() {
        return stack;
    }
    
    public Variables getVariables(){
        return var;
    }
}