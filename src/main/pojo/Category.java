package main.pojo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

public class Category implements Serializable {
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

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession session1 = sqlSessionFactory.openSession();

//        Category c =new Category();
//        c.setName("一二三四五一二三四五一二三四五一二三四五一二三四五一二三四五一");
//        c.setId(24);
//        Category c2 =new Category();
//        c2.setName("殴打女王ifwin发dddddddddddddddddddddddddddddddddddddddddddddddddd");
//        c2.setId(24);
//        Category c = session.selectOne("getCategory", 3);
//        c.setName("修改了的Category名称");
        //        listAll(session);
//        session.insert("addCategory",c);
//        for (int i = 0; i < 100; i++) {
//            Category c = new Category();
//            c.setName("category name " + i);
//            session.insert("addCategory", c);
//        }
//        session.insert("addCategory",c2);

//        PageHelper.offsetPage(0, 5);
//
//        List<Category> cs = session.selectList("listCategory");
//        for (Category c : cs) {
//            System.out.println(c.getName());
//        }
//
//        PageInfo pageInfo = new PageInfo<>(cs);
//        System.out.println("总数："+pageInfo.getTotal());
//        System.out.println(pageInfo);

//        Category c1 = session1.selectOne("getCategory", 1);
//        System.out.println(c1);
//        Category c2 = session1.selectOne("getCategory", 1);
//        System.out.println(c2);
//        /*事务提交*/
//        session1.commit();
//        session1.close();
//
        SqlSession session = sqlSessionFactory.openSession();
//        Category c3 = session2.selectOne("getCategory", 1);
//        System.out.println(c3);
        List<Category> cs =session.selectList("listCategory");
        for (Category c : cs) {
            System.out.println(c.getName());
        }
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
