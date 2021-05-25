package ekgc.witmed.service;

import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.pojo.system.cascade.entity.CascadeEntity;

import java.util.List;

public interface CascadeEntityService {
	/**
	 * 分页查询
	 * @param query
	 * @param pageVO
	 * @return
	 * @throws Exception
	 */
	PageVO<CascadeEntity> getPageListByQuery(CascadeEntity query, PageVO<CascadeEntity> pageVO) throws Exception;

	/**
	 * 根据查询对象，查询数据库返回列表
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<CascadeEntity> getListByQuery(CascadeEntity query) throws Exception;

	/**
	 * 保存某类型的实体对象
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	boolean  save(CascadeEntity entity) throws Exception;

	/**
	 * 修改实体对象信息
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	boolean update(CascadeEntity entity) throws  Exception;

	/**
	 * 根据主键查询对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	CascadeEntity getById(String id) throws Exception;

	/**
	 * 根据编码查询对象
	 * @param code
	 * @return
	 * @throws Exception
	 */
	CascadeEntity getByCode(String code) throws Exception;
}
