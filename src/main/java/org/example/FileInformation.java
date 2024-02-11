package org.example;

public class FileInformation {

    String fileName;
    String absolutePath;
    long size;
    FileInformation(String inputFileName, String inputAbsolutePath, long inputSize){

        this.fileName = inputFileName;
        this.absolutePath = inputAbsolutePath;
        this.size = inputSize;
    }
}
