package com.mycompany.progetto_ing_soft.app;

import com.mycompany.progetto_ing_soft.exceptions.*;
import java.util.Stack;
import javafx.scene.layout.GridPane;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class StackComplexTest {
    
    private StackComplex stack; 
    
    public StackComplexTest() {
    }

    @BeforeEach
    public void setUp() {
        stack = new StackComplex();
    }

    /**
     * Test di checkOperation quando viene richiesta un'operazione di clear, che non ha bisogno di operandi.
     */
    //Con lo stack vuoto
    @Test
    public void testCheckOperation_clearWithStackEmpty() throws Exception {
        stack.checkOperation("CLEAR", null);
        
        assertEquals(0, stack.getStack().size());
    }
    
    //Con lo stack popolato
    @Test
    public void testCheckOperation_clearWithStackNotEmpty() throws Exception {
        stack.addNumToStack(new ComplexNumber(5, 8));
        stack.addNumToStack(new ComplexNumber(-4));
        stack.addNumToStack(new ComplexNumber(0, 7));
        stack.checkOperation("CLEAR", null);
        
        assertEquals(0, stack.getStack().size());
    }
    
    /*
     * Test di checkOperation quando viene richiesta un'operazione su un operando(matematica e non)
    */
    //con stack vuoto
    @Test
    public void testCheckOperation_dup_stackEmptyException() throws Exception {
        assertThrows(StackEmptyException.class, () -> {
           stack.checkOperation("DUP", null);
        });
    }
    
    @Test
    public void testCheckOperation_drop_stackEmptyException() throws Exception {
        assertThrows(StackEmptyException.class, () -> {
           stack.checkOperation("DROP", null);
        });
    }
    
    @Test
    public void testCheckOperation_sqrt_stackEmptyException() throws Exception {
        assertThrows(StackEmptyException.class, () -> {
           stack.checkOperation("SQRT", null);
        });
    }
    
    //Con stack popolato
    @Test
    public void testCheckOperation_dup_stackNotEmpty() throws Exception {
        stack.addNumToStack(new ComplexNumber(3));
        stack.addNumToStack(new ComplexNumber(-7, 5));
        stack.addNumToStack(new ComplexNumber(0, 6));
        int dim = stack.getStack().size();
        ComplexNumber n = stack.topNum();
        
        stack.checkOperation("DUP", null);
        
        assertEquals(dim+1, stack.getStack().size());
        assertEquals(n, stack.topNum());
        
    }
    
    @Test
    public void testCheckOperation_drop_stackNotEmpty() throws Exception {
        stack.addNumToStack(new ComplexNumber(3));
        stack.addNumToStack(new ComplexNumber(-7, 5));
        stack.addNumToStack(new ComplexNumber(0, 6));
        ComplexNumber n1 = stack.removeNum();
        ComplexNumber n2 = stack.topNum();
        stack.addNumToStack(n1);
        int dim = stack.getStack().size();
        
        stack.checkOperation("DROP", null);
        
        assertEquals(dim-1, stack.getStack().size());
        assertEquals(n2, stack.topNum());
    }
    
    @Test
    public void testCheckOperation_sqrt_stackNotEmpty() throws Exception {
        stack.addNumToStack(new ComplexNumber(3));
        stack.addNumToStack(new ComplexNumber(9, 6));
        ComplexNumber sqrt = new ComplexNumber(0);
        ComplexNumber last = stack.topNum();
        int dim = stack.getStack().size();
        
        stack.checkOperation("SQRT", null);
        
        assertEquals(dim+1, stack.getStack().size());
        assertEquals(sqrt.multComp(new ComplexNumber(-1), sqrt.sqrtComp(last)), stack.removeNum());
        assertEquals(sqrt.sqrtComp(last), stack.removeNum());
    }
    
    /*
     * Test di checkOperation quando viene richiesta un'operazione su due operandi(matematica e non)
    */
    //Con lo stack vuoto
    @Test
    public void testCheckOperation_add_StackEmptyException() throws Exception {
        assertThrows(StackEmptyException.class, () -> {
            stack.checkOperation("+", null);
        });
    }
    
    @Test
    public void testCheckOperation_sub_StackEmptyException() throws Exception {
        assertThrows(StackEmptyException.class, () -> {
            stack.checkOperation("-", null);
        });
    }
    
    @Test
    public void testCheckOperation_mult_StackEmptyException() throws Exception {
        assertThrows(StackEmptyException.class, () -> {
            stack.checkOperation("*", null);
        });
    }
    
    @Test
    public void testCheckOperation_div_StackEmptyException() throws Exception {
        assertThrows(StackEmptyException.class, () -> {
            stack.checkOperation("/", null);
        });
    }
    
    @Test
    public void testCheckOperation_swap_StackEmptyException() throws Exception {
        assertThrows(StackEmptyException.class, () -> {
            stack.checkOperation("SWAP", null);
        });
    }
    
    @Test
    public void testCheckOperation_over_StackEmptyException() throws Exception {
        assertThrows(StackEmptyException.class, () -> {
            stack.checkOperation("OVER", null);
        });
    }
    
    //Con un elemento nello stack
    @Test
    public void testCheckOperation_add_oneElementIntoTheStackException() throws Exception {
        stack.addNumToStack(new ComplexNumber(4, 5));
        assertThrows(OneElementStackException.class, () -> {
            stack.checkOperation("+", null);
        });
    }
    
    @Test
    public void testCheckOperation_sub_oneElementIntoTheStackException() throws Exception {
        stack.addNumToStack(new ComplexNumber(4, 5));
        assertThrows(OneElementStackException.class, () -> {
            stack.checkOperation("-", null);
        });
    }
    
    @Test
    public void testCheckOperation_mult_oneElementIntoTheStackException() throws Exception {
        stack.addNumToStack(new ComplexNumber(4, 5));
        assertThrows(OneElementStackException.class, () -> {
            stack.checkOperation("*", null);
        });
    }
    
    @Test
    public void testCheckOperation_div_oneElementIntoTheStackException() throws Exception {
        stack.addNumToStack(new ComplexNumber(4, 5));
        assertThrows(OneElementStackException.class, () -> {
            stack.checkOperation("/", null);
        });
    }
    
    @Test
    public void testCheckOperation_swap_oneElementIntoTheStackException() throws Exception {
        stack.addNumToStack(new ComplexNumber(4, 5));
        assertThrows(OneElementStackException.class, () -> {
            stack.checkOperation("SWAP", null);
        });
    }
    
    @Test
    public void testCheckOperation_over_oneElementIntoTheStackException() throws Exception {
        stack.addNumToStack(new ComplexNumber(4, 5));
        assertThrows(OneElementStackException.class, () -> {
            stack.checkOperation("OVER", null);
        });
    }
    
    //Con almeno due elementi nello stack
    @Test
    public void testCheckOperation_add_AtLeast2ElementInStack() throws Exception {
        ComplexNumber n1 = new ComplexNumber(4, 5);
        ComplexNumber n2 = new ComplexNumber(-7);
        ComplexNumber sum = new ComplexNumber(0);
        stack.addNumToStack(n1);
        stack.addNumToStack(n2);
        int dim = stack.getStack().size();
        
        stack.checkOperation("+", null);
        
        assertEquals(dim-1, stack.getStack().size());
        assertEquals(sum.addComp(n1, n2), stack.topNum());
    }
    
    @Test
    public void testCheckOperation_sub_AtLeast2ElementInStack() throws Exception {
        ComplexNumber n1 = new ComplexNumber(4, 5);
        ComplexNumber n2 = new ComplexNumber(-7);
        ComplexNumber sub = new ComplexNumber(0);
        stack.addNumToStack(n1);
        stack.addNumToStack(n2);
        int dim = stack.getStack().size();
        
        stack.checkOperation("-", null);
        
        assertEquals(dim-1, stack.getStack().size());
        assertEquals(sub.subComp(n2, n1), stack.topNum());
    }
    
    @Test
    public void testCheckOperation_mult_AtLeast2ElementInStack() throws Exception {
        ComplexNumber n1 = new ComplexNumber(4, 5);
        ComplexNumber n2 = new ComplexNumber(-7);
        ComplexNumber mult = new ComplexNumber(0);
        stack.addNumToStack(n1);
        stack.addNumToStack(n2);
        int dim = stack.getStack().size();
        
        stack.checkOperation("*", null);
        
        assertEquals(dim-1, stack.getStack().size());
        assertEquals(mult.multComp(n1, n2), stack.topNum());
    }
    
    @Test
    public void testCheckOperation_div_AtLeast2ElementInStack() throws Exception {
        ComplexNumber n1 = new ComplexNumber(4, 5);
        ComplexNumber n2 = new ComplexNumber(-7);
        ComplexNumber div = new ComplexNumber(0);
        stack.addNumToStack(n1);
        stack.addNumToStack(n2);
        int dim = stack.getStack().size();
        
        stack.checkOperation("/", null);
        
        assertEquals(dim-1, stack.getStack().size());
        assertEquals(div.divComp(n2, n1), stack.topNum());
    }
    
    @Test
    public void testCheckOperation_swap_AtLeast2ElementInStack() throws Exception {
        ComplexNumber n1 = new ComplexNumber(4, 5);
        ComplexNumber n2 = new ComplexNumber(-7);
        stack.addNumToStack(n1);
        stack.addNumToStack(n2);
        
        stack.checkOperation("SWAP", null);
        
        assertEquals(n1, stack.removeNum());
        assertEquals(n2, stack.removeNum());
    }
    
    @Test
    public void testCheckOperation_over_AtLeast2ElementInStack() throws Exception {
        ComplexNumber n1 = new ComplexNumber(4, 5);
        ComplexNumber n2 = new ComplexNumber(-7);
        stack.addNumToStack(n1);
        stack.addNumToStack(n2);
        int dim = stack.getStack().size();
        
        stack.checkOperation("OVER", null);
        
        assertEquals(dim+1, stack.getStack().size());
        assertEquals(n1, stack.topNum());
    }
    
    /*
     * Operazioni sulle variabili
    */
    //Con stack vuoto e variabile scelta non inizializzata
    @Test
    public void testCheckOperation_saveVar_StackEmpty_VarNotInit() throws Exception {
        assertThrows(StackEmptyException.class, () -> {
           stack.checkOperation(">a", null);
        });
    }
    
    @Test
    public void testCheckOperation_saveNum_StackEmpty_VarNotInit() throws Exception {
        assertThrows(NotInitializedVarException.class, () -> {
           stack.checkOperation("<a", null);
        });
    }
    
    @Test
    public void testCheckOperation_addVar_StackEmpty_VarNotInit() throws Exception {
        assertThrows(StackEmptyException.class, () -> {
           stack.checkOperation("+a", null);
        });
    }
    
    @Test
    public void testCheckOperation_subVar_StackEmpty_VarNotInit() throws Exception {
        assertThrows(StackEmptyException.class, () -> {
           stack.checkOperation("-a", null);
        });
    }
    
    //Con stack vuoto e variabile inizializzata
    @Test
    public void testCheckOperation_saveNum_stackEmpty_varInit() throws Exception{
        stack.addNumToStack(new ComplexNumber(6, -9));
        char let = 'a';
        Variables v = stack.getVariables();
        v.saveVar(let);
        
        stack.clear();
        int dim = stack.getStack().size();
        
        stack.checkOperation("<a", null);
        
        assertEquals(dim+1, stack.getStack().size());
        assertEquals(v.getVar(let), stack.topNum());
        
    }
    
    @Test
    public void testCheckOperation_saveVar_stackEmpty_varInit() throws Exception{
        stack.addNumToStack(new ComplexNumber(6, -9));
        char let = 'a';
        Variables v = stack.getVariables();
        v.saveVar(let);
        stack.clear();
        assertThrows(StackEmptyException.class, () -> {
            stack.checkOperation(">a", null);
        });
    }
    
    @Test
    public void testCheckOperation_addNum_stackEmpty_varInit() throws Exception{
        stack.addNumToStack(new ComplexNumber(6, -9));
        char let = 'a';
        Variables v = stack.getVariables();
        v.saveVar(let);
        stack.clear();
        assertThrows(StackEmptyException.class, () -> {
            stack.checkOperation("+a", null);
        });
        
    }
    
    @Test
    public void testCheckOperation_subNum_stackEmpty_varInit() throws Exception{
        stack.addNumToStack(new ComplexNumber(6, -9));
        char let = 'a';
        Variables v = stack.getVariables();
        v.saveVar(let);
        stack.clear();
        assertThrows(StackEmptyException.class, () -> {
            stack.checkOperation("-a", null);
        });
        
    }
    
    //Stack popolato ma variabile non inizializzata
    @Test
    public void testCheckOperation_saveVar_stackNotEmpty_varNotInit() throws Exception{
        stack.addNumToStack(new ComplexNumber(6, -9));
        stack.addNumToStack(new ComplexNumber(9, -2));
        stack.addNumToStack(new ComplexNumber(-3));
        Variables v = stack.getVariables();
        
        stack.checkOperation(">a", new GridPane());
        
        assertEquals(v.getVar('a'), stack.topNum());
    }
    
    @Test
    public void testCheckOperation_saveNum_stackNotEmpty_varNotInit() throws Exception{
        stack.addNumToStack(new ComplexNumber(6, -9));
        stack.addNumToStack(new ComplexNumber(9, -2));
        stack.addNumToStack(new ComplexNumber(-3));
        
        assertThrows(NotInitializedVarException.class, () -> {
            stack.checkOperation("<a", new GridPane());
        });
    }
    
    @Test
    public void testCheckOperation_addVar_stackNotEmpty_varNotInit() throws Exception{
        stack.addNumToStack(new ComplexNumber(6, -9));
        stack.addNumToStack(new ComplexNumber(9, -2));
        stack.addNumToStack(new ComplexNumber(-3));
        
        assertThrows(NotInitializedVarException.class, () -> {
            stack.checkOperation("+a", new GridPane());
        });
    }
    
    @Test
    public void testCheckOperation_subVar_stackNotEmpty_varNotInit() throws Exception{
        stack.addNumToStack(new ComplexNumber(6, -9));
        stack.addNumToStack(new ComplexNumber(9, -2));
        stack.addNumToStack(new ComplexNumber(-3));
        
        assertThrows(NotInitializedVarException.class, () -> {
            stack.checkOperation("-a", new GridPane());
        });
    }
    
    //Con stack non vuoto e variabile inizializzata
    @Test
    public void testCheckOperation_saveVar_stackNotEmpty_varInit() throws Exception{        
        stack.addNumToStack(new ComplexNumber(6, -9));
        stack.addNumToStack(new ComplexNumber(9, -2));
        stack.addNumToStack(new ComplexNumber(-3));
        Variables v = stack.getVariables();
        v.saveVar('a');
        
        stack.checkOperation(">a", new GridPane());
        
        assertEquals(v.getVar('a'), stack.topNum());
    }
    
    @Test
    public void testCheckOperation_saveNum_stackNotEmpty_varInit() throws Exception{
        stack.addNumToStack(new ComplexNumber(6, -9));
        stack.addNumToStack(new ComplexNumber(9, -2));
        stack.addNumToStack(new ComplexNumber(-3));
        Variables v = stack.getVariables();
        v.saveVar('a');  
        int dim = stack.getStack().size();
        
        stack.checkOperation("<a", new GridPane());
        
        assertEquals(dim+1, stack.getStack().size());
        assertEquals(stack.topNum(), v.getVar('a'));
    }
    
    @Test
    public void testCheckOperation_addVar_stackNotEmpty_varInit() throws Exception{
        stack.addNumToStack(new ComplexNumber(6, -9));
        stack.addNumToStack(new ComplexNumber(9, -2));
        stack.addNumToStack(new ComplexNumber(-3));
        Variables v = stack.getVariables();
        v.saveVar('a');
        ComplexNumber n = v.getVar('a');
        int dim = stack.getStack().size();
        
        stack.checkOperation("+a", new GridPane());
        
        ComplexNumber sum = new ComplexNumber(0);
        assertEquals(sum.addComp(stack.topNum(), n), v.getVar('a'));
    }
    
    @Test
    public void testCheckOperation_subVar_stackNotEmpty_varInit() throws Exception{
        stack.addNumToStack(new ComplexNumber(-3, 2));
        Variables v = stack.getVariables();
        v.saveVar('a');
        ComplexNumber n = v.getVar('a');
        int dim = stack.getStack().size();
        stack.addNumToStack(new ComplexNumber(-4));
        
        stack.checkOperation("-a", new GridPane());
        
        ComplexNumber sub = new ComplexNumber(0);
        assertEquals(sub.subComp(n, stack.topNum()), v.getVar('a'));
    }
    
    /**
     * Test di addNumToStack con numeri con parte reale positivi, negativi e nulla
     */
    @Test
    public void testAddNumToStack_positiveNumbers() {
        ComplexNumber num = new ComplexNumber(3, 4);
        int dim = stack.getStack().size();
        stack.addNumToStack(num);
        
        
        assertEquals(dim+1, stack.getStack().size());
        assertEquals(num, stack.topNum());
    }
    
    @Test
    public void testAddNumToStack_realPart_positive() {
        ComplexNumber num = new ComplexNumber(3);
        int dim = stack.getStack().size();
        stack.addNumToStack(num);
        
        assertEquals(dim+1, stack.getStack().size());
        assertEquals(num, stack.topNum());
    }
    
    @Test
    public void testAddNumToStack_realPart_negative() {
        ComplexNumber num = new ComplexNumber(-9);
        int dim = stack.getStack().size();
        stack.addNumToStack(num);
        
        assertEquals(dim+1, stack.getStack().size());
        assertEquals(num, stack.topNum());
    }
    
    @Test
    public void testAddNumToStack_negativeNumbers() {
        ComplexNumber num = new ComplexNumber(-8, -7);
        int dim = stack.getStack().size();
        stack.addNumToStack(num);
        
        assertEquals(dim+1, stack.getStack().size());
        assertEquals(num, stack.topNum());
    }
    
    @Test
    public void testAddNumToStack_positiveAndNegativeNumbers() {
        ComplexNumber num = new ComplexNumber(-2, 7);
        int dim = stack.getStack().size();
        stack.addNumToStack(num);
        
        assertEquals(dim+1, stack.getStack().size());
        assertEquals(num, stack.topNum());
    }
    
    @Test
    public void testAddNumToStack_realPart_zero() {
        ComplexNumber num = new ComplexNumber(0);
        int dim = stack.getStack().size();
        stack.addNumToStack(num);
        
        assertEquals(dim+1, stack.getStack().size());
        assertEquals(num, stack.topNum());
    }
    
    @Test
    public void testAddNumToStack_zeroAsOneOperand() {
        ComplexNumber num = new ComplexNumber(0, -7);
        int dim = stack.getStack().size();
        stack.addNumToStack(num);
        
        assertEquals(dim+1, stack.getStack().size());
        assertEquals(num, stack.topNum());
    }
    
    

    /**
     * Test of removeNum method, of class StackComplex.
     */
    @Test
    public void testRemoveNum_positiveNumbers() {
        ComplexNumber num = new ComplexNumber(8, 5);
        stack.addNumToStack(num);
        assertEquals(num, stack.removeNum());
    }
    
    @Test
    public void testRemoveNum_realPart_positive(){
        ComplexNumber num = new ComplexNumber(5);
        stack.addNumToStack(num);
        assertEquals(num, stack.removeNum());
    }
    
    @Test
    public void testRemoveNum_negativeNumbers() {
        ComplexNumber num = new ComplexNumber(-1, -6);
        stack.addNumToStack(num);
        assertEquals(num, stack.removeNum());
    }
    
    @Test
    public void testRemoveNum_realPart_negative() {
        ComplexNumber num = new ComplexNumber(-4);
        stack.addNumToStack(num);
        assertEquals(num, stack.removeNum());
    }
    
    @Test
    public void testRemoveNum_positiveAndNegativeNumbers() {
        ComplexNumber num = new ComplexNumber(-4, 10);
        stack.addNumToStack(num);
        assertEquals(num, stack.removeNum());
    }
    
    @Test
    public void testRemoveNum_zeroAsOneOperand() {
        ComplexNumber num = new ComplexNumber(0, -4);
        stack.addNumToStack(num);
        assertEquals(num, stack.removeNum());
    }
    
    /**
     * Test of clear method, of class StackComplex.
     */
    @Test
    public void testClear_ZeroElementIntoTheStack() {
        stack.clear();
        assertEquals(0, stack.getStack().size());
    }
    
    @Test
    public void testClear_OneElementIntoTheStack() {
        stack.addNumToStack(new ComplexNumber(2, 3));
        stack.clear();
        assertEquals(0, stack.getStack().size());
    }
    
    @Test
    public void testClear_MoreElementsIntoTheStack() {
        stack.addNumToStack(new ComplexNumber(2, 3));
        stack.addNumToStack(new ComplexNumber(-2, -83));
        stack.addNumToStack(new ComplexNumber(2));
        stack.addNumToStack(new ComplexNumber(0, -7));
        stack.addNumToStack(new ComplexNumber(8));
        stack.clear();
        assertEquals(0, stack.getStack().size());
    }

    /**
     * Test of drop method, of class StackComplex.
     */
    @Test
    public void testDrop_oneElementIntoTheStack(){
        stack.addNumToStack(new ComplexNumber(5, 8));
        int dim = stack.getStack().size();
        stack.drop();
        assertEquals(dim-1, stack.getStack().size());
    }
    
    @Test
    public void testDrop_MoreElementsIntoTheStack(){
        stack.addNumToStack(new ComplexNumber(5, 8));
        stack.addNumToStack(new ComplexNumber(0, 8));
        stack.addNumToStack(new ComplexNumber(-5, -7));
        stack.addNumToStack(new ComplexNumber(-2));
        int dim = stack.getStack().size();
        stack.drop();
        assertEquals(dim-1, stack.getStack().size());
    }
    
    

    /**
     * Test of dup method, of class StackComplex.
     */   
    @Test
    public void testDup_oneElementIntoTheStack(){
        stack.addNumToStack(new ComplexNumber(5, 8));
        int dim = stack.getStack().size();
        ComplexNumber n = stack.topNum();
        stack.dup();
        
        assertEquals(dim+1, stack.getStack().size());
        assertEquals(n, stack.topNum());
    }
    
    @Test
    public void testDup_MoreElementsIntoTheStack(){
        stack.addNumToStack(new ComplexNumber(5, 8));
        stack.addNumToStack(new ComplexNumber(0, 8));
        stack.addNumToStack(new ComplexNumber(-5, -7));
        stack.addNumToStack(new ComplexNumber(-2));
        int dim = stack.getStack().size();
        ComplexNumber n = stack.topNum();
        stack.dup();
        
        assertEquals(dim+1, stack.getStack().size());
        assertEquals(n, stack.topNum());
    }

    /**
     * Test of swap method, of class StackComplex.
     */
    @Test
    public void testSwap_MoreElementsIntoTheStack() {
        stack.addNumToStack(new ComplexNumber(-9, 3));
        stack.addNumToStack(new ComplexNumber(2, -7));
        stack.addNumToStack(new ComplexNumber(1, 1));
        
        //Prendo ultimo e penultimo elemento prima dello swap
        ComplexNumber n1, n2;
        n1 = stack.removeNum();
        n2 = stack.topNum();
        stack.addNumToStack(n1);
        
        stack.swap();
        
        ComplexNumber n1_swapped, n2_swapped;
        n1_swapped = stack.removeNum();
        n2_swapped = stack.topNum();
        stack.addNumToStack(n1_swapped);
        
        assertEquals(n1, n2_swapped);
        assertEquals(n2, n1_swapped);
    }

    /**
     * Test of over method, of class StackComplex.
     */
    @Test
    public void testOver_MoreElementsIntoTheStack() {
        stack.addNumToStack(new ComplexNumber(-5));
        stack.addNumToStack(new ComplexNumber(7, -3));
        stack.addNumToStack(new ComplexNumber(0, 8));
        
        //Prendo penultimo elemento e dimensione dello stack prima dell'over
        ComplexNumber n1, n2;
        n1 = stack.removeNum();
        n2 = stack.topNum();
        stack.addNumToStack(n1);
        int dim = stack.getStack().size();
        
        stack.over();
        
        assertEquals(dim+1, stack.getStack().size());
        assertEquals(n2, stack.topNum());
        
    }

    /**
     * Test of getStack method, of class StackComplex.
     */
    @Test
    public void testGetStack() {
        Stack<ComplexNumber> s;
        s = stack.getStack();
        
        
        assertEquals(stack.getStack().size(), s.size());
        for(int i=0; i<s.size(); i++){
            assertEquals(stack.getStack().elementAt(i), s.elementAt(i));
        }
    }
    
    /*
     * Test di getVariables
    */
    @Test
    public void testGetVariables(){
        Variables var;
        var = stack.getVariables();
        char let = 'a';
        
        for(char i='a'; i<='z'; i++){
            assertEquals(stack.getVariables().getVar(i), var.getVar(i));
        }
    }
    
    @Test
    public void testCheckOperation_div_divisionByZeroException() throws Exception {
        stack.addNumToStack(new ComplexNumber(0));
        stack.addNumToStack(new ComplexNumber(4, 5));
        
        assertThrows(DivisionByZeroException.class, () -> {
            stack.checkOperation("/", null);
        });
    }
    
}
