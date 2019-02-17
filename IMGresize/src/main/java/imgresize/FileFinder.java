/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imgresize;

import datastructure.MyArrayList;
import java.io.File;

/**
 * Class purpose it to traverse local file structure to find images for the user
 * to choose from
 *
 * @author mikko
 */
public class FileFinder {

    //MyArrayList is my own implementation -> datastructure.MyArrayList.java
    MyArrayList<File> list = new MyArrayList<>();
    MyArrayList<String> fileNames = new MyArrayList<>();
    MyArrayList<String> filePath = new MyArrayList<>();

    /**
     * Recursive method to add to fileNames list image files
     *
     * MyArrayList is my own implementation -> datastructure.MyArrayList.java
     *
     * @param directoryName directory where to look for files
     * @param files List of files found
     */
    public void findImageFiles(String directoryName, MyArrayList<File> files) {

        File directory = new File(directoryName);

        File[] fList = directory.listFiles();
        if (fList != null) {
            for (File file : fList) {

                if (file.isFile()) {
                    if (file.toString().endsWith(".png") || file.toString().endsWith(".jpg") || file.toString().endsWith(".jpeg")) {
                        fileNames.add(file.getName());
                        filePath.add(file.getPath());
                    }
                } else if (file.isDirectory()) {
                    findImageFiles(file.getAbsolutePath(), this.list);
                }
            }
        } else {
            System.out.println("No image files present!");
        }
    }

    /**
     * Method to print out file image file names for the user
     */
    public void tulosta() {
        fileNames.forEach(name -> {
            System.out.println(name);
        });
    }

    /**
     * Method finds the path based on given file name
     *
     * This is a really stupid method, since it would be alot easier to
     * implement it with a class variable HashMap, but I couldn't get my own
     * hashmap version working properly so I used two lists I hope are in sync.
     *
     * @param imageFileName name of the image the user wants
     * @return user wanted image's path
     */
    public String getImageFilePath(String imageFileName) {
        int index = 0;

        for (int i = 0; i < fileNames.size(); i++) {
            if (fileNames.get(i).equals(imageFileName)) {
                index = i;
            }
        }
        String path = filePath.get(index);
        return path;
    }
}
