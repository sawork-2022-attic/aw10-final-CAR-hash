package com.micro.delivery.handler;

import com.micro.delivery.repository.CartRepository;
import com.micropos.datatype.cart.Cart;
import org.reactivestreams.Publisher;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.Function;

/*public class TestCartRepo implements CartRepository {
    @Override
    public <S extends Cart> Mono<S> insert(S entity) {
        return null;
    }

    @Override
    public <S extends Cart> Flux<S> insert(Iterable<S> entities) {
        return null;
    }

    @Override
    public <S extends Cart> Flux<S> insert(Publisher<S> entities) {
        return null;
    }

    @Override
    public <S extends Cart> Mono<S> findOne(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Cart> Flux<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Cart> Flux<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Cart> Mono<Long> count(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Cart> Mono<Boolean> exists(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Cart, R, P extends Publisher<R>> P findBy(Example<S> example, Function<FluentQuery.ReactiveFluentQuery<S>, P> queryFunction) {
        return null;
    }

    @Override
    public Flux<Cart> findAll(Sort sort) {
        return null;
    }

    @Override
    public <S extends Cart> Mono<S> save(S entity) {
        return null;
    }

    @Override
    public <S extends Cart> Flux<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public <S extends Cart> Flux<S> saveAll(Publisher<S> entityStream) {
        return null;
    }

    @Override
    public Mono<Cart> findById(String s) {
        return null;
    }

    @Override
    public Mono<Cart> findById(Publisher<String> id) {
        return null;
    }

    @Override
    public Mono<Boolean> existsById(String s) {
        return null;
    }

    @Override
    public Mono<Boolean> existsById(Publisher<String> id) {
        return null;
    }

    @Override
    public Flux<Cart> findAll() {
        return null;
    }

    @Override
    public Flux<Cart> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public Flux<Cart> findAllById(Publisher<String> idStream) {
        return null;
    }

    @Override
    public Mono<Long> count() {
        return null;
    }

    @Override
    public Mono<Void> deleteById(String s) {
        return null;
    }

    @Override
    public Mono<Void> deleteById(Publisher<String> id) {
        return null;
    }

    @Override
    public Mono<Void> delete(Cart entity) {
        return null;
    }

    @Override
    public Mono<Void> deleteAllById(Iterable<? extends String> strings) {
        return null;
    }

    @Override
    public Mono<Void> deleteAll(Iterable<? extends Cart> entities) {
        return null;
    }

    @Override
    public Mono<Void> deleteAll(Publisher<? extends Cart> entityStream) {
        return null;
    }

    @Override
    public Mono<Void> deleteAll() {
        return null;
    }
}*/
