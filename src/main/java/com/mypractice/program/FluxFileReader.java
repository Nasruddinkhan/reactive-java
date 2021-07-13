package com.mypractice.program;

import com.mypractice.util.Util;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FluxFileReader {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        Path path = Paths.get("E:\\eclipse-workspace\\springbootppliction-rabbitmq\\reactive-java\\src\\main\\resources\\file3.txt");
        fileReader.read(path)
                //.take(20)
                .subscribe(Util.subscriber());

    }
}
