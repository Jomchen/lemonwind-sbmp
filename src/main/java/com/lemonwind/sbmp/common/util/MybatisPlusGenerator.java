package com.lemonwind.sbmp.common.util;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.lemonwind.sbmp.entity.JomkieEntity;

/**
 * @Description mybatis 逆躺生成器
 * @author jomkie
 * @since 2022-09-22 15:08:31
 */
public class MybatisPlusGenerator {

    static String url = "jdbc:mysql://127.0.0.1:3306/test?useSSL=false&useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull";
    static String username = "root";
    static String password = "root";
    static String author = "Jomkie";
    static String projectDir = System.getProperty("user.dir");
    static String outputDir = projectDir + "/src/main/java";

    static String parentPath = "com.lemonwind.sbmp";
    static String[] tableArray = {"jo_kong_fu"};
    static String[] prefixToIgnoreArray = {"jo_"};

    public static void main(String[] args) {
        execute();
    }

    public static void execute() {
        FastAutoGenerator.create(url, username, password)

                // 全局配置
                .globalConfig(builder -> {
                    builder.author(author) // 设置作者
                            .enableSwagger()
                            .fileOverride() // 覆盖已生成文件
                            .dateType(DateType.TIME_PACK) // 时间策略
                            .commentDate("yyyy-MM-dd HH:mm:ss") // 注释时间
                            .outputDir(outputDir) // 指定输出目录
                            .author("Jomkie") // 作者
                    ;
                })

                // 包配置
                .packageConfig(builder -> {
                    builder.parent(parentPath) // 设置父包名
//                            .moduleName("system") // 设置父包模块名
                            .entity("entity")
                            .service("service")
                            .serviceImpl("service.impl")
                            .mapper("mapper")
                            .xml("mapper.xml")
//                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, projectPath + parentDir)) // 输出文件到非工程级别路径（操作系统路径）
                    ;
                })


                // 模板配置
                .templateConfig(template -> {
                    template
                            .entity("/mybatis-plus-templates/entity.java")
                            .mapperXml("/mybatis-plus-templates/mapper.xml")
                            .mapper("/mybatis-plus-templates/mapper.java")
                            .serviceImpl("/mybatis-plus-templates/serviceImpl.java")
                            .service("/mybatis-plus-templates/service.java")
                            .controller(null)
                    ;
                })

                // 策略配置
                .strategyConfig(builder -> {
                    builder.addInclude(tableArray) // 设置需要生成的表名
                            .addTablePrefix(prefixToIgnoreArray) // 设置过滤表前缀
                    ;

                    builder.entityBuilder()
                        .superClass(JomkieEntity.class)
                        .enableActiveRecord()
                        .enableLombok()
                        .formatFileName("%s") // 文件输出格式
//                        .enableTableFieldAnnotation()
                        .naming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略
                        .columnNaming(NamingStrategy.underline_to_camel) // 数据库表的字段映射到实体字段的命名策略
                        .addSuperEntityColumns("id", "createTime", "updateTime") // 添加父类公共字段
                    ;

                    builder.mapperBuilder()
                        .superClass(BaseMapper.class)
                        .enableMapperAnnotation()
                        .enableBaseResultMap() // 允许生成基本字段的 resultMap
                        .enableBaseColumnList()
                        .formatMapperFileName("%sMapper")
                        .formatXmlFileName("%sMapper")
                    ;

                    builder.serviceBuilder()
                        .formatServiceFileName("%sService")
                        .formatServiceImplFileName("%sServiceImpl")
                    ;
                })

                // 模板引擎
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

}
