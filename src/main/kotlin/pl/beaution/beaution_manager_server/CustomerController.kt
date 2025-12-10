package pl.beaution.beaution_manager_server

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/customers")
class CustomerController(private val customerService: CustomerService) {

    @GetMapping
    fun getAllCustomers(pageable: Pageable): Page<Customer> {
        return customerService.getAllCustomers(pageable)
    }
}
