package club.sdll.codegenerator;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * mybatis 代码生成器
 *
 * 参考博客：
 * 1. https://liuzh.blog.csdn.net/article/details/42102297
 * 2. https://deecyn.gitee.io/notes/doc/javaweb/mybatis/mybatis-generator-config.html
 * 3. https://segmentfault.com/a/1190000016525887
 *
 *
 * @author 草薙
 */
@Slf4j
public class App {


    public static void main(String[] args) {
        try {
            System.out.println("Hello World!");
            List<String> warnings = new ArrayList<>();
            // 如果已经存在生成过的文件是否进行覆盖
            boolean overwrite = true;
            InputStream resourceAsStream = App.class.getResourceAsStream("/generatorConfig.xml");
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(resourceAsStream);

            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator generator = new MyBatisGenerator(config, callback, warnings);
            generator.generate(null);
            //输出警告信息
            for (String warning : warnings) {
                System.out.println(warning);
            }
        } catch (Exception e) {
            System.out.println("异常");
        }
        System.out.println("结束");
    }
}
