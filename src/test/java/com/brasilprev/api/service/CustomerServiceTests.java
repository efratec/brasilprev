package com.brasilprev.api.service;

import com.brasilprev.api.dto.CustomerDTO;
import com.brasilprev.api.exception.customer.CustomerAlreadyExistsException;
import com.brasilprev.api.model.Customer;
import com.brasilprev.api.repository.CustomerRepository;
import com.brasilprev.api.service.impl.CustomerServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.brasilprev.api.constants.ConstantsTests.Customers.*;
import static com.brasilprev.api.fixture.CustomerFixture.aCustomerCalMoreiraDaSilva;
import static com.brasilprev.api.fixture.CustomerFixture.aCustomerMariaDaSilva;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTests {

    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    private CustomerDTO customerDTO;
    private Customer customer;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        customerService = new CustomerServiceImpl(customerRepository);
        givenValidCustomerDTO();
        customer = aCustomerMariaDaSilva();
    }

    @Test
    public void shouldCreateCustomerSuccessfully() throws Exception {
        when(customerRepository.existsByNameAndCpf(NAME_MARIA_DA_SILVA, CPF_08477925536)).thenReturn(false);
        when(customerRepository.save(any(Customer.class))).thenReturn(aCustomerMariaDaSilva());

        Customer customer = customerService.saveCustomer(customerDTO);

        assertNotNull(customer);
        assertEquals(customer.getName(), aCustomerMariaDaSilva().getName());
        assertEquals(customer.getCpf(), aCustomerMariaDaSilva().getCpf());
        assertEquals(customer.getAddress(), aCustomerMariaDaSilva().getAddress());

    }

    @Test
    public void shouldThrowsCustomerAlreadyExistsExceptionWhenCreateCustomer() {
        when(customerRepository.existsByNameAndCpf(NAME_MARIA_DA_SILVA, CPF_08477925536)).thenReturn(true);
        assertThrows(CustomerAlreadyExistsException.class, () -> customerService.saveCustomer(customerDTO));
    }

    @Test
    public void shouldToUpdateCustomerSuccessfully() {
        when(customerRepository.getOne(1L)).thenReturn(aCustomerMariaDaSilva());
        when(customerRepository.save(any(Customer.class))).thenReturn(aCustomerCalMoreiraDaSilva());

        updateCustomer();
        Customer customerUpdate = customerService.updateCustomer(1L, customer);

        assertNotNull(customerUpdate);
        assertEquals(customer.getCpf(), customerUpdate.getCpf());
        assertEquals(customer.getName(), customerUpdate.getName());
    }

    private void updateCustomer() {
        customer.setCpf("555884499");
        customer.setName("Cal Moreira");
    }

    private void givenValidCustomerDTO() {
        customerDTO = new CustomerDTO();
        customerDTO.setAddress(RUA_DA_SILVA_N_10);
        customerDTO.setCpf(CPF_08477925536);
        customerDTO.setName(NAME_MARIA_DA_SILVA);
    }

}
