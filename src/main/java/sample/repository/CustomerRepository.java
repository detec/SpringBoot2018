package sample.repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.scheduling.annotation.Async;

import sample.domain.Customer;

public interface CustomerRepository extends Repository<Customer, Long> {

    /**
     *
     * Special customization of
     * {@link CrudRepository#findOne(java.io.Serializable)} to return a JDK 8
     * {@link Optional}.
     *
     * @param id
     * @return Optional of customer
     */
    Optional<Customer> findOne(Long id);

    /**
     *
     * Saves the given {@link Customer}.
     *
     * @param customer
     * @return saved instance
     *
     */
    <S extends Customer> S save(S customer);

    /**
     *
     * Sample method to derive a query from using JDK 8's {@link Optional} as
     * return type.
     *
     * @param lastname
     * @return Optional of customer
     */
    Optional<Customer> findByLastName(String lastName);

    List<Customer> findAllByLastName(String lastName);

    /**
     *
     * The query is executed in a streaming fashion which means that the method
     * returns as soon as the first results are ready.
     *
     * @return Stream of instances
     */
    @Query("select c from Customer c")
    List<Customer> ListAllCustomers();

    /**
     *
     * Support for {@link Stream} as a return type with a derived query.
     *
     * @return Stream of instances
     */
    Stream<Customer> findAllByLastNameIsNotNull();

    @Async
    CompletableFuture<List<Customer>> readAllBy();

    <S extends Customer> void delete(S customer);

}
