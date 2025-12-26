package pl.beaution.beaution_manager_server

import com.sendgrid.*
import com.sendgrid.helpers.mail.Mail
import com.sendgrid.helpers.mail.objects.Content
import com.sendgrid.helpers.mail.objects.Email
import org.springframework.stereotype.Service

@Service
class EmailService(private val sendGrid: SendGrid) {

    fun sendEmail(to: String, subject: String, body: String) {
        val from = Email("from@nackiewicz.com")
        val mail = Mail(from, subject, Email(to), Content("text/plain", body))
        val request = Request().apply {
            method = Method.POST
            endpoint = "mail/send"
            setBody(mail.build())
        }
        sendGrid.api(request)
    }
}