package com.designPattern.behavior.visitor.factory;

import java.util.HashMap;
import java.util.Map;

public class ExtractorFactory {
    private static final Map<ResourceFileType, Extractor> EXTRACTORS = new HashMap<>();

    static {
        EXTRACTORS.put(ResourceFileType.PDF, new PdfExtractor());
        EXTRACTORS.put(ResourceFileType.PPT, new PPTExtractor());
        EXTRACTORS.put(ResourceFileType.WORD, new WordExtractor());
    }

    public static Extractor getExtractor(ResourceFileType type) {
        return EXTRACTORS.get(type);
    }
}
