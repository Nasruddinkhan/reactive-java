package com.mypractice.mono;

import com.mypractice.util.Util;

public class TestFileService {
    public static void main(String[] args) {
        FileService.read("file1.txt").subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );

        FileService.write("file3.txt", "Hi create new file now").subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );

        FileService.read("file3.txt").subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );

        FileService.delete("file3.txt").subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }
}
