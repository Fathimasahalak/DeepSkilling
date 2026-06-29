package DesignPatterns.exercise2;

public class Main {
    public static void main(String[] args) {
        DocumentFactory factory;

        factory = new WordDocumentFactory();
        factory.openDocument();

        factory = new PdfDocumentFactory();
        factory.openDocument();

        factory = new ExcelDocumentFactory();
        factory.openDocument();
    }
}
