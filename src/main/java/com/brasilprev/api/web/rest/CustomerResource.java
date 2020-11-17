package com.brasilprev.api.web.rest;

import com.brasilprev.api.dto.CustomerDTO;
import com.brasilprev.api.exception.customer.CustomerAlreadyExistsException;
import com.brasilprev.api.model.Customer;
import com.brasilprev.api.service.CustomerService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.brasilprev.api.constants.Constants.Status.*;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("api/customers")
@Api(value = "Brasilprevi services")
@CrossOrigin("*")
public class CustomerResource {

    @Autowired
    private CustomerService customerService;

    @ApiResponses(value = { @ApiResponse(code = 200, message = STATUS_200_GET_OK),
            @ApiResponse(code = 404, message = STATUS_404_NOT_FOUND),
            @ApiResponse(code = 500, message = STATUS_500_INTERNAL_SERVER_ERROR) })
    @ApiOperation(value = "Get All Customers", authorizations = @Authorization(value = "JWT"))
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getListAllCustomers();
    }


    @ApiResponses(value = { @ApiResponse(code = 200, message = STATUS_200_GET_OK),
            @ApiResponse(code = 404, message = STATUS_404_NOT_FOUND),
            @ApiResponse(code = 500, message = STATUS_500_INTERNAL_SERVER_ERROR) })
    @ApiOperation(value = "Save Customers", authorizations = @Authorization(value = "JWT"))
    @PostMapping
    public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody CustomerDTO customerDTO) throws CustomerAlreadyExistsException {
        return new ResponseEntity<>(customerService.saveCustomer(customerDTO), CREATED);
    }

    @ApiResponses(value = { @ApiResponse(code = 200, message = STATUS_200_GET_OK),
            @ApiResponse(code = 404, message = STATUS_404_NOT_FOUND),
            @ApiResponse(code = 500, message = STATUS_500_INTERNAL_SERVER_ERROR) })
    @ApiOperation(value = "Get Customer by Name", authorizations = @Authorization(value = "JWT"))
    @GetMapping(value = "/{name}")
    public ResponseEntity<Customer> getCustomerByName(@PathVariable String name)  {
        return ok(customerService.findCustomerByName(name));
    }

    @ApiResponses(value = { @ApiResponse(code = 200, message = STATUS_200_GET_OK),
            @ApiResponse(code = 404, message = STATUS_404_NOT_FOUND),
            @ApiResponse(code = 500, message = STATUS_500_INTERNAL_SERVER_ERROR) })
    @ApiOperation(value = "Update Customers", authorizations = @Authorization(value = "JWT"))
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @Valid @RequestBody Customer customer) {
        return ok(customerService.updateCustomer(id, customer));
    }

    @ApiResponses(value = { @ApiResponse(code = 200, message = STATUS_200_GET_OK),
            @ApiResponse(code = 404, message = STATUS_404_NOT_FOUND),
            @ApiResponse(code = 500, message = STATUS_500_INTERNAL_SERVER_ERROR) })
    @ApiOperation(value = "Delete Customers", authorizations = @Authorization(value = "JWT"))
    @DeleteMapping("{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.delete(id);
    }

}
