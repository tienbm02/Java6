package BMTJ6_ASM.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import BMTJ6_ASM.entity.TaiKhoan;
import BMTJ6_ASM.dao.TaiKhoanDAO;
import BMTJ6_ASM.service.TaiKhoanService;

@Service
public class TaiKhoanServiceImpl implements TaiKhoanService {
	
	@Autowired
	private TaiKhoanDAO dao;

	@Override
	public <S extends TaiKhoan> S save(S entity) {
		return dao.save(entity);
	}

	@Override
	public <S extends TaiKhoan> Optional<S> findOne(Example<S> example) {
		return dao.findOne(example);
	}

	@Override
	public List<TaiKhoan> findAll() {
		return dao.findAll();
	}

	@Override
	public Page<TaiKhoan> findAll(Pageable pageable) {
		return dao.findAll(pageable);
	}

	@Override
	public List<TaiKhoan> findAll(Sort sort) {
		return dao.findAll(sort);
	}

	@Override
	public List<TaiKhoan> findAllById(Iterable<String> ids) {
		return dao.findAllById(ids);
	}

	@Override
	public Optional<TaiKhoan> findById(String id) {
		return dao.findById(id);
	}

	@Override
	public <S extends TaiKhoan> List<S> saveAll(Iterable<S> entities) {
		return dao.saveAll(entities);
	}

	@Override
	public void flush() {
		dao.flush();
	}

	@Override
	public boolean existsById(String id) {
		return dao.existsById(id);
	}

	@Override
	public <S extends TaiKhoan> S saveAndFlush(S entity) {
		return dao.saveAndFlush(entity);
	}

	@Override
	public <S extends TaiKhoan> List<S> saveAllAndFlush(Iterable<S> entities) {
		return dao.saveAllAndFlush(entities);
	}

	@Override
	public <S extends TaiKhoan> Page<S> findAll(Example<S> example, Pageable pageable) {
		return dao.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<TaiKhoan> entities) {
		dao.deleteInBatch(entities);
	}

	@Override
	public <S extends TaiKhoan> long count(Example<S> example) {
		return dao.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<TaiKhoan> entities) {
		dao.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return dao.count();
	}

	@Override
	public <S extends TaiKhoan> boolean exists(Example<S> example) {
		return dao.exists(example);
	}

	@Override
	public void deleteById(String id) {
		dao.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<String> ids) {
		dao.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(TaiKhoan entity) {
		dao.delete(entity);
	}

	@Override
	public <S extends TaiKhoan, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return dao.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		dao.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		dao.deleteAllInBatch();
	}

	@Override
	public TaiKhoan getOne(String id) {
		return dao.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends TaiKhoan> entities) {
		dao.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		dao.deleteAll();
	}

	@Override
	public TaiKhoan getById(String id) {
		return dao.getById(id);
	}

	@Override
	public TaiKhoan getReferenceById(String id) {
		return dao.getReferenceById(id);
	}

	@Override
	public <S extends TaiKhoan> List<S> findAll(Example<S> example) {
		return dao.findAll(example);
	}

	@Override
	public <S extends TaiKhoan> List<S> findAll(Example<S> example, Sort sort) {
		return dao.findAll(example, sort);
	}

}
