package com.example.swagger2demo;

//import io.github.swagger2markup.GroupBy;
//import io.github.swagger2markup.Language;
//import io.github.swagger2markup.Swagger2MarkupConfig;
//import io.github.swagger2markup.Swagger2MarkupConverter;
//import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
//import io.github.swagger2markup.markup.builder.MarkupLanguage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.net.URL;
import java.nio.file.Paths;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Swagger2demoApplicationTests {

    @Test
    public void contextLoads() throws Exception{
//        createHtmlFile();
    }

//    @Test
//    public void generateAsciiDocsToFile() throws Exception {
//        //    输出Ascii到单文件
//        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
//                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)
//                .withOutputLanguage(Language.ZH)
//                .withPathsGroupedBy(GroupBy.TAGS)
//                .withGeneratedExamples()
//                .withoutInlineSchema()
//                .build();
//
//        Swagger2MarkupConverter.from(new URL("http://localhost:9100/v2/api-docs"))
//                .withConfig(config)
//                .build()
//                .toFile(Paths.get("./docs/asciidoc/generated/all"));
//    }
//
//    /**
//     * 生成Markdown格式文档,并汇总成一个文件
//     * @throws Exception
//     */
//    @Test
//    public void generateMarkdownDocsToFile() throws Exception {
//        //    输出Markdown到单文件
//        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
//                .withMarkupLanguage(MarkupLanguage.MARKDOWN)
//                .withOutputLanguage(Language.ZH)
//                .withPathsGroupedBy(GroupBy.TAGS)
//                .withGeneratedExamples()
//                .withoutInlineSchema()
//                .build();
//
//        Swagger2MarkupConverter.from(new URL("http://localhost:9100/v2/api-docs"))
//                .withConfig(config)
//                .build()
//                .toFile(Paths.get("./docs/markdown/generated/all"));
//    }
//
//    /**
//     * 生成Confluence格式文档
//     * @throws Exception
//     */
//    @Test
//    public void generateConfluenceDocs() throws Exception {
//        //    输出Confluence使用的格式
//        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder()
//                .withMarkupLanguage(MarkupLanguage.CONFLUENCE_MARKUP)
//                .withOutputLanguage(Language.ZH)
//                .withPathsGroupedBy(GroupBy.TAGS)
//                .withGeneratedExamples()
//                .withoutInlineSchema()
//                .build();
//
//        Swagger2MarkupConverter.from(new URL("http://localhost:9100/v2/api-docs"))
//                .withConfig(config)
//                .build()
//                .toFolder(Paths.get("./docs/confluence/generated"));
//    }

//    public Swagger2Markup() throws Exception{
//        createHtmlFile();
//    }

//    /**
//     * 创建html和pdf文件
//     * @throws Exception
//     */
//    public void createHtmlFile() throws Exception{
//        //获取pom.xml的绝对路径
//        String path = returnPath("pom.xml");
//
//        //生成bat文件的内容
//        StringBuilder batFileContent = new StringBuilder(path.substring(0, 2)).append("\r\n");
//        batFileContent.append("cd ").append(path.substring(0,path.length()-7)).append("\r\n");
//        batFileContent.append("mvn test");
//
//        //写入到bat文件
//        writeInBatFile("src/cmd/bat.bat",batFileContent.toString().replace("/", "\\"));
//
//        //生成vbs文件内容
//        StringBuilder vbsFileContent = new StringBuilder("Set ws = CreateObject(\"Wscript.Shell\")").append("\r\n");
//        vbsFileContent.append("ws.run \"cmd /c ").append(returnPath("src/cmd/bat.bat").replace("/", "\\")).append("\",vbhide");
//
//        //写入vbs文件
//        writeInBatFile("src/cmd/vbs.vbs",vbsFileContent.toString());
//
//        //生成执行vbs文件命令(用vbs隐藏bat文件执行时的窗口)
//        StringBuilder cmd = new StringBuilder("cmd /c CScript ").append(returnPath("src/cmd/vbs.vbs"));
//
//        System.out.println(cmd.toString());
//
//        Process process = Runtime.getRuntime().exec(cmd.toString());
//
//        System.out.println(process.waitFor());
//    }
//    /**
//     * 生成文件
//     * @param content
//     */
//    public void writeInBatFile(String fileName,String content){
//        File batFile = new File(returnPath(fileName));
//        //如果文件存在，则删除
//        if(batFile != null && batFile.exists()){
//            batFile.delete();
//        }
//        try {
//            //创建gbk格式的文件（utf-8中文在cmd里乱码）
//            OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(batFile),"GBK");
//            BufferedWriter bw = new BufferedWriter(out);
//            bw.write(content);
//            bw.close();
//            out.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    /**
//     * 获取指定文件路径
//     * @param filePath
//     * @return
//     */
//    public String returnPath(String filePath){
//        return Paths.get(filePath).toAbsolutePath().toString();
//    }
//    public static void main(String[] args) throws Exception{
//        new Swagger2Markup();
//    }


}
