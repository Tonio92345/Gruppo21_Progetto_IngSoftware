<h1>Calcolatrice Scientifica Basata su uno Stack di Numeri Complessi</h1>
<h2>Panoramica</h2>
Questo progetto è una calcolatrice scientifica basata su uno stack che supporta operazioni con numeri complessi. La calcolatrice è progettata per gestire varie operazioni matematiche e manipolazioni dello stack, fornendo uno strumento robusto per calcoli scientifici e ingegneristici.

<h2>Caratteristiche</h2>
<ul>
    <li><b>Operazioni con Numeri Complessi</b>: addizione, sottrazione, moltiplicazione, divisione e radice quadrata di numeri complessi.</li>
    <li><b>Manipolazione dello Stack</b>: operazioni come push, pop, clear, drop, duplicate, swap e over.</li>
    <li><b>Gestione delle Variabili</b>: salvataggio, recupero e operazioni su variabili.</li>
    <li><b>Gestione degli Errori</b>: gestione appropriata degli errori come input non valido, divisione per zero, variabili non inizializzate e stack vuoto.</li>
</ul>

<h2>Mockup dell'Interfaccia</h2>
<ul>
    <li><b>Tastiera Numerica</b>: per inserire le parti reale e immaginaria dei numeri complessi.</li>
    <li><b>Tastiera delle Variabili</b>: per salvare e utilizzare le variabili.</li>
    <li><b>Pulsanti delle Operazioni</b>: per eseguire operazioni matematiche e di stack.</li>
</ul>

<h2>Architettura</h2>
Il progetto segue un approccio strutturato per garantire scalabilità e manutenibilità.

<h2>Diagramma delle Classi</h2>
Il sistema è composto dalle seguenti classi principali:
<ul>
    <li><b>Calculator</b>: Classe principale che inizializza l'applicazione.</li>
    <li><b>StackComplex</b>: Gestisce lo stack di numeri complessi.</li>
    <li><b>ComplexNumber</b>: Rappresenta i numeri complessi e supporta varie operazioni.</li>
    <li><b>Variables</b>: Gestisce le variabili utilizzate nelle operazioni.</li>
    <li><b>CalculatorController</b>: Gestisce l'input dell'utente e aggiorna l'interfaccia utente.</li>
    <li><b>Exceptions</b>: Eccezioni personalizzate per gestire casi di errore specifici.</li>
</ul>

<h2>Diagramma di Sequenza</h2>
Il diagramma di sequenza illustra il flusso delle operazioni e le interazioni tra l'utente, l'interfaccia e i componenti backend, garantendo una chiara gestione degli errori e delle manipolazioni dello stack.

<h2>Testing</h2>
Il progetto include test completi per garantire funzionalità e affidabilità.
<ul>
    <li><b>Test di ComplexNumber</b>: 32 test superati.</li>
    <li><b>Test di Variables</b>: 24 test superati.</li>
    <li><b>Test di StackComplex</b>: 67 test superati.</li>
    <li><b>Test di CalculatorController</b>: 23 test superati.</li>
</ul>

<h2>Contributori</h2>
<ul>
    <li><b>Francesco Nunziata</b></li>
    <li><b>Antonio Martino</b></li>
    <li><b>Alessandro Pentangelo</b></li>
</ul>
