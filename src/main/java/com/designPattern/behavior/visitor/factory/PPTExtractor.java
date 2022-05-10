package com.designPattern.behavior.visitor.factory;

public class PPTExtractor implements Extractor{
    @Override
    public void extract2txt(ResourceFile resourceFile) {
        System.out.println("Extract PPT.");
    }
}
