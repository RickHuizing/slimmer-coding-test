package rjhuizing.slimmer.coding.test.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
@EnableWebMvc
class ControllerConfiguration : WebMvcConfigurer {
// uncomment to allow CORS requests
//    override fun addCorsMappings(registry: CorsRegistry) {
//        registry.addMapping("/**")
//            .allowedOrigins(
//                "http://localhost:3000",
//            )
//            .allowedMethods("GET", "PUT", "DELETE")
//    }
}