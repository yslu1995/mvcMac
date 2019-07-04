package main.pojo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Category {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

        Category c =new Category();
        c.setName("殴打女王ifwin发");
        c.setId(23);
        Category c2 =new Category();
        c2.setName("殴打女王ifwin发dddddddddddddddddddddddddddddddddddddddddddddddddd");
        c2.setId(24);
//        Category c = session.selectOne("getCategory", 3);
//        c.setName("修改了的Category名称");
        //        listAll(session);
        session.insert("addCategory",c);
        session.insert("addCategory",c2);

        /*事务提交*/
        session.commit();
        session.close();

    }
    private static void listAll(SqlSession session) {
        List<Category> cs = session.selectList("listCategory");
        for (Category c : cs) {
            System.out.println(c.getName());
        }
    }
}
