package com.mycompany.progetto_ing_soft.app;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ComplexNumberTest {
    
    public ComplexNumberTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addComp method, of class ComplexNumber.
     */
    @Test
    public void testAddComp_PositiveNumbers() {
        ComplexNumber a = new ComplexNumber(2, 3);
        ComplexNumber b = new ComplexNumber(4, 5);
        ComplexNumber result = a.addComp(a, b);
        assertEquals(new ComplexNumber(6, 8), result);
    }
    
    @Test
    public void testAddComp_NegativeNumbers() {
        ComplexNumber a = new ComplexNumber(-2, -3);
        ComplexNumber b = new ComplexNumber(-4, -5);
        ComplexNumber result = a.addComp(a, b);
        assertEquals(new ComplexNumber(-6, -8), result);
    }
    
    @Test
    public void testAddComp_PositiveAndNegativeNumbers() {
        ComplexNumber a = new ComplexNumber(2, 3);
        ComplexNumber b = new ComplexNumber(-4, -5);
        ComplexNumber result = a.addComp(a, b);
        assertEquals(new ComplexNumber(-2, -2), result);
    }
        
    
    
    @Test
    public void testAddComp_ZeroAsOneOperand() {
        ComplexNumber a = new ComplexNumber(0, 0);
        ComplexNumber b = new ComplexNumber(4, 5);
        ComplexNumber result = a.addComp(a, b);
        assertEquals(new ComplexNumber(4, 5), result);
    }
        
    
    
    @Test
    public void testAddComp_ZeroAsBothOperand() {
        ComplexNumber a = new ComplexNumber(0, 0);
        ComplexNumber b = new ComplexNumber(0, 0);
        ComplexNumber result = a.addComp(a, b);
        assertEquals(new ComplexNumber(0, 0), result);
    }
    
    

    /**
     * Test of subComp method, of class ComplexNumber.
    */
    
    @Test
    public void testSubComp_PositiveNumbers() {
        ComplexNumber a = new ComplexNumber(4, 5);
        ComplexNumber b = new ComplexNumber(2, 3);
        ComplexNumber result = a.subComp(a, b);
        assertEquals(new ComplexNumber(2, 2), result);
    }

    @Test
    public void testSubComp_NegativeNumbers() {
        ComplexNumber a = new ComplexNumber(-4, -5);
        ComplexNumber b = new ComplexNumber(-2, -3);
        ComplexNumber result = a.subComp(a, b);
        assertEquals(new ComplexNumber(-2, -2), result);
    }

    @Test
    public void testSubComp_PositiveAndNegativeNumbers() {
        ComplexNumber a = new ComplexNumber(2, 3);
        ComplexNumber b = new ComplexNumber(-4, -5);
        ComplexNumber result = a.subComp(a, b);
        assertEquals(new ComplexNumber(6, 8), result);
    }

    @Test
    public void testSubComp_ZeroAsOneOperand() {
        ComplexNumber a = new ComplexNumber(4, 5);
        ComplexNumber b = new ComplexNumber(0, 0);
        ComplexNumber result = a.subComp(a, b);
        assertEquals(new ComplexNumber(4, 5), result);
    }

    @Test
    public void testSubComp_ZeroAsBothOperands() {
        ComplexNumber a = new ComplexNumber(0, 0);
        ComplexNumber b = new ComplexNumber(0, 0);
        ComplexNumber result = a.subComp(a, b);
        assertEquals(new ComplexNumber(0, 0), result);
    }
    
    /**
     * Test of multComp method, of class ComplexNumber.
     */
    
    
    @Test
    public void testMultComp_PositiveNumbers() {
        ComplexNumber a = new ComplexNumber(2, 3);
        ComplexNumber b = new ComplexNumber(4, 5);
        ComplexNumber result = a.multComp(a, b);
        assertEquals(new ComplexNumber(-7, 22), result);
    }

    @Test
    public void testMultComp_NegativeNumbers() {
        ComplexNumber a = new ComplexNumber(-2, -3);
        ComplexNumber b = new ComplexNumber(-4, -5);
        ComplexNumber result = a.multComp(a, b);
        assertEquals(new ComplexNumber(-7, 22), result);
    }

    @Test
    public void testMultComp_PositiveAndNegativeNumbers() {
        ComplexNumber a = new ComplexNumber(2, 3);
        ComplexNumber b = new ComplexNumber(-4, -5);
        ComplexNumber result = a.multComp(a, b);
        assertEquals(new ComplexNumber(7, -22), result);
    }

    @Test
    public void testMultComp_ZeroAsOneOperand() {
        ComplexNumber a = new ComplexNumber(4, 5);
        ComplexNumber b = new ComplexNumber(0, 0);
        ComplexNumber result = a.multComp(a, b);
        assertEquals(new ComplexNumber(0, 0), result);
    }

    @Test
    public void testMultComp_ZeroAsBothOperands() {
        ComplexNumber a = new ComplexNumber(0, 0);
        ComplexNumber b = new ComplexNumber(0, 0);
        ComplexNumber result = a.multComp(a, b);
        assertEquals(new ComplexNumber(0, 0), result);
    }

    
    /**
     * Test of divComp method, of class ComplexNumber.
    */
    
    @Test
    public void testDivComp_PositiveNumbers() {
        ComplexNumber a = new ComplexNumber(6, 8);
        ComplexNumber b = new ComplexNumber(2, 2);
        ComplexNumber result = a.divComp(a, b);
        assertEquals(new ComplexNumber(3.5, 0.5), result);
    }

    
    @Test
    public void testDivComp_NegativeNumbers() {
        ComplexNumber a = new ComplexNumber(-6, -8);
        ComplexNumber b = new ComplexNumber(-2, -2);
        ComplexNumber result = a.divComp(a, b);
        assertEquals(new ComplexNumber(3.5, 0.5), result);
    }

    
    @Test
    public void testDivComp_PositiveAndNegativeNumbers() {
        ComplexNumber a = new ComplexNumber(6, 8);
        ComplexNumber b = new ComplexNumber(-2, -2);
        ComplexNumber result = a.divComp(a, b);
        assertEquals(new ComplexNumber(-3.5, -0.5), result);
    }

    
    @Test
    public void testDivComp_ZeroAsOneOperand() {
        ComplexNumber a = new ComplexNumber(0, 0);
        ComplexNumber b = new ComplexNumber(4, 5);
        ComplexNumber result = a.divComp(a, b);
        assertEquals(new ComplexNumber(0, 0), result);
    }

    
    
    @Test
    public void testDivComp_ZeroAsBothOperands() {
        ComplexNumber a = new ComplexNumber(0, 0);
        ComplexNumber b = new ComplexNumber(0, 0);
        ComplexNumber result = a.divComp(a, b);
        assertNotEquals(new ComplexNumber(0, 0), result);
    }
    //è giusto che non sia uguale, poiché in questo caso l'eccezione "DivisionByZeroException" viene gestita in StackComplex
    

    /**
     * Test of sqrtComp method, of class ComplexNumber.
    */
    
    @Test
    public void testSqrtComp_PositiveRealPart() {
        ComplexNumber a = new ComplexNumber(4, 0);
        ComplexNumber result = a.sqrtComp(a);
        assertEquals(new ComplexNumber(2, 0), result);
    }

    
    @Test
    public void testSqrtComp_NegativeRealPart() {
        ComplexNumber a = new ComplexNumber(-4, 0);
        ComplexNumber expected = new ComplexNumber(0, 2);
        ComplexNumber result = a.sqrtComp(a);
    
        double tolerance = 0.001;
    
        assertEquals(expected.getReal_part(), result.getReal_part(), tolerance);
        assertEquals(expected.getImaginary_part(), result.getImaginary_part(), tolerance);
    }
    
    

    @Test
    public void testSqrtComp_PositiveImaginaryPart() {
        ComplexNumber a = new ComplexNumber(0, 4);
        ComplexNumber expected = new ComplexNumber(Math.sqrt(2), Math.sqrt(2));
        ComplexNumber result = a.sqrtComp(a);
    
        double tolerance = 0.001;
    
        assertEquals(expected.getReal_part(), result.getReal_part(), tolerance);
        assertEquals(expected.getImaginary_part(), result.getImaginary_part(), tolerance);
    }

    
    @Test
    public void testSqrtComp_NegativeImaginaryPart() {
        ComplexNumber a = new ComplexNumber(0, -4);
        ComplexNumber expected = new ComplexNumber(Math.sqrt(2), -Math.sqrt(2));
        ComplexNumber result = a.sqrtComp(a);
    
        double tolerance = 0.001;
    
        assertEquals(expected.getReal_part(), result.getReal_part(), tolerance);
        assertEquals(expected.getImaginary_part(), result.getImaginary_part(), tolerance);
        
    }
    
    

    @Test
    public void testSqrtComp_PositiveRealAndImaginaryPart() {
        ComplexNumber a = new ComplexNumber(3, 4);
        ComplexNumber expected = new ComplexNumber(2, 1);
        ComplexNumber result = a.sqrtComp(a);
    
        double tolerance = 0.001;
    
        assertEquals(expected.getReal_part(), result.getReal_part(), tolerance);
        assertEquals(expected.getImaginary_part(), result.getImaginary_part(), tolerance);
        
        
    }

    
    @Test
    public void testSqrtComp_NegativeRealAndImaginaryPart() {
        ComplexNumber a = new ComplexNumber(-3, -4);
        ComplexNumber expected = new ComplexNumber(1, -2);
        ComplexNumber result = a.sqrtComp(a);
    
        double tolerance = 0.001;
    
        assertEquals(expected.getReal_part(), result.getReal_part(), tolerance);
        assertEquals(expected.getImaginary_part(), result.getImaginary_part(), tolerance);
    }
    

    /**
     * Test of signInversionComp method, of class ComplexNumber.
    */
    
    @Test
    public void testSignInversionComp_PositiveNumbers() {
        ComplexNumber num = new ComplexNumber(4, 5);
        ComplexNumber result = num.signInversionComp(num);
        assertEquals(new ComplexNumber(-4, -5), result);
    }

    @Test
    public void testSignInversionComp_NegativeNumbers() {
        ComplexNumber num = new ComplexNumber(-4, -5);
        ComplexNumber result = num.signInversionComp(num);
        assertEquals(new ComplexNumber(4, 5), result);
    }

    @Test
    public void testSignInversion_ZeroAsOneOperand() {
        ComplexNumber num = new ComplexNumber(0, 0);
        ComplexNumber result = num.signInversionComp(num);
        assertEquals(new ComplexNumber(0, 0), result);
    }
    
    @Test
    public void testGet(){
        ComplexNumber c = new ComplexNumber(3,5);
        double real= c.getReal_part();
        double im= c.getImaginary_part();
        assertEquals(real, c.getReal_part());
        assertEquals(im, c.getImaginary_part());
        
    }

    //Test costruttore con 2 parametri
    @Test
    public void testComplexNumber_imaginaryNumber(){
        ComplexNumber n1 = new ComplexNumber(3, 4);     //parte reale e imm positive
        ComplexNumber n2 = new ComplexNumber(-2, -9);   //parte reale e imm negative
        ComplexNumber n3 = new ComplexNumber(-1, 7);    //parte reale negativa e imm positiva
        ComplexNumber n4 = new ComplexNumber(3, -5);    //parte reale positiva e imm negativa
        ComplexNumber n5 = new ComplexNumber(0, 4);     //parte reale nulla 
        ComplexNumber n6 = new ComplexNumber(1, 0);     //parte imm nulla
        
        //Controllo se le parti reali sono corrette
        assertEquals(3, n1.getReal_part());
        assertEquals(-2, n2.getReal_part());
        assertEquals(-1, n3.getReal_part());
        assertEquals(3, n4.getReal_part());
        assertEquals(0, n5.getReal_part());
        assertEquals(1, n6.getReal_part());
        
        //Controllo se le parti immaginarie sono corrette
        assertEquals(4, n1.getImaginary_part());
        assertEquals(-9, n2.getImaginary_part());
        assertEquals(7, n3.getImaginary_part());
        assertEquals(-5, n4.getImaginary_part());
        assertEquals(4, n5.getImaginary_part());
        assertEquals(0, n6.getImaginary_part());
        
    }
    
    //Test costruttore con 1 parametro
    @Test
    public void testComplexNumber_realNumber(){
        ComplexNumber n1 = new ComplexNumber(3);     //numero positivo
        ComplexNumber n2 = new ComplexNumber(-2);   //numero negativo
        ComplexNumber n3 = new ComplexNumber(0);    //numero nullo
        
        //Controllo se le parti reali sono corrette
        assertEquals(3, n1.getReal_part());
        assertEquals(-2, n2.getReal_part());
        assertEquals(0, n3.getReal_part());

        
        //Controllo se le parti immaginarie sono corrette
        assertEquals(0, n1.getImaginary_part());
        assertEquals(0, n2.getImaginary_part());
        assertEquals(0, n3.getImaginary_part());

    }
    
}