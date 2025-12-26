package pl.beaution.beaution_manager_server

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/email")
class EmailTestController(private val emailService: EmailService) {

    data class SendRequest(
        val to: String,
        val subject: String,
        val body: String
    )

    @PostMapping("/test")
    fun testSendEmail(@RequestBody request: SendRequest): ResponseEntity<String> {
        try {
            emailService.sendEmail(request.to, request.subject, request.body)
            return ResponseEntity.ok("Email wysłany pomyślnie do ${request.to}")
        } catch (e: Exception) {
            return ResponseEntity.internalServerError()
                .body("Błąd wysyłania: ${e.message}")
        }
    }
}