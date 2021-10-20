package ru.az.doverie;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class AppSpring {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(AppSpring.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }

}
