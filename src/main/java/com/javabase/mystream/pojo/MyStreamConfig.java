package com.javabase.mystream.pojo;

import org.springframework.context.annotation.*;

@Configuration
//@ComponentScan({"com.javabase.mystream"})
/*@ComponentScan(value = "com.javabase.mystream",
        useDefaultFilters = false,
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {MyStreamConfig.class})
        }
)*/

public class MyStreamConfig {
    @Bean
    @Scope("prototype")
    public Pestu pestu() {
        return new Pestu();
    }

    @Bean
    public Pestus pestus() {

        return new Pestus();
    }
}
