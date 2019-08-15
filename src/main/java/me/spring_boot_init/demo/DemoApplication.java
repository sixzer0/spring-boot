package me.spring_boot_init.demo;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import javax.sql.DataSource;

//pom.xml -> controller를 만든다(매핑 매소드 만든다) -> 서비스 -> dao(매퍼랑 연결이 된다)
//controller uri이랑 mapping 해줌

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    //factory는 template을 만들기 위한 설정 객체
    //
    @Bean //어디서든 쓸 수 있도록 bean에 등록
    //factory를 만들려면 db에 대한 정보 하나
    //domian에 대한 정보 하나, 자바는 테이블을 쓸 때 데이터를 저장할 도메인이 필요하다. 1:1 매칭할 클래스가 도메인
    //map으로 담을 수 있으나, 그렇게 하면 정해진 틀 없음..
    //
    public SqlSessionFactory sqlSessionFactory(DataSource datasource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource((javax.sql.DataSource) datasource);
        sqlSessionFactory.setTypeAliasesPackage("me.spring_boot_init.demo.domain");
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*.xml"));
        return sqlSessionFactory.getObject(); //factory를 만들어가지고 bean에 등록
    }

    @Bean
    public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
