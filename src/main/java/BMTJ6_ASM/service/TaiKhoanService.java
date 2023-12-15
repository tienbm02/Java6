package BMTJ6_ASM.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import BMTJ6_ASM.entity.TaiKhoan;

public interface TaiKhoanService {

	<S extends TaiKhoan> List<S> findAll(Example<S> example, Sort sort);

	<S extends TaiKhoan> List<S> findAll(Example<S> example);

	TaiKhoan getReferenceById(String id);

	TaiKhoan getById(String id);

	void deleteAll();

	void deleteAll(Iterable<? extends TaiKhoan> entities);

	TaiKhoan getOne(String id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends String> ids);

	<S extends TaiKhoan, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(TaiKhoan entity);

	void deleteAllByIdInBatch(Iterable<String> ids);

	void deleteById(String id);

	<S extends TaiKhoan> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<TaiKhoan> entities);

	<S extends TaiKhoan> long count(Example<S> example);

	void deleteInBatch(Iterable<TaiKhoan> entities);

	<S extends TaiKhoan> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends TaiKhoan> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends TaiKhoan> S saveAndFlush(S entity);

	boolean existsById(String id);

	void flush();

	<S extends TaiKhoan> List<S> saveAll(Iterable<S> entities);

	Optional<TaiKhoan> findById(String id);

	List<TaiKhoan> findAllById(Iterable<String> ids);

	List<TaiKhoan> findAll(Sort sort);

	Page<TaiKhoan> findAll(Pageable pageable);

	List<TaiKhoan> findAll();

	<S extends TaiKhoan> Optional<S> findOne(Example<S> example);

	<S extends TaiKhoan> S save(S entity);

}
