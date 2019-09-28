package com.company;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        String content = Files.readString(Paths.get("src/com/company/pyramid"), StandardCharsets.US_ASCII);
        List<String> pyramid = Arrays.asList(content.split(" |\n"));
        List<Integer> pyramidNum = pyramid.stream().map(Integer::parseInt).collect(Collectors.toList());

        BinaryTree binaryTree = new BinaryTree();

        pyramidNum.forEach(n -> binaryTree.add(n));

        binaryTree.getMax(binaryTree.root, 0);

        System.out.println(binaryTree.max);
    }
}
