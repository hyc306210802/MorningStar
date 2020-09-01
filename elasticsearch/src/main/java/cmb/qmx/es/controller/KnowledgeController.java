package cmb.qmx.es.controller;

import cmb.qmx.es.entity.Knowledge;
import cmb.qmx.es.entity.Student;
import cmb.qmx.es.service.KnowledgeService;
import cmb.qmx.es.utils.ResData;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

/**
 * @author 80254142
 * @description
 * @date
 */
@RestController
@RequestMapping("/student")
public class KnowledgeController {

    @Autowired
    private KnowledgeService studentService;

    /**
     *功能描述 录入学员信息
     * @author 80254142
     * @date 2020/8/25
     * @param knowledge 知识实体类
     * @return
     */
    @PostMapping("/add")
    public Object add(@RequestBody Knowledge knowledge) throws IOException {
        studentService.add(knowledge);
        return ResData.success(HttpStatus.ACCEPTED);
    }
    /**
     *功能描述 局部更新学员信息
     * @author 80254142
     * @date 2020/8/25
     * @param id 文档id
     * @param map 局部更新学员的内容
     * @return
     */
    @RequestMapping(value="/updateById/{id}")
    public String updateById(@PathVariable("id") String id,@RequestBody Map<String,Object> map) throws JsonProcessingException {
        return studentService.updateById(id,map);
    }
    /**
     *功能描述 根据学员姓名精确检索
     * @author 80254142
     * @date 2020/8/25
     * @param name 学员姓名
     * @return
     */
    @GetMapping("/searchByName")
    public String searchByName(@RequestParam("param")  String name){
        return studentService.searchByName(name);
    }
    /**
     *功能描述 根据学员爱好模糊检索
     * @author 80254142
     * @date 2020/8/25
     * @param interest 学员爱好
     * @return
     */
    @GetMapping("/searchByInterest")
    public String searchByInterest(@RequestParam("param") String interest){
        return studentService.searchByInterest(interest);
    }
    /**
     *功能描述 根据姓名进行排序
     * @author 80254142
     * @date 2020/8/25
     * @return
     */
    @GetMapping("/searchOrderByName")
    public String searchOrderByName(){
        return studentService.searchOrderByName();
    }
    /**
     *功能描述 根据字段值项分组聚合
     * @author 80254142
     * @date 2020/8/25
     * @return
     */
    @GetMapping("/termsAggregation")
    public String termsAggregation(){
        return studentService.termsAggregation();
    }
}
