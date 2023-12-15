package com.mycompany.progetto_ing_soft.app;

import com.mycompany.progetto_ing_soft.exceptions.*;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;


public class CalculatorController implements Initializable {
    
    private ObservableList<ComplexNumber> stackView;
    private StackComplex implementedStack;
    
    @FXML
    private ListView<ComplexNumber> stack;
    @FXML
    private GridPane variables;
    @FXML
    private Label text;
    @FXML
    private Label error;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        implementedStack = new StackComplex();
        
        stackView = stack.getItems(); 
    }

    @FXML
    private void buttonPressed(ActionEvent event) {
        Button but;
        but = (Button) event.getSource();
        
        if("<x".equals(but.getText())){
            text.setText(text.getText() + "<");
        }else if(">x".equals(but.getText())){
            text.setText(text.getText() + ">");
        }else if("+x".equals(but.getText())){
            text.setText(text.getText() + "+");
        }else if("-x".equals(but.getText())){
            text.setText(text.getText() + "-");
        }else if("DEL".equals(but.getText())){
            text.setText("");
        }else if("ENTER".equals(but.getText())){
            try {
                //Utente inserisce una stringa vuota
                if("".equals(text.getText())){
                    throw new InvalidInputException();
                }
                //Utente inserisc una stringa che inizia col punto
                else if(text.getText().matches("^\\..*")){
                    throw new InvalidInputException();
                }
                //Utente inserisce una stringa contenente i caratteri "*" o "/" errata
                else if(text.getText().matches("^.*[*/].*$") && !text.getText().matches("^[*/]$")){
                    throw new InvalidInputException();
                }
                //Utente inserisce una stringa errata che inizia con un numero (anche se preceduto dal segno)
                else if(text.getText().matches("^([+-])?\\d+.*") && !(text.getText().matches("^([+-])?\\d+(\\.\\d+)?[+-]\\d+(\\.\\d+)?j$")) && !text.getText().matches("^([+-])?\\d+(\\.\\d+)?$")){
                    throw new InvalidInputException();
                }
                //Utente inserisce una stringa errata che inizia con i caratteri "+", "-", "<", ">"
                else if(text.getText().matches("^[<>+-].*") && !(text.getText().matches("^[<>+-]{1}[a-z]$")) && !(text.getText().matches("^\\+-$")) && !(text.getText().matches("^[+-]{1}$")) && !(text.getText().matches("^([+-])?\\d+(\\.\\d+)?[+-]{1}\\d+(\\.\\d+)?j$")) && !(text.getText().matches("^([+-])?\\d+(\\.\\d+)?$"))){
                    throw new InvalidInputException();
                }
                //Utente inserisce una stringa errata contenenete almeno una lettera minuscola(non un numero complesso o un'operazione sulla variabili della calcolatrice) 
                else if(text.getText().matches("^.*[a-z].*$") && !(text.getText().matches("^[<+->][a-z]$")) && !(text.getText().matches("^([+-])?\\d+(\\.\\d+)?[+-]\\d+(\\.\\d+)?j$"))){    
                    throw new InvalidInputException();
                }
                //Utente inserisce una stringa errata contenenete almeno una lettera maiuscola(l'input non è un'operazione di manipolazione dello stack) 
                else if(text.getText().matches(".*[A-Z].*") && !text.getText().matches("^(DROP|DUP|SWAP|SQRT|CLEAR|OVER)$")){
                    throw new InvalidInputException();
                }
                
                error.setText("");
                implementedStack.checkOperation(text.getText(), variables);  //Faccio il checkOperation
                stackView.clear();  //Svuoto la stackView
                for(int i=0; i<implementedStack.getStack().size(); i++){
                    stackView.add(0, implementedStack.getStack().elementAt(i));
                }
                //stackView.addAll(implementedStack.getStack());  //La riempio con lo stack aggiornato
                text.setText("");   //Svuoto l'area di testo
                
            }catch(InvalidInputException e1){
                text.setText("");
                error.setText("ERROR: invalid input");
            }catch(DivisionByZeroException e2){
                text.setText("");
                error.setText("ERROR: division by zero");
            }catch(NotInitializedVarException e3){
                text.setText("");
                error.setText("ERROR: not inizialized variable");
                
            }catch(OneElementStackException e4){
                text.setText("");
                error.setText("ERROR: one element into the stack");
                
            }catch(StackEmptyException e5){
                text.setText("");
                error.setText("ERROR: the stack is empty");   
            } 
        }else{
            text.setText(text.getText() + but.getText());
        }
    }
}
