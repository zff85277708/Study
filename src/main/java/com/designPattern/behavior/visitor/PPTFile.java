package com.designPattern.behavior.visitor;

public class PPTFile extends ResourceFile{
    public PPTFile(String filePath) {
        super(filePath);
    }
    
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
