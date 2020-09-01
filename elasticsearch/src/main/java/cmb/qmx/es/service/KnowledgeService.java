package cmb.qmx.es.service;

import cmb.qmx.es.entity.Knowledge;
import cmb.qmx.es.entity.Student;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.util.Map;


/**
 * @author 80254142
 * @description
 * @date
 */
public interface KnowledgeService {
    /**
    *功能描述 录入学员信息
    * @author 80254142
    * @date 2020/8/25
    * @param student 学员实体类
    * @return
    */
    String add(Knowledge knowledge) throws IOException;
    /**
     *功能描述 局部更新学员信息
     * @author 80254142
     * @date 2020/8/25
     * @param id 文档id
     * @param map 局部更新学员的内容
     * @return
     */
    String updateById(String id,Map<String,Object> map);
    /**
     *功能描述 根据学员姓名精确检索
     * @author 80254142
     * @date 2020/8/25
     * @param name 学员姓名
     * @return
     */
    String searchByName(String name);
    /**
     *功能描述 根据学员爱好模糊检索
     * @author 80254142
     * @date 2020/8/25
     * @param interest 学员爱好
     * @return
     */
    String searchByInterest(String interest);
    /**
     *功能描述 根据姓名进行排序
     * @author 80254142
     * @date 2020/8/25
     * @return
     */
    String searchOrderByName();

    /**
     *功能描述 根据字段值项分组聚合
     * @author 80254142
     * @date 2020/8/25
     * @return
     */
    String termsAggregation();
}
