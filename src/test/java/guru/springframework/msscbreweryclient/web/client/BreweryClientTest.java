package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Autowired
    CustomerClient customerClient;

    @Test
    void getBeerById() {
        BeerDto dto = client.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void saveNewBeer() {
        // given
        BeerDto dto = BeerDto.builder().beerName("New Beer").build();

        URI uri = client.saveNewBeer(dto);

        assertNotNull(uri);

        System.out.println(uri.toString());

    }

    @Test
    void testUpdateBeer() {
        // given
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
        client.updateBeer(UUID.randomUUID(), beerDto);
    }

    @Test
    void testDeleteBeer() {
        client.deleteBeer(UUID.randomUUID());
    }






    @Test
    void testGetCustomerById() {
        CustomerDto dto = customerClient.getCustomerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void testSaveNewCustomer() {
        // given
        CustomerDto dto = CustomerDto.builder().name("New Customer").build();

        URI uri = customerClient.saveNewCustomer(dto);

        assertNotNull(uri);

        System.out.println(uri.toString());

    }

    @Test
    void testUpdateCustomer() {
        // given
        CustomerDto customerDto = CustomerDto.builder().name("New Customer").build();
        customerClient.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    void testDeleteCustomer() {
        customerClient.deleteCustomer(UUID.randomUUID());
    }












}