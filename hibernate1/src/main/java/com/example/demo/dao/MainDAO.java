package com.example.demo.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.demo.model.Main;
import com.example.demo.tools.BaseHibernateDAO;

public class MainDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(MainDAO.class);

	public static final String MAINNAME = "mainname";

	public void save(Main transientInstance) {
		log.debug("saving Main instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Main persistentInstance) {
		log.debug("deleting Main instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Main findById(java.lang.Long id) {
		log.debug("getting Main instance with id: " + id);
		try {
			Main instance = (Main) getSession().get("orm.Main", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Main instance) {
		log.debug("finding Main instance by example");
		try {
			List results = getSession().createCriteria("orm.Main").add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List<Main> findByProperty(String propertyName, Object value) {
		log.debug("finding Main instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Main as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByMainname(Object mainname) {
		return findByProperty(MAINNAME, mainname);
	}

	public List<Main> findAll() {
		log.debug("finding all Main instances");
		try {
			String queryString = "from Main";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Main merge(Main detachedInstance) {
		log.debug("merging Main instance");
		try {
			Main result = (Main) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Main instance) {
		log.debug("attaching dirty Main instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Main instance) {
		log.debug("attaching clean Main instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}