package com.micropos.product.rest;

import com.micropos.datatype.product.Product;
import com.micropos.product.repository.MongoDBProductRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/*public class MongoTestRepo implements MongoDBProductRepository {
    @Override
    public List<Product> findProductByProductId(String id) {
        return null;
    }

    @Override
    public List<Product> searchProductsByTitle(String title) {
        return null;
    }

    @Override
    public List<Product> findProductByPage(int page) {
        return null;
    }

    @Override
    public <S extends Product> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Product> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Product> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Iterable<Product> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(Product entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends Product> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Product> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Product> S insert(S entity) {
        return null;
    }

    @Override
    public <S extends Product> List<S> insert(Iterable<S> entities) {
        return null;
    }

    @Override
    public <S extends Product> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Product> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Product> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Product> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Product> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Product> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Product, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}*/
