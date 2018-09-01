package com.xmasworking.project01.controller.template;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 *
 * @author XmasPiano
 * @date 2018/9/1 - 下午2:28
 * Created by IntelliJ IDEA.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class DataGridEntity {
    String field;
    String title;
    int width = 20;
    boolean hidden = Boolean.FALSE;
}
