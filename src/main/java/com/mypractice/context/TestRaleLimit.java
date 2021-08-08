package com.mypractice.context;

import com.mypractice.util.Util;
import reactor.util.context.Context;

public class TestRaleLimit {
    public static void main(String[] args) {
        BookService.getBook()
                .repeat(3)
                .contextWrite(UserService.userCategery())
                .contextWrite(Context.of("user","Jalaluddin"))
                .subscribe(Util.subscriber())
        ;
    }
}
