package ekgc.witmed.transport.dictionary;

import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.base.pojo.vo.PageQueryVO;
import ekgc.witmed.pojo.system.dictionary.entity.AllergySymptom;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "witmed-system-provider")
@RequestMapping("/system/allergySymptom/transport")
public interface AllergySymptomTransport {

	/**
	 * 分页查询
	 *
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page")
	PageVO<AllergySymptom> getPageListByQuery(@RequestBody PageQueryVO<AllergySymptom> queryVO) throws Exception;

	/**
	 * 根据查询对象，查询数据库返回列表
	 *
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	List<AllergySymptom> getListByQuery(@RequestBody AllergySymptom query) throws Exception;

	/**
	 * 保存某类型的实体对象
	 *
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	boolean save(@RequestBody AllergySymptom entity) throws Exception;

	/**
	 * 修改实体对象信息
	 *
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	boolean update(@RequestBody AllergySymptom entity) throws Exception;

	/**
	 * 根据主键查询对象
	 *
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id")
	AllergySymptom getById(@RequestParam String id) throws Exception;

	/**
	 * 根据编码查询对象
	 *
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code")
	AllergySymptom getByCode(@RequestParam String code) throws Exception;
}