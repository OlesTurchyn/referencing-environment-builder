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
        this.symbolTable = new SymbolTable();
        this.count = 0;
        this.next = null;

    }

    public Node pushScope() {
        // To be completed

        Node newNode = new Node();
        newNode.next = this;
        return newNode;
    }

    public Node popScope() {
        // To be completed

        if (this.next == null) {
            // Cannot pop the global scope
            return this;
        }
        return this.next;
    }

    public void printCurrentScope() {
        // To be completed

        System.out.println("Current Scope:");
        for (int i = 0; i < symbolTable.MAX_SYMBOLS; i++) {
            if (symbolTable.symbols[i].name != null) {
                System.out.println("Name: " + symbolTable.symbols[i].name +
                        ", Type: " + symbolTable.symbols[i].type +
                        ", Value: " + symbolTable.symbols[i].value);
            }
        }
    }

    public void printAllScopes() {
        // To be completed

        Node currentNode = this;
        while (currentNode != null) {
            currentNode.printCurrentScope();
            currentNode = currentNode.next;
        }
    }

    public void insertSymbol(String symbolType, String symbolName, String symbolValue) {
        // To be completed

        Symbol symbol = new Symbol();
        symbol.name = symbolName;
        symbol.type = symbolType;
        symbol.value = symbolValue;

        if (count < symbolTable.MAX_SYMBOLS) {
            symbolTable.symbols[count++] = symbol;
        } else {
            System.out.println("Error: Symbol table overflow");
        }
    }

    public Symbol symbolExists(String name) {
        // To be completed

        Node currentNode = this;
        while (currentNode != null) {
            for (int i = 0; i < currentNode.symbolTable.MAX_SYMBOLS; i++) {
                if (currentNode.symbolTable.symbols[i].name != null &&
                        currentNode.symbolTable.symbols[i].name.equals(name)) {
                    return currentNode.symbolTable.symbols[i];
                }
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    public Symbol symbolExistsInCurrent(String name) {
        // To be completed

        for (int i = 0; i < symbolTable.MAX_SYMBOLS; i++) {
            if (symbolTable.symbols[i].name != null &&
                    symbolTable.symbols[i].name.equals(name)) {
                return symbolTable.symbols[i];
            }
        }
        return null;
    }

    public void freeEnvironment() {
        // To be completed

        // Clear the current scope
        for (int i = 0; i < symbolTable.MAX_SYMBOLS; i++) {
            symbolTable.symbols[i] = new Symbol();
        }

        // Free the next nodes
        if (next != null) {
            next.freeEnvironment();
        }

        
    }

}
