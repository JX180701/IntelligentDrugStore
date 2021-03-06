package org.great.quartz;

import java.util.List;

public class Analysis {
	/**
     * 二次指数平滑法求预测值
     * @param list 基础数据集合
     * @param year 未来第几期
     * @param modulus 平滑系数
     * @return 预测值
     */
    public static Double getExpect(List<Double> list, Double modulus ) {
        if (list.size() < 10 || modulus <= 0 || modulus >= 1) {
            return null;
        }
        Double modulusLeft = 1 - modulus;
        Double lastIndex = list.get(0);
        
        for (Double data :list) {
            lastIndex = modulus * data + modulusLeft * lastIndex;
            System.out.println(data);
           
        }
        Double result=list.get(list.size()-1)*modulus+modulusLeft*lastIndex;
        return result ;
    }
}
