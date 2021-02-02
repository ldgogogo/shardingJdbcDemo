package com.ld.mpdemo.codeGenerator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

public class SggCodeGenerator {

    public static void main(String[] args) {
        //生成的实体、controller、service、mapper等文件的位置
        String packagePos = "com.ld.mpdemo.shardingTest";
        //生成mapper.xml文件的位置
        String mapperXmlPos = "/src/main/resources/mybatisplus/shardingTest/";
        //表名
        String tableName = "sharding_test";
        //被消除的前缀
        String removedPrefix = "";
        //执行代码生成方法
        codeGenerator(packagePos, mapperXmlPos, tableName, removedPrefix);
    }

    /**
     * <p>代码生成</p>
     *
     * @param
     * @return:
     * @author: ld
     * @date: 2020/12/16 14:45
     */
    public static void codeGenerator(String packagePos, String mapperXmlPos, String tableName, String removedPrefix) {

        // 1、创建生成器
        AutoGenerator mpg = new AutoGenerator();

        // 2、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("ld");
        gc.setOpen(false); //生成后是否打开资源管理器
        gc.setFileOverride(false); //重新生成时文件是否覆盖
        gc.setServiceName("%sService"); //去掉Service接口的首字母I
        gc.setIdType(IdType.ID_WORKER_STR); //主键策略
        gc.setDateType(DateType.ONLY_DATE);//定义生成的实体类中日期类型
        gc.setSwagger2(false);//开启Swagger2模式
        mpg.setGlobalConfig(gc);

        // 3、数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/master?serverTimezone=GMT%2B8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        // 4、包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(null); //模块名
        pc.setParent(packagePos);// pc.setParent("com.lz.oms.system")
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);
        // 4.1、自定义mapper.xml文件的输出位置
        TemplateConfig tc = new TemplateConfig();// 关闭默认 xml 生成，调整生成 至 根目录
        tc.setXml(null);
        mpg.setTemplate(tc);
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return projectPath + mapperXmlPos + tableInfo.getXmlName() + ".xml";// mapperXmlPos="/src/main/resources/mybatisplus/system/"
            }
        });
        // 注入配置， 该配置不在代码中配置出来的话，则生该自动生成的文件不会生成对应的文件！！！！
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 5、策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude(tableName);//对那一张表生成代码 tableName = "t_user"
        strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略
        strategy.setTablePrefix(removedPrefix);//removedPrefix = "t_"
        //strategy.setTablePrefix(pc.getModuleName() + "t_"); //生成实体时去掉表前缀

        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//数据库表字段映射到实体的命名策略
        strategy.setEntityLombokModel(true); // lombok 模型 @Accessors(chain = true) setter链式操作
        strategy.setRestControllerStyle(true); //restful api风格控制器
        strategy.setControllerMappingHyphenStyle(false); //url中驼峰转连字符

        mpg.setStrategy(strategy);

        // 6、执行
        mpg.execute();
    }
}