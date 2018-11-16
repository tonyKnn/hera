package com.dfire.common.mapper;

import com.dfire.common.entity.HeraAction;
import com.dfire.common.mybatis.action.HeraActionBatchInsertDriver;
import com.dfire.common.mybatis.HeraInsertLangDriver;
import com.dfire.common.mybatis.HeraSelectLangDriver;
import com.dfire.common.mybatis.HeraUpdateLangDriver;
import com.dfire.common.mybatis.action.HeraActionBatchUpdateDriver;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 上午11:03 2018/5/16
 * @desc 版本运行历史查询
 */
public interface HeraJobActionMapper {

    @Insert("insert into hera_action (#{heraAction})")
    @Lang(HeraInsertLangDriver.class)
    int insert(HeraAction heraAction1);

    @Insert("insert into hera_action (#{list})")
    @Lang(HeraActionBatchInsertDriver.class)
    int batchInsert(@Param("list") List<HeraAction> list);


    @Insert("update hera_action (#{list})")
    @Lang(HeraActionBatchUpdateDriver.class)
    int batchUpdate(@Param("list") List<HeraAction> list);

    @Delete("delete from hera_action where id = #{id}")
    int delete(@Param("id") String id);

    @Update("update hera_action (#{heraJobHistory}) where id = #{id}")
    @Lang(HeraUpdateLangDriver.class)
    int update(HeraAction heraJobHistory);

    @Select("select * from hera_action")
    List<HeraAction> getAll();

    @Select("select * from hera_action where id = #{id}")
    @Lang(HeraSelectLangDriver.class)
    HeraAction findById(HeraAction heraAction);

    @Select("select * from hera_action where job_id = #{jobId} order by id desc limit 1")
    HeraAction findLatestByJobId(HeraAction heraAction);

    @Select("select * from hera_action where job_id = #{jobId} order by id")
    List<HeraAction> findByJobId(HeraAction heraAction);

    @Update("update hera_action set status = #{status} where id = #{id}")
    Integer updateStatus(HeraAction heraAction);

    @Update("update hera_action set status = #{status},ready_dependency=#{readyDependency} where id = #{id}")
    Integer updateStatusAndReadDependency(HeraAction heraAction);
    @Select("select * from hera_action where id >= #{today}")
    List<HeraAction> selectTodayAction(String today);

}
