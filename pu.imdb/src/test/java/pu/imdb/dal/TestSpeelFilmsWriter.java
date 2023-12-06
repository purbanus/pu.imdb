package pu.imdb.dal;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Data;

@SpringBootTest
@Data
public class TestSpeelFilmsWriter
{
//public static String SPEELFILM_LISTING = "/speelfilms listing 2023-10-19 - 10 regels.txt";
public static String SPEELFILM_LISTING = "/speelfilms listing 2023-10-19.txt";
public static String SPEELFILMS_AT_NAS4 = "/home/purbanus/Videos/speelfilms";
public static String SPEELFILMS_AT_5TB = "/media/purbanus/5TB Seagate/Videos/nas4";

@Autowired private SpeelFilmsWriter speelFilmsWriter;

@Test
public void testWriteSpeelFilm() throws IOException
{
	SpeelfilmFileWalker walker = new SpeelfilmFileWalker( SPEELFILMS_AT_5TB, 2 );
	walker.run();
	List<SpeelFilm> speelFilms = walker.getSpeelFilms();
	getSpeelFilmsWriter().writeSpeelFilm( speelFilms.get( 0 ) );
}

@Test
public void testWriteSpeelFilms() throws IOException
{
	SpeelfilmFileWalker walker = new SpeelfilmFileWalker( SPEELFILMS_AT_5TB, 2 );
	walker.run();
	List<SpeelFilm> speelFilms = walker.getSpeelFilms();
	getSpeelFilmsWriter().writeSpeelFilms( speelFilms );
}

}
/**
 * 938: java_class_path (initial): 
 * /home/purbanus/projecten/workspaces/sts4.12.1/pu.imdb/target/test-classes:
 * /home/purbanus/projecten/workspaces/sts4.12.1/pu.imdb/target/classes:
 * /home/purbanus/projecten/workspaces/sts4.12.1/base.java/bintest:
 * /home/purbanus/projecten/workspaces/sts4.12.1/base.java/bin:
 * /home/purbanus/prog/eclipse/sts-4.18.0.RELEASE/plugins/org.junit_4.13.2.v20211018-1956.jar:
 * /home/purbanus/prog/eclipse/sts-4.18.0.RELEASE/plugins/org.hamcrest.core_1.3.0.v20180420-1519.jar:
 * /home/purbanus/projecten/workspaces/sts4.12.1/alg.lib/lib/iris-standaard/jt400-8.6.jar:
 * /home/purbanus/.ivy2/cache/org.springframework/spring-aop/jars/spring-aop-5.3.24.jar:
 * /home/purbanus/.ivy2/cache/org.springframework/spring-beans/jars/spring-beans-5.3.24.jar:
 * /home/purbanus/.ivy2/cache/org.springframework/spring-context/jars/spring-context-5.3.24.jar:
 * /home/purbanus/.ivy2/cache/org.springframework/spring-context-support/jars/spring-context-support-5.3.24.jar:
 * /home/purbanus/.ivy2/cache/org.springframework/spring-core/jars/spring-core-5.3.24.jar:
 * /home/purbanus/.ivy2/cache/org.springframework/spring-expression/jars/spring-expression-5.3.24.jar:
 * /home/purbanus/.ivy2/cache/org.springframework/spring-jdbc/jars/spring-jdbc-5.3.24.jar:
 * /home/purbanus/.ivy2/cache/org.springframework/spring-test/jars/spring-test-5.3.24.jar:
 * /home/purbanus/.ivy2/cache/org.springframework/spring-tx/jars/spring-tx-5.3.24.jar:
 * /home/purbanus/.ivy2/cache/org.apache.velocity/velocity/jars/velocity-1.7.jar:
 * /home/purbanus/.ivy2/cache/org.apache.velocity/velocity-tools/jars/velocity-tools-2.0.jar:
 * /home/purbanus/.ivy2/cache/org.mybatis/mybatis/jars/mybatis-3.3.0.jar:
 * /home/purbanus/.ivy2/cache/org.mybatis/mybatis-spring/jars/mybatis-spring-1.2.3.jar:
 * /home/purbanus/.ivy2/cache/org.mybatis.generator/mybatis-generator-core/jars/mybatis-generator-core-1.3.2.jar:
 * /home/purbanus/.ivy2/cache/org.hsqldb/hsqldb/jars/hsqldb-2.3.3.jar:
 * /home/purbanus/.ivy2/cache/org.hibernate/hibernate-core/jars/hibernate-core-4.3.6.Final.jar:
 * /home/purbanus/.ivy2/cache/org.slf4j/slf4j-api/jars/slf4j-api-1.7.21.jar:
 * /home/purbanus/.ivy2/cache/org.slf4j/jcl-over-slf4j/jars/jcl-over-slf4j-1.7.21.jar:
 * /home/purbanus/.ivy2/cache/org.slf4j/slf4j-log4j12/jars/slf4j-log4j12-1.7.21.jar:
 * /home/purbanus/.ivy2/cache/log4j/log4j/bundles/log4j-1.2.17.jar:
 * /home/purbanus/.ivy2/cache/commons-httpclient/commons-httpclient/jars/commons-httpclient-3.1.jar:
 * /home/purbanus/.ivy2/cache/org.easymock/easymock/jars/easymock-3.4.jar:
 * /home/purbanus/.ivy2/cache/org.jdom/jdom2/jars/jdom2-2.0.6.jar:
 * /home/purbanus/.ivy2/cache/org.glassfish.corba/glassfish-corba-omgapi/jars/glassfish-corba-omgapi-4.2.1.jar:
 * /home/purbanus/.ivy2/cache/net.schmizz/sshj/bundles/sshj-0.9.0.jar:
 * /home/purbanus/.ivy2/cache/org.springframework.ws/spring-ws-core/jars/spring-ws-core-2.2.0.RELEASE.jar:
 * /opt/tomcat9/lib/tomcat-i18n-es.jar:
 * /opt/tomcat9/lib/tomcat-i18n-ko.jar:
 * /opt/tomcat9/lib/catalina-tribes.jar:
 * /opt/tomcat9/lib/tomcat-util-scan.jar:
 * /opt/tomcat9/lib/jaspic-api.jar:
 * /opt/tomcat9/lib/jsp-api.jar:
 * /opt/tomcat9/lib/tomcat-util.jar:
 * /opt/tomcat9/lib/tomcat-i18n-fr.jar:
 * /opt/tomcat9/lib/catalina-storeconfig.jar:
 * /opt/tomcat9/lib/tomcat-i18n-de.jar:
 * /opt/tomcat9/lib/tomcat-websocket.jar:
 * /opt/tomcat9/lib/jasper.jar:
 * /opt/tomcat9/lib/tomcat-api.jar:
 * /opt/tomcat9/lib/tomcat-coyote.jar:
 * /opt/tomcat9/lib/tomcat-i18n-cs.jar:
 * /opt/tomcat9/lib/annotations-api.jar:
 * /opt/tomcat9/lib/tomcat-i18n-ja.jar:
 * /opt/tomcat9/lib/tomcat-jdbc.jar:
 * /opt/tomcat9/lib/ecj-4.20.jar:
 * /opt/tomcat9/lib/tomcat-i18n-zh-CN.jar:
 * /opt/tomcat9/lib/websocket-api.jar:
 * /opt/tomcat9/lib/jasper-el.jar:
 * /opt/tomcat9/lib/tomcat-i18n-ru.jar:
 * /opt/tomcat9/lib/servlet-api.jar:
 * /opt/tomcat9/lib/catalina-ssi.jar:
 * /opt/tomcat9/lib/el-api.jar:
 * /opt/tomcat9/lib/catalina.jar:
 * /opt/tomcat9/lib/catalina-ha.jar:
 * /opt/tomcat9/lib/tomcat-i18n-pt-BR.jar:
 * /opt/tomcat9/lib/tomcat-dbcp.jar:
 * /opt/tomcat9/lib/tomcat-jni.jar:
 * /opt/tomcat9/lib/catalina-ant.jar:
 * /home/purbanus/.m2/repository/org/springframework/boot/spring-boot-starter/3.1.4/spring-boot-starter-3.1.4.jar:
 * /home/purbanus/.m2/repository/org/springframework/boot/spring-boot/3.1.4/spring-boot-3.1.4.jar:
 * /home/purbanus/.m2/repository/org/springframework/spring-context/6.0.12/spring-context-6.0.12.jar:
 * /home/purbanus/.m2/repository/org/springframework/boot/spring-boot-autoconfigure/3.1.4/spring-boot-autoconfigure-3.1.4.jar:
 * /home/purbanus/.m2/repository/org/springframework/boot/spring-boot-starter-logging/3.1.4/spring-boot-starter-logging-3.1.4.jar:
 * /home/purbanus/.m2/repository/ch/qos/logback/logback-classic/1.4.11/logback-classic-1.4.11.jar:
 * /home/purbanus/.m2/repository/ch/qos/logback/logback-core/1.4.11/logback-core-1.4.11.jar:
 * /home/purbanus/.m2/repository/org/apache/logging/log4j/log4j-to-slf4j/2.20.0/log4j-to-slf4j-2.20.0.jar:
 * /home/purbanus/.m2/repository/org/apache/logging/log4j/log4j-api/2.20.0/log4j-api-2.20.0.jar:
 * /home/purbanus/.m2/repository/org/slf4j/jul-to-slf4j/2.0.9/jul-to-slf4j-2.0.9.jar:
 * /home/purbanus/.m2/repository/jakarta/annotation/jakarta.annotation-api/2.1.1/jakarta.annotation-api-2.1.1.jar:
 * /home/purbanus/.m2/repository/org/springframework/spring-core/6.0.12/spring-core-6.0.12.jar:
 * /home/purbanus/.m2/repository/org/springframework/spring-jcl/6.0.12/spring-jcl-6.0.12.jar:
 * /home/purbanus/.m2/repository/org/yaml/snakeyaml/1.33/snakeyaml-1.33.jar:
 * /home/purbanus/.m2/repository/org/springframework/boot/spring-boot-starter-data-jdbc/3.1.4/spring-boot-starter-data-jdbc-3.1.4.jar:
 * /home/purbanus/.m2/repository/org/springframework/boot/spring-boot-starter-jdbc/3.1.4/spring-boot-starter-jdbc-3.1.4.jar:
 * /home/purbanus/.m2/repository/com/zaxxer/HikariCP/5.0.1/HikariCP-5.0.1.jar:
 * /home/purbanus/.m2/repository/org/springframework/spring-jdbc/6.0.12/spring-jdbc-6.0.12.jar:
 * /home/purbanus/.m2/repository/org/springframework/data/spring-data-jdbc/3.1.4/spring-data-jdbc-3.1.4.jar:
 * /home/purbanus/.m2/repository/org/springframework/data/spring-data-relational/3.1.4/spring-data-relational-3.1.4.jar:
 * /home/purbanus/.m2/repository/org/springframework/data/spring-data-commons/3.1.4/spring-data-commons-3.1.4.jar:/home/purbanus/.m2/repository/org/springframework/spring-tx/6.0.12/spring-tx-6.0.12.jar:/home/purbanus/.m2/repository/org/springframework/spring-beans/6.0.12/spring-beans-6.0.12.jar:/home/purbanus/.m2/repository/org/slf4j/slf4j-api/2.0.9/slf4j-api-2.0.9.jar:/home/purbanus/.m2/repository/org/springframework/boot/spring-boot-starter-data-jpa/3.1.4/spring-boot-starter-data-jpa-3.1.4.jar:/home/purbanus/.m2/repository/org/springframework/boot/spring-boot-starter-aop/3.1.4/spring-boot-starter-aop-3.1.4.jar:/home/purbanus/.m2/repository/org/springframework/spring-aop/6.0.12/spring-aop-6.0.12.jar:/home/purbanus/.m2/repository/org/aspectj/aspectjweaver/1.9.20/aspectjweaver-1.9.20.jar:/home/purbanus/.m2/repository/org/hibernate/orm/hibernate-core/6.2.9.Final/hibernate-core-6.2.9.Final.jar:/home/purbanus/.m2/repository/jakarta/persistence/jakarta.persistence-api/3.1.0/jakarta.persistence-api-3.1.0.jar:/home/purbanus/.m2/repository/jakarta/transaction/jakarta.transaction-api/2.0.1/jakarta.transaction-api-2.0.1.jar:/home/purbanus/.m2/repository/org/jboss/logging/jboss-logging/3.5.3.Final/jboss-logging-3.5.3.Final.jar:/home/purbanus/.m2/repository/org/hibernate/common/hibernate-commons-annotations/6.0.6.Final/hibernate-commons-annotations-6.0.6.Final.jar:/home/purbanus/.m2/repository/io/smallrye/jandex/3.0.5/jandex-3.0.5.jar:/home/purbanus/.m2/repository/com/fasterxml/classmate/1.5.1/classmate-1.5.1.jar:/home/purbanus/.m2/repository/net/bytebuddy/byte-buddy/1.14.8/byte-buddy-1.14.8.jar:/home/purbanus/.m2/repository/org/glassfish/jaxb/jaxb-runtime/4.0.3/jaxb-runtime-4.0.3.jar:/home/purbanus/.m2/repository/org/glassfish/jaxb/jaxb-core/4.0.3/jaxb-core-4.0.3.jar:/home/purbanus/.m2/repository/org/glassfish/jaxb/txw2/4.0.3/txw2-4.0.3.jar:/home/purbanus/.m2/repository/com/sun/istack/istack-commons-runtime/4.1.2/istack-commons-runtime-4.1.2.jar:/home/purbanus/.m2/repository/jakarta/inject/jakarta.inject-api/2.0.1/jakarta.inject-api-2.0.1.jar:/home/purbanus/.m2/repository/org/antlr/antlr4-runtime/4.10.1/antlr4-runtime-4.10.1.jar:/home/purbanus/.m2/repository/org/springframework/data/spring-data-jpa/3.1.4/spring-data-jpa-3.1.4.jar:/home/purbanus/.m2/repository/org/springframework/spring-orm/6.0.12/spring-orm-6.0.12.jar:/home/purbanus/.m2/repository/org/springframework/spring-aspects/6.0.12/spring-aspects-6.0.12.jar:/home/purbanus/.m2/repository/com/h2database/h2/2.1.214/h2-2.1.214.jar:/home/purbanus/.m2/repository/org/postgresql/postgresql/42.6.0/postgresql-42.6.0.jar:/home/purbanus/.m2/repository/org/checkerframework/checker-qual/3.31.0/checker-qual-3.31.0.jar:/home/purbanus/.m2/repository/org/springframework/boot/spring-boot-starter-freemarker/3.1.4/spring-boot-starter-freemarker-3.1.4.jar:/home/purbanus/.m2/repository/org/freemarker/freemarker/2.3.32/freemarker-2.3.32.jar:/home/purbanus/.m2/repository/org/springframework/spring-context-support/6.0.12/spring-context-support-6.0.12.jar:/home/purbanus/.m2/repository/no/api/freemarker/freemarker-java8/2.0.0/freemarker-java8-2.0.0.jar:/home/purbanus/.m2/repository/org/springframework/boot/spring-boot-starter-validation/3.1.4/spring-boot-starter-validation-3.1.4.jar:/home/purbanus/.m2/repository/org/apache/tomcat/embed/tomcat-embed-el/10.1.13/tomcat-embed-el-10.1.13.jar:/home/purbanus/.m2/repository/org/hibernate/validator/hibernate-validator/8.0.1.Final/hibernate-validator-8.0.1.Final.jar:/home/purbanus/.m2/repository/jakarta/validation/jakarta.validation-api/3.0.2/jakarta.validation-api-3.0.2.jar:/home/purbanus/.m2/repository/org/springframework/boot/spring-boot-starter-web/3.1.4/spring-boot-starter-web-3.1.4.jar:/home/purbanus/.m2/repository/org/springframework/boot/spring-boot-starter-json/3.1.4/spring-boot-starter-json-3.1.4.jar:/home/purbanus/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.15.2/jackson-databind-2.15.2.jar:/home/purbanus/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.15.2/jackson-annotations-2.15.2.jar:/home/purbanus/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.15.2/jackson-core-2.15.2.jar:/home/purbanus/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jdk8/2.15.2/jackson-datatype-jdk8-2.15.2.jar:/home/purbanus/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jsr310/2.15.2/jackson-datatype-jsr310-2.15.2.jar:/home/purbanus/.m2/repository/com/fasterxml/jackson/module/jackson-module-parameter-names/2.15.2/jackson-module-parameter-names-2.15.2.jar:/home/purbanus/.m2/repository/org/springframework/boot/spring-boot-starter-tomcat/3.1.4/spring-boot-starter-tomcat-3.1.4.jar:/home/purbanus/.m2/repository/org/apache/tomcat/embed/tomcat-embed-core/10.1.13/tomcat-embed-core-10.1.13.jar:/home/purbanus/.m2/repository/org/apache/tomcat/embed/tomcat-embed-websocket/10.1.13/tomcat-embed-websocket-10.1.13.jar:/home/purbanus/.m2/repository/org/springframework/spring-web/6.0.12/spring-web-6.0.12.jar:/home/purbanus/.m2/repository/org/springframework/spring-webmvc/6.0.12/spring-webmvc-6.0.12.jar:/home/purbanus/.m2/repository/org/springframework/spring-expression/6.0.12/spring-expression-6.0.12.jar:/home/purbanus/.m2/repository/org/springframework/boot/spring-boot-devtools/3.1.4/spring-boot-devtools-3.1.4.jar:/home/purbanus/.m2/repository/org/springframework/boot/spring-boot-starter-test/3.1.4/spring-boot-starter-test-3.1.4.jar:/home/purbanus/.m2/repository/org/springframework/boot/spring-boot-test/3.1.4/spring-boot-test-3.1.4.jar:/home/purbanus/.m2/repository/org/springframework/boot/spring-boot-test-autoconfigure/3.1.4/spring-boot-test-autoconfigure-3.1.4.jar:/home/purbanus/.m2/repository/com/jayway/jsonpath/json-path/2.8.0/json-path-2.8.0.jar:/home/purbanus/.m2/repository/jakarta/xml/bind/jakarta.xml.bind-api/4.0.1/jakarta.xml.bind-api-4.0.1.jar:/home/purbanus/.m2/repository/jakarta/activation/jakarta.activation-api/2.1.2/jakarta.activation-api-2.1.2.jar:/home/purbanus/.m2/repository/net/minidev/json-smart/2.4.11/json-smart-2.4.11.jar:/home/purbanus/.m2/repository/net/minidev/accessors-smart/2.4.11/accessors-smart-2.4.11.jar:/home/purbanus/.m2/repository/org/ow2/asm/asm/9.3/asm-9.3.jar:/home/purbanus/.m2/repository/org/assertj/assertj-core/3.24.2/assertj-core-3.24.2.jar:/home/purbanus/.m2/repository/org/hamcrest/hamcrest/2.2/hamcrest-2.2.jar:/home/purbanus/.m2/repository/org/junit/jupiter/junit-jupiter/5.9.3/junit-jupiter-5.9.3.jar:/home/purbanus/.m2/repository/org/junit/jupiter/junit-jupiter-api/5.9.3/junit-jupiter-api-5.9.3.jar:/home/purbanus/.m2/repository/org/opentest4j/opentest4j/1.2.0/opentest4j-1.2.0.jar:/home/purbanus/.m2/repository/org/junit/platform/junit-platform-commons/1.9.3/junit-platform-commons-1.9.3.jar:/home/purbanus/.m2/repository/org/apiguardian/apiguardian-api/1.1.2/apiguardian-api-1.1.2.jar:/home/purbanus/.m2/repository/org/junit/jupiter/junit-jupiter-params/5.9.3/junit-jupiter-params-5.9.3.jar:/home/purbanus/.m2/repository/org/junit/jupiter/junit-jupiter-engine/5.9.3/junit-jupiter-engine-5.9.3.jar:/home/purbanus/.m2/repository/org/junit/platform/junit-platform-engine/1.9.3/junit-platform-engine-1.9.3.jar:/home/purbanus/.m2/repository/org/mockito/mockito-core/5.3.1/mockito-core-5.3.1.jar:/home/purbanus/.m2/repository/net/bytebuddy/byte-buddy-agent/1.14.8/byte-buddy-agent-1.14.8.jar:/home/purbanus/.m2/repository/org/objenesis/objenesis/3.3/objenesis-3.3.jar:/home/purbanus/.m2/repository/org/mockito/mockito-junit-jupiter/5.3.1/mockito-junit-jupiter-5.3.1.jar:/home/purbanus/.m2/repository/org/skyscreamer/jsonassert/1.5.1/jsonassert-1.5.1.jar:/home/purbanus/.m2/repository/com/vaadin/external/google/android-json/0.0.20131108.vaadin1/android-json-0.0.20131108.vaadin1.jar:/home/purbanus/.m2/repository/org/springframework/spring-test/6.0.12/spring-test-6.0.12.jar:/home/purbanus/.m2/repository/org/xmlunit/xmlunit-core/2.9.1/xmlunit-core-2.9.1.jar:/home/purbanus/.m2/repository/org/springframework/boot/spring-boot-starter-mail/3.1.4/spring-boot-starter-mail-3.1.4.jar:/home/purbanus/.m2/repository/org/eclipse/angus/jakarta.mail/1.1.0/jakarta.mail-1.1.0.jar:/home/purbanus/.m2/repository/org/eclipse/angus/angus-activation/2.0.1/angus-activation-2.0.1.jar:/home/purbanus/.m2/repository/org/springframework/boot/spring-boot-starter-actuator/3.1.4/spring-boot-starter-actuator-3.1.4.jar:/home/purbanus/.m2/repository/org/springframework/boot/spring-boot-actuator-autoconfigure/3.1.4/spring-boot-actuator-autoconfigure-3.1.4.jar:/home/purbanus/.m2/repository/org/springframework/boot/spring-boot-actuator/3.1.4/spring-boot-actuator-3.1.4.jar:/home/purbanus/.m2/repository/io/micrometer/micrometer-observation/1.11.4/micrometer-observation-1.11.4.jar:/home/purbanus/.m2/repository/io/micrometer/micrometer-commons/1.11.4/micrometer-commons-1.11.4.jar:/home/purbanus/.m2/repository/io/micrometer/micrometer-core/1.11.4/micrometer-core-1.11.4.jar:/home/purbanus/.m2/repository/org/hdrhistogram/HdrHistogram/2.1.12/HdrHistogram-2.1.12.jar:/home/purbanus/.m2/repository/org/latencyutils/LatencyUtils/2.0.3/LatencyUtils-2.0.3.jar:/home/purbanus/.m2/repository/org/springframework/boot/spring-boot-configuration-processor/3.1.4/spring-boot-configuration-processor-3.1.4.jar:/home/purbanus/.m2/repository/org/projectlombok/lombok/1.18.30/lombok-1.18.30.jar:/home/purbanus/.m2/repository/org/seleniumhq/selenium/htmlunit-driver/4.8.3/htmlunit-driver-4.8.3.jar:/home/purbanus/.m2/repository/org/seleniumhq/selenium/selenium-api/4.8.3/selenium-api-4.8.3.jar:/home/purbanus/.m2/repository/org/seleniumhq/selenium/selenium-support/4.8.3/selenium-support-4.8.3.jar:/home/purbanus/.m2/repository/com/google/auto/service/auto-service-annotations/1.0.1/auto-service-annotations-1.0.1.jar:/home/purbanus/.m2/repository/com/google/auto/service/auto-service/1.0.1/auto-service-1.0.1.jar:/home/purbanus/.m2/repository/com/google/auto/auto-common/1.2/auto-common-1.2.jar:/home/purbanus/.m2/repository/com/google/guava/guava/31.1-jre/guava-31.1-jre.jar:/home/purbanus/.m2/repository/com/google/guava/failureaccess/1.0.1/failureaccess-1.0.1.jar:/home/purbanus/.m2/repository/com/google/guava/listenablefuture/9999.0-empty-to-avoid-conflict-with-guava/listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar:/home/purbanus/.m2/repository/com/google/code/findbugs/jsr305/3.0.2/jsr305-3.0.2.jar:/home/purbanus/.m2/repository/com/google/errorprone/error_prone_annotations/2.11.0/error_prone_annotations-2.11.0.jar:/home/purbanus/.m2/repository/com/google/j2objc/j2objc-annotations/1.3/j2objc-annotations-1.3.jar:/home/purbanus/.m2/repository/org/seleniumhq/selenium/selenium-json/4.8.3/selenium-json-4.8.3.jar:/home/purbanus/.m2/repository/org/seleniumhq/selenium/selenium-remote-driver/4.8.3/selenium-remote-driver-4.8.3.jar:/home/purbanus/.m2/repository/com/beust/jcommander/1.82/jcommander-1.82.jar:/home/purbanus/.m2/repository/io/netty/netty-buffer/4.1.97.Final/netty-buffer-4.1.97.Final.jar:/home/purbanus/.m2/repository/io/netty/netty-codec-http/4.1.97.Final/netty-codec-http-4.1.97.Final.jar:/home/purbanus/.m2/repository/io/netty/netty-codec/4.1.97.Final/netty-codec-4.1.97.Final.jar:/home/purbanus/.m2/repository/io/netty/netty-handler/4.1.97.Final/netty-handler-4.1.97.Final.jar:/home/purbanus/.m2/repository/io/netty/netty-common/4.1.97.Final/netty-common-4.1.97.Final.jar:/home/purbanus/.m2/repository/io/netty/netty-transport-classes-epoll/4.1.97.Final/netty-transport-classes-epoll-4.1.97.Final.jar:/home/purbanus/.m2/repository/io/netty/netty-transport-classes-kqueue/4.1.97.Final/netty-transport-classes-kqueue-4.1.97.Final.jar:/home/purbanus/.m2/repository/io/netty/netty-transport-native-epoll/4.1.97.Final/netty-transport-native-epoll-4.1.97.Final.jar:/home/purbanus/.m2/repository/io/netty/netty-transport-native-kqueue/4.1.97.Final/netty-transport-native-kqueue-4.1.97.Final.jar:/home/purbanus/.m2/repository/io/netty/netty-transport-native-unix-common/4.1.97.Final/netty-transport-native-unix-common-4.1.97.Final.jar:/home/purbanus/.m2/repository/io/netty/netty-transport/4.1.97.Final/netty-transport-4.1.97.Final.jar:/home/purbanus/.m2/repository/io/netty/netty-resolver/4.1.97.Final/netty-resolver-4.1.97.Final.jar:/home/purbanus/.m2/repository/io/opentelemetry/opentelemetry-api/1.25.0/opentelemetry-api-1.25.0.jar:/home/purbanus/.m2/repository/io/opentelemetry/opentelemetry-context/1.25.0/opentelemetry-context-1.25.0.jar:/home/purbanus/.m2/repository/io/opentelemetry/opentelemetry-exporter-logging/1.25.0/opentelemetry-exporter-logging-1.25.0.jar:/home/purbanus/.m2/repository/io/opentelemetry/opentelemetry-sdk-metrics/1.25.0/opentelemetry-sdk-metrics-1.25.0.jar:/home/purbanus/.m2/repository/io/opentelemetry/opentelemetry-sdk-logs/1.25.0-alpha/opentelemetry-sdk-logs-1.25.0-alpha.jar:/home/purbanus/.m2/repository/io/opentelemetry/opentelemetry-api-logs/1.25.0-alpha/opentelemetry-api-logs-1.25.0-alpha.jar:/home/purbanus/.m2/repository/io/opentelemetry/opentelemetry-api-events/1.25.0-alpha/opentelemetry-api-events-1.25.0-alpha.jar:/home/purbanus/.m2/repository/io/opentelemetry/opentelemetry-sdk-common/1.25.0/opentelemetry-sdk-common-1.25.0.jar:/home/purbanus/.m2/repository/io/opentelemetry/opentelemetry-sdk-extension-autoconfigure-spi/1.25.0/opentelemetry-sdk-extension-autoconfigure-spi-1.25.0.jar:/home/purbanus/.m2/repository/io/opentelemetry/opentelemetry-sdk-extension-autoconfigure/1.24.0-alpha/opentelemetry-sdk-extension-autoconfigure-1.24.0-alpha.jar:/home/purbanus/.m2/repository/io/opentelemetry/opentelemetry-sdk-trace/1.25.0/opentelemetry-sdk-trace-1.25.0.jar:/home/purbanus/.m2/repository/io/opentelemetry/opentelemetry-sdk/1.25.0/opentelemetry-sdk-1.25.0.jar:/home/purbanus/.m2/repository/io/opentelemetry/opentelemetry-semconv/1.24.0-alpha/opentelemetry-semconv-1.24.0-alpha.jar:/home/purbanus/.m2/repository/io/ous/jtoml/2.0.0/jtoml-2.0.0.jar:/home/purbanus/.m2/repository/org/apache/commons/commons-exec/1.3/commons-exec-1.3.jar:/home/purbanus/.m2/repository/org/asynchttpclient/async-http-client/2.12.3/async-http-client-2.12.3.jar:/home/purbanus/.m2/repository/org/asynchttpclient/async-http-client-netty-utils/2.12.3/async-http-client-netty-utils-2.12.3.jar:/home/purbanus/.m2/repository/io/netty/netty-codec-socks/4.1.97.Final/netty-codec-socks-4.1.97.Final.jar:/home/purbanus/.m2/repository/io/netty/netty-handler-proxy/4.1.97.Final/netty-handler-proxy-4.1.97.Final.jar:/home/purbanus/.m2/repository/io/netty/netty-transport-native-epoll/4.1.97.Final/netty-transport-native-epoll-4.1.97.Final-linux-x86_64.jar:/home/purbanus/.m2/repository/io/netty/netty-transport-native-kqueue/4.1.97.Final/netty-transport-native-kqueue-4.1.97.Final-osx-x86_64.jar:/home/purbanus/.m2/repository/org/reactivestreams/reactive-streams/1.0.4/reactive-streams-1.0.4.jar:/home/purbanus/.m2/repository/com/typesafe/netty/netty-reactive-streams/2.0.4/netty-reactive-streams-2.0.4.jar:/home/purbanus/.m2/repository/com/sun/activation/jakarta.activation/1.2.2/jakarta.activation-1.2.2.jar:/home/purbanus/.m2/repository/org/seleniumhq/selenium/selenium-http/4.8.3/selenium-http-4.8.3.jar:/home/purbanus/.m2/repository/dev/failsafe/failsafe/3.3.1/failsafe-3.3.1.jar:/home/purbanus/.m2/repository/org/seleniumhq/selenium/selenium-manager/4.8.3/selenium-manager-4.8.3.jar:/home/purbanus/.m2/repository/net/sourceforge/htmlunit/htmlunit/2.70.0/htmlunit-2.70.0.jar:/home/purbanus/.m2/repository/org/apache/httpcomponents/httpmime/4.5.14/httpmime-4.5.14.jar:/home/purbanus/.m2/repository/org/apache/httpcomponents/httpclient/4.5.14/httpclient-4.5.14.jar:/home/purbanus/.m2/repository/org/apache/httpcomponents/httpcore/4.4.16/httpcore-4.4.16.jar:/home/purbanus/.m2/repository/net/sourceforge/htmlunit/htmlunit-core-js/2.70.0/htmlunit-core-js-2.70.0.jar:/home/purbanus/.m2/repository/net/sourceforge/htmlunit/neko-htmlunit/2.70.0/neko-htmlunit-2.70.0.jar:/home/purbanus/.m2/repository/net/sourceforge/htmlunit/htmlunit-cssparser/1.14.0/htmlunit-cssparser-1.14.0.jar:/home/purbanus/.m2/repository/net/sourceforge/htmlunit/htmlunit-xpath/2.70.0/htmlunit-xpath-2.70.0.jar:/home/purbanus/.m2/repository/org/apache/commons/commons-text/1.10.0/commons-text-1.10.0.jar:/home/purbanus/.m2/repository/commons-net/commons-net/3.9.0/commons-net-3.9.0.jar:/home/purbanus/.m2/repository/commons-codec/commons-codec/1.15/commons-codec-1.15.jar:/home/purbanus/.m2/repository/org/brotli/dec/0.1.2/dec-0.1.2.jar:/home/purbanus/.m2/repository/com/shapesecurity/salvation2/3.0.1/salvation2-3.0.1.jar:/home/purbanus/.m2/repository/org/eclipse/jetty/websocket/websocket-client/9.4.50.v20221201/websocket-client-9.4.50.v20221201.jar:/home/purbanus/.m2/repository/org/eclipse/jetty/jetty-client/11.0.16/jetty-client-11.0.16.jar:/home/purbanus/.m2/repository/org/eclipse/jetty/jetty-http/11.0.16/jetty-http-11.0.16.jar:/home/purbanus/.m2/repository/org/eclipse/jetty/jetty-alpn-client/11.0.16/jetty-alpn-client-11.0.16.jar:/home/purbanus/.m2/repository/org/eclipse/jetty/jetty-util/11.0.16/jetty-util-11.0.16.jar:/home/purbanus/.m2/repository/org/eclipse/jetty/jetty-io/11.0.16/jetty-io-11.0.16.jar:/home/purbanus/.m2/repository/org/eclipse/jetty/websocket/websocket-common/9.4.50.v20221201/websocket-common-9.4.50.v20221201.jar:/home/purbanus/.m2/repository/org/eclipse/jetty/websocket/websocket-api/9.4.50.v20221201/websocket-api-9.4.50.v20221201.jar:/home/purbanus/.m2/repository/org/apache/commons/commons-lang3/3.12.0/commons-lang3-3.12.0.jar:/home/purbanus/.m2/repository/org/apache/commons/commons-collections4/4.4/commons-collections4-4.4.jar:/home/purbanus/.m2/repository/commons-io/commons-io/2.11.0/commons-io-2.11.0.jar:/home/purbanus/.m2/repository/org/junit/platform/junit-platform-launcher/1.9.3/junit-platform-launcher-1.9.3.jar:/home/purbanus/prog/eclipse/sts-4.18.0.RELEASE/configuration/org.eclipse.osgi/261/0/.cp:/home/purbanus/prog/eclipse/sts-4.18.0.RELEASE/configuration/org.eclipse.osgi/259/0/.cp 
 
 java.lang.IllegalStateException: Failed to load ApplicationContext
	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:98)
	at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
	at org.springframework.test.context.web.ServletTestExecutionListener.setUpRequestContextIfNecessary(ServletTestExecutionListener.java:190)
	at org.springframework.test.context.web.ServletTestExecutionListener.prepareTestInstance(ServletTestExecutionListener.java:132)
	at org.springframework.test.context.TestContextManager.prepareTestInstance(TestContextManager.java:248)
	at org.springframework.test.context.junit.jupiter.SpringExtension.postProcessTestInstance(SpringExtension.java:138)
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$invokeTestInstancePostProcessors$8(ClassBasedTestDescriptor.java:363)
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.executeAndMaskThrowable(ClassBasedTestDescriptor.java:368)
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$invokeTestInstancePostProcessors$9(ClassBasedTestDescriptor.java:363)
	at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:197)
	at java.base/java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:179)
	at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1625)
	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
	at java.base/java.util.stream.StreamSpliterators$WrappingSpliterator.forEachRemaining(StreamSpliterators.java:310)
	at java.base/java.util.stream.Streams$ConcatSpliterator.forEachRemaining(Streams.java:735)
	at java.base/java.util.stream.Streams$ConcatSpliterator.forEachRemaining(Streams.java:734)
	at java.base/java.util.stream.ReferencePipeline$Head.forEach(ReferencePipeline.java:762)
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.invokeTestInstancePostProcessors(ClassBasedTestDescriptor.java:362)
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$instantiateAndPostProcessTestInstance$6(ClassBasedTestDescriptor.java:283)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.instantiateAndPostProcessTestInstance(ClassBasedTestDescriptor.java:282)
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$testInstancesProvider$4(ClassBasedTestDescriptor.java:272)
	at java.base/java.util.Optional.orElseGet(Optional.java:364)
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$testInstancesProvider$5(ClassBasedTestDescriptor.java:271)
	at org.junit.jupiter.engine.execution.TestInstancesProvider.getTestInstances(TestInstancesProvider.java:31)
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.lambda$prepare$0(TestMethodTestDescriptor.java:102)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.prepare(TestMethodTestDescriptor.java:101)
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.prepare(TestMethodTestDescriptor.java:66)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$prepare$2(NodeTestTask.java:123)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.prepare(NodeTestTask.java:123)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:90)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:41)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$6(NodeTestTask.java:155)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:141)
	at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:137)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$9(NodeTestTask.java:139)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:138)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:95)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:41)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$6(NodeTestTask.java:155)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:141)
	at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:137)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$9(NodeTestTask.java:139)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:138)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:95)
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.submit(SameThreadHierarchicalTestExecutorService.java:35)
	at org.junit.platform.engine.support.hierarchical.HierarchicalTestExecutor.execute(HierarchicalTestExecutor.java:57)
	at org.junit.platform.engine.support.hierarchical.HierarchicalTestEngine.execute(HierarchicalTestEngine.java:54)
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:107)
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:88)
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.lambda$execute$0(EngineExecutionOrchestrator.java:54)
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.withInterceptedStreams(EngineExecutionOrchestrator.java:67)
	at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:52)
	at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:114)
	at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:95)
	at org.junit.platform.launcher.core.DefaultLauncherSession$DelegatingLauncher.execute(DefaultLauncherSession.java:91)
	at org.junit.platform.launcher.core.SessionPerRequestLauncher.execute(SessionPerRequestLauncher.java:60)
	at org.eclipse.jdt.internal.junit5.runner.JUnit5TestReference.run(JUnit5TestReference.java:98)
	at org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:40)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:529)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:756)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:452)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:210)
Caused by: java.lang.IllegalArgumentException: LoggerFactory is not a Logback LoggerContext but Logback is on the classpath. Either remove Logback or the competing implementation (class org.slf4j.impl.Log4jLoggerFactory loaded from file:/home/purbanus/.ivy2/cache/org.slf4j/slf4j-log4j12/jars/slf4j-log4j12-1.7.21.jar). If you are using WebLogic you will need to add 'org.slf4j' to prefer-application-packages in WEB-INF/weblogic.xml: org.slf4j.impl.Log4jLoggerFactory
	at org.springframework.util.Assert.instanceCheckFailed(Assert.java:702)
	at org.springframework.util.Assert.isInstanceOf(Assert.java:621)
	at org.springframework.boot.logging.logback.LogbackLoggingSystem.getLoggerContext(LogbackLoggingSystem.java:294)
	at org.springframework.boot.logging.logback.LogbackLoggingSystem.beforeInitialize(LogbackLoggingSystem.java:118)
	at org.springframework.boot.context.logging.LoggingApplicationListener.onApplicationStartingEvent(LoggingApplicationListener.java:238)
	at org.springframework.boot.context.logging.LoggingApplicationListener.onApplicationEvent(LoggingApplicationListener.java:220)
	at org.springframework.context.event.SimpleApplicationEventMulticaster.doInvokeListener(SimpleApplicationEventMulticaster.java:176)
	at org.springframework.context.event.SimpleApplicationEventMulticaster.invokeListener(SimpleApplicationEventMulticaster.java:169)
	at org.springframework.context.event.SimpleApplicationEventMulticaster.multicastEvent(SimpleApplicationEventMulticaster.java:143)
	at org.springframework.context.event.SimpleApplicationEventMulticaster.multicastEvent(SimpleApplicationEventMulticaster.java:131)
	at org.springframework.boot.context.event.EventPublishingRunListener.starting(EventPublishingRunListener.java:79)
	at org.springframework.boot.SpringApplicationRunListeners.lambda$starting$0(SpringApplicationRunListeners.java:56)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
	at org.springframework.boot.SpringApplicationRunListeners.doWithListeners(SpringApplicationRunListeners.java:120)
	at org.springframework.boot.SpringApplicationRunListeners.starting(SpringApplicationRunListeners.java:56)
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:298)
	at org.springframework.boot.test.context.SpringBootContextLoader.loadContext(SpringBootContextLoader.java:148)
	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:141)
	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:90)
	... 71 more
*/
