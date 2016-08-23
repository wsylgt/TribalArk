package com.cn.dao.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Created by kris on 2016/8/23.
 */
@NoRepositoryBean
public interface IBaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

}
