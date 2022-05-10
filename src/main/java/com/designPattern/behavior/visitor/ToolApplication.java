package com.designPattern.behavior.visitor;

import java.util.ArrayList;
import java.util.List;

public class ToolApplication {
    public static void main(String[] args) {
        List<ResourceFile> resourceFiles = listAllResourceFiles("");

        Visitor extractor = new Extractor();
        for (ResourceFile resourceFile : resourceFiles) {
            resourceFile.accept(extractor);
        }

        Visitor compressor = new Compressor();
        for (ResourceFile resourceFile : resourceFiles) {
            resourceFile.accept(compressor);
        }
    }

    private static List<ResourceFile> listAllResourceFiles(String resourceDirectory) {
        List<ResourceFile> resourceFiles = new ArrayList<>();
        resourceFiles.add(new PdfFile("a.pdf"));
        resourceFiles.add(new PPTFile("b.ppt"));
        resourceFiles.add(new WordFile("c.word"));
        return resourceFiles;
    }
}
