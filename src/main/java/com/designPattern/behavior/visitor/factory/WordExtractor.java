package com.designPattern.behavior.visitor.factory;

public class WordExtractor implements Extractor{
    @Override
    public void extract2txt(ResourceFile resourceFile) {
        System.out.println("Extract WORD.");
    }
}
