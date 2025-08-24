package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.springframework.context.annotation.ComponentScan.*;

@Configuration
// AppConfig.class 등에 등록한 Configuration 을 제외하기 위해 excludeFilters 사용
@ComponentScan(
        basePackages = {"hello.core.member"},
//        basePackageClasses = {AutoAppConfig.class},
        excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = {Configuration.class})
)
public class AutoAppConfig {
}
