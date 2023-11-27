package analyzer;

class SymbolTable {
    public static final int MAX_SYMBOLS = 100; // Assuming MAX_SYMBOLS is a constant value
    Symbol[] symbols;

    public SymbolTable() {
        this.symbols = new Symbol[MAX_SYMBOLS];
        for (int i = 0; i < MAX_SYMBOLS; i++) {
            this.symbols[i] = new Symbol();
        }
    }
}

public class Node {
    SymbolTable symbolTable;
    int count;
    Node next;

    public Node() {
        // To be completed
    }

    public Node pushScope() {
        // To be completed
    }

    public Node popScope() {
        // To be completed
    }

    public void printCurrentScope() {
        // To be completed
    }

    public void printAllScopes() {
        // To be completed
    }

    public void insertSymbol(String symbolType, String symbolName, String symbolValue) {
        // To be completed
    }

    public Symbol symbolExists(String name) {
        // To be completed
    }

    public Symbol symbolExistsInCurrent(String name) {
        // To be completed
    }

    public void freeEnvironment() {
        // To be completed
    }

}


