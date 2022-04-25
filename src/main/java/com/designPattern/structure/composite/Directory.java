package com.designPattern.structure.composite;

import java.util.ArrayList;
import java.util.List;

public class Directory extends FileSystemNode{
    private List<FileSystemNode> subNodes = new ArrayList<>();

    public Directory(String path) {
        super(path);
    }

    @Override
    public int countNumOfFiles() {
        int numOfFiles = 0;
        for (FileSystemNode subNode : subNodes) {
            numOfFiles += subNode.countNumOfFiles();
        }
        return numOfFiles;
    }

    @Override
    public long countSizeOfFiles() {
        long sizeofFiles = 0;
        for (FileSystemNode subNode : subNodes) {
            sizeofFiles += subNode.countSizeOfFiles();
        }
        return sizeofFiles;
    }

    public void addSubNode(FileSystemNode subNode) {
        subNodes.add(subNode);
    }

    public void removeSubNode(FileSystemNode subNode) {
        int size = subNodes.size();
        int i = 0;
        for (; i < size; i++) {
            if (subNodes.get(i).getPath().equalsIgnoreCase(subNode.getPath()))
                break;
        }
        if (i < size)
            subNodes.remove(i);
    }
}
