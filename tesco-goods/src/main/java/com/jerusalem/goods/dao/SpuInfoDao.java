package com.jerusalem.goods.dao;

import com.jerusalem.goods.entity.SpuInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/****
 * 持久层
 * spu信息
 * @author jerusalem
 * @email 3276586184@qq.com
 * @date 2020-04-09 14:48:19
 */
@Mapper
@Repository
public interface SpuInfoDao extends BaseMapper<SpuInfoEntity> {

    /***
     * 修改SPU的发布状态
     * @param spuId
     * @param code
     */
    void updateSpuStatus(@Param("spuId") Long spuId, @Param("code") int code);
}
