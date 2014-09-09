import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class freeDemo {
    public static void main(String[] args) {
        try {
            //创建一个合适的Configration对象
            Configuration configuration = new Configuration();
            configuration.setDirectoryForTemplateLoading(new File("C:\\Users\\由美\\IdeaProjects\\freeMakerDemo\\web\\WEB-INF"));
            configuration.setObjectWrapper(new DefaultObjectWrapper());
            configuration.setDefaultEncoding("UTF-8");   //这个一定要设置，不然在生成的页面中 会乱码
            //获取或创建一个模版。
            Template template = configuration.getTemplate("static.html");
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("description", "Freemarker的第一个demo！");

            List<String> nameList = new ArrayList<String>();
            nameList.add("一代");
            nameList.add("二代");
            nameList.add("三代");
            paramMap.put("nameList", nameList);

            Map<String, Object> weaponMap = new HashMap<String, Object>();
            weaponMap.put("first", "天照");
            weaponMap.put("second", "月读");
            weaponMap.put("third", "神罗天征");
            weaponMap.put("fourth", "万象天引");
            weaponMap.put("fifth", "手里剑");
            weaponMap.put("sixth", "飞鸟");
            weaponMap.put("seventh", null);
            paramMap.put("weaponMap", weaponMap);

            Writer writer  = new OutputStreamWriter(new FileOutputStream("success.html"),"UTF-8");
            template.process(paramMap, writer);

            System.out.println("Finished");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }
}
