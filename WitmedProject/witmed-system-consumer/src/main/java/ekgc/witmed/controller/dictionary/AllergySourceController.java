package ekgc.witmed.controller.dictionary;

import ekgc.witmed.base.controller.BaseController;
import ekgc.witmed.base.pojo.vo.PageVO;
import ekgc.witmed.base.pojo.vo.PageQueryVO;
import ekgc.witmed.base.pojo.vo.ResponseVO;
import ekgc.witmed.pojo.system.dictionary.entity.AllergySource;
import ekgc.witmed.transport.dictionary.AllergySourceTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("allergySourceController")
@RequestMapping("/system/allergySource")
public class AllergySourceController extends BaseController {
	@Autowired
	private AllergySourceTransport allergySourceTransport;

	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/page/{pageNum}/{pageSize}")
	public ResponseVO getPageListByQuery(@PathVariable("pageNum") Integer pageNum,
	                                     @PathVariable("pageSize") Integer pageSize,
	                                     @RequestBody AllergySource query) throws Exception{
		// 根据参数生成相应的 QueryVO 对象
		PageVO<AllergySource> pageVO = new PageVO<AllergySource>(pageNum,pageSize);
		PageQueryVO<AllergySource> queryVO = new PageQueryVO<>();
		queryVO.setQuery(query);
		queryVO.setPageVO(pageVO);
		// 进行分页查询
		pageVO = allergySourceTransport.getPageListByQuery(queryVO);
		return ResponseVO.getSuccessResponseVO(pageVO);
	}

	/**
	 * 根据查询对象，查询数据库返回列表
	 * @param query
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	public ResponseVO getListByQuery(@RequestBody AllergySource query) throws Exception{
		return  ResponseVO.getSuccessResponseVO(allergySourceTransport.getListByQuery(query));
	}

	/**
	 * 保存某类型的实体对象
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	public ResponseVO  save(@RequestBody AllergySource entity) throws Exception{
		// 先判断提交的 code 是否符合要求
		String code = entity.getCode();

		if(code != null && !"".equals(code)){
			// 此时 code 有值，判断是否已被使用
			AllergySource AllergySource = allergySourceTransport.getByCode(code);
			if(AllergySource != null){
				return ResponseVO.getErrorResponseVO("该编码已被使用，请重新输入");
			} else {
				if(allergySourceTransport.save(entity)){
					return ResponseVO.getSuccessResponseVO("保存成功！");
				}else{
					return ResponseVO.getErrorResponseVO("保存失败！");
				}
			}
		} else {
			return ResponseVO.getErrorResponseVO("请编码不能为空！");
		}
	}

	/**
	 * 修改实体对象信息
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	public ResponseVO update(@RequestBody AllergySource entity) throws  Exception{
		// 判断 code 是否合格
		String code = entity.getCode();
		if(code != null && !"".equals(code)){
			AllergySource AllergySource = allergySourceTransport.getByCode(code);
			if(AllergySource != null ){
				if(!AllergySource.getId().equals(entity.getId())){
					// 此时表示，修改后提交的信息中编码已被使用了
					return ResponseVO.getErrorResponseVO("该编码已被占用");
				}
			}
			// 此时可以提交修改
			if(allergySourceTransport.update(entity)){
				return ResponseVO.getSuccessResponseVO("修改成功");
			} else {
				return ResponseVO.getErrorResponseVO("修改失败");
			}
		}
		return ResponseVO.getErrorResponseVO("编码信息为必填项！");
	}

	/**
	 * 根据主键查询对象
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id/{id}")
	public ResponseVO getById(@PathVariable("id") String id) throws Exception{
		return ResponseVO.getSuccessResponseVO(allergySourceTransport.getById(id));
	}

	/**
	 * 根据编码查询对象
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/code/{code}")
	public ResponseVO getByCode(@PathVariable("code") String code) throws Exception{
		return ResponseVO.getSuccessResponseVO(allergySourceTransport.getByCode(code));

	}

}

