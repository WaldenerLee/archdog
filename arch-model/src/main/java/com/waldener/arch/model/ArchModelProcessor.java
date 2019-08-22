package com.waldener.arch.model;

import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;

/**
 * Created by Waldener on 2019/8/2.
 */
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes("com.waldener.arch.model.ArchModel")
public class ArchModelProcessor extends AbstractProcessor {
    private static final String MODEL_PACKAGE = "com.waldener.arch.model.$model";

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        for (TypeElement typeElement : set) {
            for (Element element : roundEnvironment.getElementsAnnotatedWith(typeElement)){
                ElementHelper elementHelper = new ElementHelper(element);
                int i = 0;
                StringBuilder sb = new StringBuilder("\n");
                for(Element e : processingEnv.getElementUtils().getAllMembers((TypeElement) element)){
                    sb.append(e.getModifiers().toString())
                            .append(" - ")
                            .append(e.getKind().name())
                            .append(" - ")
                            .append(e.getSimpleName().toString())
                            .append(" - ")
                            ;
                    if(e.getKind().isField()){
                        sb.append(" - ")
                                .append(e.asType().toString());
                    }else if(e.getKind() == ElementKind.METHOD){
                        ExecutableElement exe = (ExecutableElement) e;
                        String receive = exe.getReturnType().toString();
                        sb.append(" return: " + receive + " - ");
                        List parameters = exe.getParameters();
                        if(parameters != null){
                            for (VariableElement variableElement : exe.getParameters()){
                                String s = variableElement.getSimpleName().toString();
                                sb.append(" variable: " + variableElement.asType().toString() + " " + s);
                            }
                        }
//                        List typeParameters = exe.getTypeParameters();
//                        if(typeParameters != null){
//                            for(TypeParameterElement tpe: exe.getTypeParameters()){
//                                String s = tpe.asType().toString();
//                                sb.append(" ParameterType: " + s);
//                            }
//                        }
                    }
                    sb.append(", \n");

                }
                String str = sb.toString();

                TypeName typeName = TypeName.get(element.asType());
                String elementClassName = element.getSimpleName().toString();
                String modelClassName = "$" + elementClassName;
                TypeSpec.Builder typeSpecBuilder = TypeSpec.classBuilder(modelClassName)
                        .addModifiers(Modifier.PUBLIC)
                        .superclass(typeName)
                        .addStaticBlock(CodeBlock.builder()
                                .add("String str = $S;\n", str)
                                .build());
                TypeSpec typeSpec = typeSpecBuilder.build();
                JavaFile javaFile = JavaFile.builder(MODEL_PACKAGE, typeSpec).build();
                try {
                    javaFile.writeTo(processingEnv.getFiler());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}
