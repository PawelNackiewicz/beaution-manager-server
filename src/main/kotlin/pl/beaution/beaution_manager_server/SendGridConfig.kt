package pl.beaution.beaution_manager_server

import com.sendgrid.SendGrid
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SendGridConfig(
    @Value("\${spring.sendgrid.api-key}") private val apiKey: String
) {
    @Bean
    fun sendGrid(): SendGrid = SendGrid(apiKey)
}