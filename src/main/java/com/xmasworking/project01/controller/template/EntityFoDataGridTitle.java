package com.xmasworking.project01.controller.template;

import org.apache.commons.collections.FastArrayList;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author XmasPiano
 * @date 2018/9/1 - 下午2:35
 * Created by IntelliJ IDEA.
 */
public class EntityFoDataGridTitle {
    private final Class cls;

    EntityFoDataGridTitle(Class cls){
        this.cls= cls;
    }

    public static List<DataGridEntity> getEntityFoDataGridTitle(Class cls){
        List<DataGridEntity> dataGridEntityList = new FastArrayList();

        DataGridEntity dataGridEntity = new DataGridEntity();
        dataGridEntity.setField("id");
        dataGridEntity.setTitle("ID");
        dataGridEntity.setWidth(60);
        dataGridEntity.setHidden(true);

        return dataGridEntityList;
    }
}