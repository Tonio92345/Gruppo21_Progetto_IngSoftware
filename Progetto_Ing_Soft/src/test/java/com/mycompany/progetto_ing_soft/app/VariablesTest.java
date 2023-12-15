package com.mycompany.progetto_ing_soft.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VariablesTest {
    private ComplexNumber cn;
    private StackComplex stack;
    private Variables variable;
    
    public VariablesTest() {
    }
    
    @BeforeEach
    public void setUp() {
        stack = new StackComplex();
        variable = new Variables(stack);
        cn = new ComplexNumber(0, 0);
    }
    
    @Test
    public void testSaveVar_PositiveNumbers() {
        ComplexNumber c0 = new ComplexNumber(1,2);
        ComplexNumber c1 = new ComplexNumber(2,3);
        char let = 'a';
        stack.addNumToStack(c0);
        stack.addNumToStack(c1);
        variable.saveVar(let);
        cn = variable.getVar(let);
        assertEquals(stack.topNum(), cn);
    }

    @Test
    public void testSaveVar_NegativeNumbers() {
        ComplexNumber c0 = new ComplexNumber(-1,-2);
        ComplexNumber c1 = new ComplexNumber(-2,-3);
        char let = 'a';
        stack.addNumToStack(c0);
        stack.addNumToStack(c1);
        variable.saveVar(let);
        cn = variable.getVar(let);
        assertEquals(stack.topNum(), cn);
    }
            
    @Test
    public void testSaveVar_PositiveAndNegativeNumbers() {
        ComplexNumber c0 = new ComplexNumber(-1,-2);
        ComplexNumber c1 = new ComplexNumber(2,3);
        char let = 'a';
        stack.addNumToStack(c0);
        stack.addNumToStack(c1);
        variable.saveVar(let);
        cn = variable.getVar(let);
        assertEquals(stack.topNum(), cn);
    }
    
    @Test
    public void testSaveVar_ZeroAsOneOperand() {
        ComplexNumber c0 = new ComplexNumber(1,2);
        ComplexNumber c1 = new ComplexNumber(0,0);
        char let = 'a';
        stack.addNumToStack(c0);
        stack.addNumToStack(c1);
        variable.saveVar(let);
        cn = variable.getVar(let);
        assertEquals(stack.topNum(), cn);
    }
    
    @Test
    public void testSaveVar_ZeroAsBothOperand() {
        ComplexNumber c0 = new ComplexNumber(0,0);
        ComplexNumber c1 = new ComplexNumber(0,0);
        char let = 'a';
        stack.addNumToStack(c0);
        stack.addNumToStack(c1);
        variable.saveVar(let);
        cn = variable.getVar(let);
        assertEquals(stack.topNum(), cn);
    }
    
    @Test
    public void testSaveNum_PositiveNumbers() {
        ComplexNumber c1 = new ComplexNumber(1,2);
        ComplexNumber c2 = new ComplexNumber(2,3);
        char let = 'a';
        stack.addNumToStack(c1);
        variable.saveVar(let);
        stack.addNumToStack(c2);
        variable.saveNum(let);
        cn = variable.getVar(let);
        assertEquals(stack.topNum(), cn);
    }
    
    @Test
    public void testSaveNum_NegativeNumbers() {
        ComplexNumber c1 = new ComplexNumber(-1,-2);
        ComplexNumber c2 = new ComplexNumber(-2,-3);
        char let = 'a';
        stack.addNumToStack(c1);
        variable.saveVar(let);
        stack.addNumToStack(c2);
        variable.saveNum(let);
        cn = variable.getVar(let);
        assertEquals(stack.topNum(), cn);
    }
    
    @Test
    public void testSaveNum_PositiveAndNegativeNumbers() {
        ComplexNumber c1 = new ComplexNumber(1,2);
        ComplexNumber c2 = new ComplexNumber(-2,-3);
        char let = 'a';
        stack.addNumToStack(c1);
        variable.saveVar(let);
        stack.addNumToStack(c2);
        variable.saveNum(let);
        cn = variable.getVar(let);
        assertEquals(stack.topNum(), cn);
    }
    
    @Test
    public void testSaveNum_ZeroAsOneOperand() {
        ComplexNumber c1 = new ComplexNumber(0,0);
        ComplexNumber c2 = new ComplexNumber(2,3);
        char let = 'a';
        stack.addNumToStack(c1);
        variable.saveVar(let);
        stack.addNumToStack(c2);
        variable.saveNum(let);
        cn = variable.getVar(let);
        assertEquals(stack.topNum(), cn);
    }
    
    @Test
    public void testSaveNum_ZeroAsBothOperand() {
        ComplexNumber c1 = new ComplexNumber(0,0);
        ComplexNumber c2 = new ComplexNumber(0,0);
        char let = 'a';
        stack.addNumToStack(c1);
        variable.saveVar(let);
        stack.addNumToStack(c2);
        variable.saveNum(let);
        cn = variable.getVar(let);
        assertEquals(stack.topNum(), cn);
    }

    @Test
    public void testAddVar_PositiveNumbers() {
        ComplexNumber c1 = new ComplexNumber(1,2);
        ComplexNumber c2 = new ComplexNumber(2,3);
        char let = 'a';
        stack.addNumToStack(c1);
        variable.saveVar(let);
        stack.addNumToStack(c2);
        variable.addVar(let);
        ComplexNumber sum = variable.getVar(let);
        assertEquals(new ComplexNumber(3, 5), sum);
    }
    
    @Test
    public void testAddVar_NegativeNumbers() {
        ComplexNumber c1 = new ComplexNumber(-1,-2);
        ComplexNumber c2 = new ComplexNumber(-2,-3);
        char let = 'a';
        stack.addNumToStack(c1);
        variable.saveVar(let);
        stack.addNumToStack(c2);
        variable.addVar(let);
        ComplexNumber sum = variable.getVar(let);
        assertEquals(new ComplexNumber(-3,-5), sum);
    }
    
    @Test
    public void testAddVar_PositiveAndNegativeNumbers() {
        ComplexNumber c1 = new ComplexNumber(1,2);
        ComplexNumber c2 = new ComplexNumber(-2,-3);
        char let = 'a';
        stack.addNumToStack(c1);
        variable.saveVar(let);
        stack.addNumToStack(c2);
        variable.addVar(let);
        ComplexNumber sum = variable.getVar(let);
        assertEquals(new ComplexNumber(-1,-1), sum);
    }
    
    @Test
    public void testAddVar_ZeroAsOneOperand() {
        ComplexNumber c1 = new ComplexNumber(1,2);
        ComplexNumber c2 = new ComplexNumber(0,0);
        char let = 'a';
        stack.addNumToStack(c1);
        variable.saveVar(let);
        stack.addNumToStack(c2);
        variable.addVar(let);
        ComplexNumber sum = variable.getVar(let);
        assertEquals(new ComplexNumber(1,2), sum);
    }
    
    @Test
    public void testAddVar_ZeroAsBothOperand() {
        ComplexNumber c1 = new ComplexNumber(0,0);
        ComplexNumber c2 = new ComplexNumber(0,0);
        char let = 'a';
        stack.addNumToStack(c1);
        variable.saveVar(let);
        stack.addNumToStack(c2);
        variable.addVar(let);
        ComplexNumber sum = variable.getVar(let);
        assertEquals(new ComplexNumber(0,0), sum);
    }


    @Test
    public void testSubVar_PositiveNumbers() {
        ComplexNumber c1 = new ComplexNumber(1,2);
        ComplexNumber c2 = new ComplexNumber(2,3);
        char let = 'a';
        stack.addNumToStack(c1);
        variable.saveVar(let);
        stack.addNumToStack(c2);
        variable.subVar(let);
        ComplexNumber sub = variable.getVar(let);
        assertEquals(new ComplexNumber(-1, -1), sub);
    }

    @Test
    public void testSubVar_NegativeNumbers() {
        ComplexNumber c1 = new ComplexNumber(-1,-2);
        ComplexNumber c2 = new ComplexNumber(-2,-3);
        char let = 'a';
        stack.addNumToStack(c1);
        variable.saveVar(let);
        stack.addNumToStack(c2);
        variable.subVar(let);
        ComplexNumber sub = variable.getVar(let);
        assertEquals(new ComplexNumber(1, 1), sub);
    }
    
    @Test
    public void testSubVar_PositiveAndNegativeNumbers() {
        ComplexNumber c1 = new ComplexNumber(1,2);
        ComplexNumber c2 = new ComplexNumber(-2,-3);
        char let = 'a';
        stack.addNumToStack(c1);
        variable.saveVar(let);
        stack.addNumToStack(c2);
        variable.subVar(let);
        ComplexNumber sub = variable.getVar(let);
        assertEquals(new ComplexNumber(3,5), sub);
    }
    
    @Test
    public void testSubVar_ZeroAsOneOperand() {
        ComplexNumber c1 = new ComplexNumber(0,0);
        ComplexNumber c2 = new ComplexNumber(1,2);
        char let = 'a';
        stack.addNumToStack(c1);
        variable.saveVar(let);
        stack.addNumToStack(c2);
        variable.subVar(let);
        ComplexNumber sub = variable.getVar(let);
        assertEquals(new ComplexNumber(-1,-2), sub);
    }
    
    @Test
    public void testSubVar_ZeroAsBothOperand() {
        ComplexNumber c1 = new ComplexNumber(0,0);
        ComplexNumber c2 = new ComplexNumber(0,0);
        char let = 'a';
        stack.addNumToStack(c1);
        variable.saveVar(let);
        stack.addNumToStack(c2);
        variable.subVar(let);
        ComplexNumber sub = variable.getVar(let);
        assertEquals(new ComplexNumber(0,0), sub);
    }
    
    @Test
    public void testGetVar_PositiveNumber() {
        ComplexNumber c1 = new ComplexNumber(1,2);
        char let = 'a';
        stack.addNumToStack(c1);
        variable.saveVar(let);
        ComplexNumber var = variable.getVar(let);
        assertEquals(new ComplexNumber(1,2), var);
    }
    
    @Test
    public void testGetVar_NegativeRealPart() {
        ComplexNumber c1 = new ComplexNumber(-1,2);
        char let = 'a';
        stack.addNumToStack(c1);
        variable.saveVar(let);
        ComplexNumber var = variable.getVar(let);
        assertEquals(new ComplexNumber(-1,2), var);
    }
    
    @Test
    public void testGetVar_NegativeImmPart() {
        ComplexNumber c1 = new ComplexNumber(1,-2);
        char let = 'a';
        stack.addNumToStack(c1);
        variable.saveVar(let);
        ComplexNumber var = variable.getVar(let);
        assertEquals(new ComplexNumber(1,-2), var);
    }
    
    @Test
    public void testGetVar_ZeroAsOperand() {
        ComplexNumber c1 = new ComplexNumber(0,0);
        char let = 'a';
        stack.addNumToStack(c1);
        variable.saveVar(let);
        ComplexNumber var = variable.getVar(let);
        assertEquals(new ComplexNumber(0,0), var);
    }

}
