package com.itel.tools;

import java.util.List;
import java.util.Map;
import java.util.Set;

import oracle.net.aso.q;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.itel.dao.utils.BaseDao;
import com.itel.dao.utils.QueryCondition;
import com.itel.data.GridResult;

/**
 * 控制层扩展类 支持Contoller集成该类设定泛型,简单的CRUD可直接实现
 * 
 * @author yangxuan
 * 
 * @param <E>
 */
public class ControllerSupport<E> {
	protected static Logger logger = LoggerFactory
			.getLogger(ControllerSupport.class);
	protected Class<E> entityClass;
	protected BaseDao baseDao;

	@Autowired
	@Qualifier("baseDao")
	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public ControllerSupport() {
		this.entityClass = ReflectionUtils.getSuperClassGenricType(getClass());
	}

	@RequestMapping(value = "/queryByEntity", method = RequestMethod.GET)
	public ModelAndView queryByEntity(E entity) {
		List list = baseDao.findByExample(entity);
		return new ModelAndView("jsonView", new GridResult(list, list.size()));
	}

	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public ModelAndView query(ModelMap model) {
		List list = baseDao.findAll(this.entityClass.getName());
		return new ModelAndView("jsonView", new GridResult(list, list.size()));
	}

	@RequestMapping(value = "/queryForPage", method = RequestMethod.GET)
	public ModelAndView queryForPage(QueryCondition queryCondition) {
		queryCondition.setSql(" from " + this.entityClass.getName());
		List list = baseDao.findByHql(queryCondition.getSql(), null,
				queryCondition.getPageIndex(), queryCondition.getPageMax());
		return new ModelAndView("jsonView", new GridResult(list, list.size()));
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView add(E entity) {
		GridResult gridResult = new GridResult();
		try {
			baseDao.save(entity);
			logger.debug("add success");
			gridResult.setSuccess(true);
			gridResult.setMsg("save success");
			return new ModelAndView("jsonView", gridResult);
		} catch (Exception e) {
			gridResult.setSuccess(false);
			logger.debug("add failure");
			gridResult.setMsg("save failure");
			return new ModelAndView("jsonView", gridResult);
		}
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public ModelAndView modify(E entity) {
		GridResult gridResult = new GridResult();
		try {
			baseDao.saveOrUpdate(entity);
			gridResult.setSuccess(true);
			logger.debug("saveOrUpdate success");
			gridResult.setMsg("saveOrUpdate success");
			return new ModelAndView("jsonView", gridResult);
		} catch (Exception e) {
			gridResult.setSuccess(false);
			logger.debug("saveOrUpdate failure");
			gridResult.setMsg("saveOrUpdate failure");			
			return new ModelAndView("jsonView", gridResult);
		}
	}

	@RequestMapping(value = { "/del" }, method = RequestMethod.POST)
	public ModelAndView delete(E entity) {
		GridResult gridResult = new GridResult();
		try {
			baseDao.delete(entity);
			gridResult.setSuccess(true);
			gridResult.setMsg("delete success");		
			return new ModelAndView("jsonView", gridResult);
		} catch (Exception e) {
			gridResult.setSuccess(false);
			gridResult.setMsg("delete failure");	
			return new ModelAndView("jsonView", gridResult);
		}
	}

	@RequestMapping(value = "/queryForWhereOr", method = RequestMethod.GET)
	public ModelAndView queryForWhereOr(QueryCondition queryCondition) {
		queryCondition.setTableName(this.entityClass.getName());
		List list = baseDao.queryForWhereOr(queryCondition);
		return new ModelAndView("jsonView", new GridResult(list, list.size()));
	}

	@RequestMapping(value = "/queryForWhereAnd", method ={ RequestMethod.GET,RequestMethod.POST})
	public ModelAndView queryForWhereAnd(QueryCondition queryCondition) {
		queryCondition.setTableName(this.entityClass.getName());
		List list = baseDao.queryForWhereAnd(queryCondition);
		return new ModelAndView("jsonView", new GridResult(list, list.size()));
	}

	@RequestMapping(value = "/queryForOrderBy", method = RequestMethod.GET)
	public ModelAndView queryForOrderBy(QueryCondition queryCondition) {
		queryCondition.setTableName(this.entityClass.getName());
		List list = baseDao.queryForWhereAnd(queryCondition);
		return new ModelAndView("jsonView", new GridResult(list, list.size()));
	}

}
