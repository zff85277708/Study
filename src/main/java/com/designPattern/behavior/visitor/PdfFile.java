package com.designPattern.behavior.visitor;

public class PdfFile extends ResourceFile{
    public PdfFile(String filePath) {
        super(filePath);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
