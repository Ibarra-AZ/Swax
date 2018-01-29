package swax.web.boot;
import org.apache.coyote.http11.AbstractHttp11Protocol;import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;import org.springframework.context.annotation.Bean;import org.springframework.context.annotation.Configuration;import org.springframework.context.support.ResourceBundleMessageSource;import org.springframework.web.servlet.LocaleResolver;import org.springframework.web.servlet.ViewResolver;import org.springframework.web.servlet.config.annotation.EnableWebMvc;import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;import org.springframework.web.servlet.i18n.CookieLocaleResolver;import org.springframework.web.servlet.view.InternalResourceViewResolver;
@Configuration@EnableWebMvcpublic class SwaxMvcConfig extends WebMvcConfigurerAdapter {
	@Override    public void addResourceHandlers(ResourceHandlerRegistry registry) {        //Rajout des ressources liees à la langue    	registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");         //Rajout des ressources statiques (js, img, css se trouvant dans le repertoire static de la webapp    	registry.addResourceHandler("/img/**").addResourceLocations("/img/");    }
    @Bean    public LocaleResolver localeResolver() {     CookieLocaleResolver slr = new CookieLocaleResolver();     return slr;    }
    @Bean    public ResourceBundleMessageSource messageSource() {     ResourceBundleMessageSource source = new ResourceBundleMessageSource();     source.setBasenames("messages");  // name of the resource bundle      source.setUseCodeAsDefaultMessage(true);     return source;    }
    @Bean    public ViewResolver getViewResolver() {        InternalResourceViewResolver resolver = new InternalResourceViewResolver();        resolver.setPrefix("/views/");        resolver.setSuffix(".jsp");        return resolver;    }        //Tomcat large file upload connection reset    //http://www.mkyong.com/spring/spring-file-upload-and-connection-reset-issue/    @Bean    public TomcatEmbeddedServletContainerFactory tomcatEmbedded() {        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();        tomcat.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {            if ((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)) {                //-1 means unlimited                ((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(-1);            }        });        return tomcat;    }    //    @Bean//    ServletRegistrationBean h2servletRegistration(){//        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());//        registrationBean.addUrlMappings("/console/*");//        return registrationBean;//    }
}