package org.great.quartz;

import java.util.List;

public class Analysis {
	/**
     * ����ָ��ƽ������Ԥ��ֵ
     * @param list �������ݼ���
     * @param year δ���ڼ���
     * @param modulus ƽ��ϵ��
     * @return Ԥ��ֵ
     */
    public static Double getExpect(List<Double> list, Double modulus ) {
        if (list.size() < 10 || modulus <= 0 || modulus >= 1) {
            return null;
        }
        Double modulusLeft = 1 - modulus;
        Double lastIndex = list.get(0);
        
        for (Double data :list) {
            lastIndex = modulus * data + modulusLeft * lastIndex;
           
        }
        Double result=list.get(list.size()-1)*modulus+modulusLeft*lastIndex;
        return result ;
    }
}
