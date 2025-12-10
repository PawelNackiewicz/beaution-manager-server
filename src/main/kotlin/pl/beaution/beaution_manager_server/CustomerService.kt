package pl.beaution.beaution_manager_server

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class CustomerService(private val customerRepository: CustomerRepository) {

    fun getAllCustomers(pageable: Pageable): Page<Customer> {
        return customerRepository.findAll(pageable)
    }

    fun getCustomerById(id: Long): Customer? {
        return customerRepository.findById(id).orElse(null)
    }

    fun createCustomer(customer: Customer): Customer {
        return customerRepository.save(customer)
    }

    fun deleteCustomer(id: Long) {
        customerRepository.deleteById(id)
    }
}
