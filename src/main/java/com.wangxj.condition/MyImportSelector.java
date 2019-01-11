package com.wangxj.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector{
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        System.out.println("一只小猫咪");
        return new String[]{"com.wangxj.entity.Blue","com.wangxj.entity.Yellow"};
    }
}
