package swax.web.boot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@Configuration@EnableWebMvcpublic class SwaxMvcConfig extends WebMvcConfigurerAdapter {
	@Override    public void addResourceHandlers(ResourceHandlerRegistry registry) {        //Rajout des ressources liees à la langue    	registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");         //Rajout des ressources statiques (js, img, css se trouvant dans le repertoire static de la webapp    	registry.addResourceHandler("/img/**").addResourceLocations("/img/");    }
    @Bean    public LocaleResolver localeResolver() {     CookieLocaleResolver slr = new CookieLocaleResolver();     return slr;    }
    @Bean    public ResourceBundleMessageSource messageSource() {     ResourceBundleMessageSource source = new ResourceBundleMessageSource();     source.setBasenames("messages");  // name of the resource bundle      source.setUseCodeAsDefaultMessage(true);     return source;    }
    @Bean    public ViewResolver getViewResolver() {        InternalResourceViewResolver resolver = new InternalResourceViewResolver();        resolver.setPrefix("/views/");        resolver.setSuffix(".jsp");        return resolver;    }
}