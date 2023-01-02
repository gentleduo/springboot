package org.duo.autoconfigure.service;

/**
 * 计算服务
 *
 * @author duo
 * @since 2023/1/1
 */
public interface CalculateService {

    /**
     * 从多个整数 sum 求和
     * @param values 多个整数
     * @return sum 累加值
     */
    Integer sum(Integer... values);
}
