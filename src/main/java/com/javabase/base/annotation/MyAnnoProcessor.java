package com.javabase.base.annotation;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import java.util.Set;
//@AutoService(Processor.class)

/**
 *
 */

@SupportedAnnotationTypes({"com.javabase.base.annotation.MyAnno"})
@SupportedSourceVersion(SourceVersion.RELEASE_11)
public class MyAnnoProcessor extends AbstractProcessor {
    @Override
    public synchronized void init(ProcessingEnvironment env){
        // 主要做一些初始化操作
        System.out.println("MyAnnoProcessor.init !!!!!!!!!!!!");
    }

    @Override
    public boolean process(Set<? extends TypeElement> annoations, RoundEnvironment env) {
        //具体处理注解的逻辑，控制代码的生成
     //   processAnnotations();
        System.out.println("MyAnnoProcessor.process++++++++++++");
        return false;
    }

    /*@Override
    public Set<String> getSupportedAnnotationTypes() {
        // 支持处理的注解类型, 在这里就是@Route

    }*/

   /* @Override
    public SourceVersion getSupportedSourceVersion() {
        //java版本 如：jdk1.6or jdk1.7
    }
*/
}
